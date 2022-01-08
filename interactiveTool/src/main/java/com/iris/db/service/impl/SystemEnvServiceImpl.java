package com.iris.db.service.impl;

import com.iris.db.service.SystemEnvService;
import org.springframework.stereotype.Component;

@Component
public class SystemEnvServiceImpl implements SystemEnvService {
    @Override
    public int prepareDatabase() {
        return 0;
    }
}
