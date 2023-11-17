package com.kolganova.spring.config;

import com.kolganova.spring.database.pool.ConnectionPool;
import com.kolganova.spring.database.repository.UserRepository;
import com.kolganova.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@ImportResource("classpath:application.xml")
@Import({
        WebConfiguration.class
})
@Configuration
//@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages = "com.kolganova.spring",
//        useDefaultFilters = false,
//        includeFilters = {
//                @Filter(type = FilterType.ANNOTATION, value = Component.class),
//                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
//                @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository"),
//        })
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 10);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }

    @Bean
    @Profile("prod&web")
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3() {
        return new UserRepository(pool3());
    }

}
