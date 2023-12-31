package com.kolganova.spring.service;

import com.kolganova.spring.database.entity.Company;
import com.kolganova.spring.database.repository.CrudRepository;
import com.kolganova.spring.dto.CompanyReadDto;
import com.kolganova.spring.listener.entity.AccessType;
import com.kolganova.spring.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public Optional<CompanyReadDto> findById(Integer id) {
        System.out.println("Trying to find CompanyReadDto");
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }

}
