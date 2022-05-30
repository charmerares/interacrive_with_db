package com.iris.db.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StockRecord{
    private String recordId;
    private double recordPoint;
    private Date date;
}
