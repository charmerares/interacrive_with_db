package com.iris.db.service.impl;

import com.iris.db.service.CollectDataService;
import com.iris.db.service.internal.DataProcessService;
import com.iris.db.service.internal.DataStoreService;
import com.iris.db.service.internal.OnlineDataCollectService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Raccoon
 * @Date: 2022/5/29 22:44
 */
public class CollectDataServiceImpl implements CollectDataService {
    @Autowired
    private OnlineDataCollectService onlineDataCollectService;
    @Autowired
    private DataProcessService dataProcessService;
    @Autowired
    private DataStoreService dataStoreService;

    @Override
    public void startCollectData() {
        Object data =onlineDataCollectService.startCollectDataFromWeb();
        Object afterProcessData=dataProcessService.processData(data);
        dataStoreService.storeData(afterProcessData);
    }
}
