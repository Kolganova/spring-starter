package com.kolganova.spring;

import com.kolganova.spring.database.pool.ConnectionPool;
import com.kolganova.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            ConnectionPool connectionPool = context.getBean("p1", ConnectionPool.class);

            CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
//            System.out.println(crudRepository.findById(1));
            System.out.println(companyRepository.getPools().get(0));
            System.out.println(companyRepository.getPoolSize());

//            System.out.println(context.getBean("connectionPool", ConnectionPool.class));
//            System.out.println(context.getBean("connectionPool", ConnectionPool.class));
//            System.out.println(context.getBean("companyRepository", CompanyRepository.class));
        }
    }

}
