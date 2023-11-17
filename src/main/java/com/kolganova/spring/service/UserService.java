package com.kolganova.spring.service;

import com.kolganova.spring.database.entity.Company;
import com.kolganova.spring.database.repository.CrudRepository;
import com.kolganova.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;


}
