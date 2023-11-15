package com.kolganova.spring.database.repository;

import com.kolganova.spring.database.entity.Company;
import com.kolganova.spring.database.pool.ConnectionPool;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

//@Transaction
//@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

//    @Resource(name = "p1")
    @Autowired
    private ConnectionPool p1;
    @Getter
    @Autowired
    private List<ConnectionPool> pools;
    @Getter
    @Value("${db.pool.size}")
    private Integer poolSize;
    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("finById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Autowired
    public void setP1(ConnectionPool p1) {
        this.p1 = p1;
    }

}
