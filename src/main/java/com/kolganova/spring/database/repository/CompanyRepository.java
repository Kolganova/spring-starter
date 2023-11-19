package com.kolganova.spring.database.repository;

import com.kolganova.spring.database.entity.Company;
import com.kolganova.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Transaction
//@Auditing
@Slf4j
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Repository
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool p1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private Integer poolSize;

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("finById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        log.warn("delete method...");
    }

    @PostConstruct
    private void init() {
        log.warn("init company repository");
    }

}
