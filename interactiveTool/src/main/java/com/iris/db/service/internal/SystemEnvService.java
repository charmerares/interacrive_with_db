package com.iris.db.service.internal;

import java.sql.Connection;

public interface SystemEnvService {
    /**
     * 数据库未创建时初始化
     * @return
     */
    void prepareDatabase(Connection connection);
}
