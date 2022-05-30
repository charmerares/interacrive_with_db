package com.iris.db.service.internal.impl;

import com.iris.db.service.internal.SystemEnvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;


import java.sql.Connection;

@Component
@Slf4j
public class SystemEnvServiceImpl implements SystemEnvService {
    @Value("classpath:sql/update.sql")
    private Resource sqlResource;
    @Override
    public void prepareDatabase(Connection connection) {
        log.info("database start initial");
        ScriptUtils.executeSqlScript(connection, sqlResource);
    }
}
