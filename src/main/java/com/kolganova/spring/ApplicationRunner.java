package com.kolganova.spring;

import com.kolganova.spring.config.ApplicationConfiguration;
import com.kolganova.spring.database.pool.ConnectionPool;
import com.kolganova.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("prod", "web", "test");
            context.refresh();
            ConnectionPool connectionPool = context.getBean("p1", ConnectionPool.class);

            CompanyService companyService = context.getBean("companyService", CompanyService.class);
//            System.out.println(crudRepository.findById(1));
            System.out.println(companyService.findById(1));
        }
    }

}
