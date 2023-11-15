package com.kolganova.spring.database.repository;

import com.kolganova.spring.bpp.InjectBin;
import com.kolganova.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBin
    private ConnectionPool connectionPool;


}
