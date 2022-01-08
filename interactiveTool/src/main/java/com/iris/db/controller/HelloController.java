package com.iris.db.controller;

import com.iris.db.service.CollectDataStorageService;
import com.iris.db.domain.constant.CommonValueConstant;
import com.iris.db.domain.dao.StockRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private CollectDataStorageService collectDataStorageService;

    @GetMapping("/hello")
    public String hello(){
        StockRecord record=collectDataStorageService.getRecordById("1");
        return record==null? CommonValueConstant.NULL_RECORD:record.toString();
    }
}
