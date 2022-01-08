package com.iris.db.service;

public interface SystemEnvService {
    /**
     * 数据库未创建时初始化
     * @return
     */
    int prepareDatabase();
}
