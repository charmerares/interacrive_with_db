package com.iris.db.controller;

import com.iris.db.domain.dao.StockRecordDao;
import com.iris.db.domain.constant.CommonValueConstant;
import com.iris.db.domain.entity.StockRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private StockRecordDao stockRecordDao;

    //just for test
    @GetMapping("/hello")
    public String hello(){
        StockRecord record= stockRecordDao.getRecordById("1");
        return record==null? CommonValueConstant.NULL_RECORD:record.toString();
    }
}
