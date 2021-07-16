package com.iris.db.service.impl;

import com.iris.db.constant.CommonValueConstant;
import com.iris.db.constant.SqlConstant;
import com.iris.db.domain.StockRecord;
import com.iris.db.service.CollectDataStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;


public class CollectDataStorageServiceImpl implements CollectDataStorageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveRecord(StockRecord record) {
        int result=jdbcTemplate.update(SqlConstant.INSERT_RECORD_SQL,record.getRecordId(),
                record.getRecordPoint());
        return result;
    }

    @Override
    public StockRecord getRecordById(String stockRecordId) {
        StockRecord record=jdbcTemplate.queryForObject(SqlConstant.QUERY_RECORD_SQL, new BeanPropertyRowMapper<>(StockRecord.class),
                stockRecordId);

        return record;
    }

    @Override
    public List<StockRecord> getRecordListByTag(String tag) {
        return null;
    }

    @Override
    public boolean updateRecord(StockRecord record) {
        StockRecord queryObject=jdbcTemplate.queryForObject(SqlConstant.QUERY_RECORD_SQL, new BeanPropertyRowMapper<>(StockRecord.class),
                record.getRecordId());
        if(queryObject==null) {
            return false;
        }else {
            queryObject.setRecordPoint(record.getRecordPoint());
            int result = jdbcTemplate.update(SqlConstant.UPDATE_RECORD_SQL,
                    queryObject.getRecordPoint(), queryObject.getRecordId());
            //todo do we clear the result meaning? How use it?
            return result!=CommonValueConstant.NULL_RESULT;
        }
    }

    @Override
    public boolean deleteRecordWithoutCheck(StockRecord record) {
        return
        jdbcTemplate.update(SqlConstant.DELETE_RECORD_SQL,record.getRecordId())>
                CommonValueConstant.NULL_RESULT;
    }

    @Override
    public boolean deleteRecord(StockRecord record) {
        if(!deleteRecordWithoutCheck(record)){
            return false;
        }
        StockRecord queryRecord=getRecordById(record.getRecordId());
        return queryRecord == null;
    }
}
