package com.iris.db.domain.dao.impl;

import com.iris.db.domain.constant.CommonValueConstant;
import com.iris.db.domain.constant.SqlConstant;
import com.iris.db.domain.dao.StockRecordDao;
import com.iris.db.domain.entity.StockRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class StockRecordDaoImpl implements StockRecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int saveRecord(StockRecord record) {
        int result=jdbcTemplate.update(SqlConstant.INSERT_RECORD_SQL,record.getRecordId(),
                record.getRecordPoint());
        return result;
    }

    public StockRecord getRecordById(String stockRecordId) {
        log.info("start query database");
        StockRecord record;
        try {
             record = jdbcTemplate.queryForObject(SqlConstant.QUERY_RECORD_SQL, new BeanPropertyRowMapper<>(StockRecord.class),
                    stockRecordId);
        }catch (EmptyResultDataAccessException e){
            record=null;
        }
        return record;
    }

    public List<StockRecord> getRecordListByTag(String tag) {
        return null;
    }

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

    public boolean deleteRecordWithoutCheck(StockRecord record) {
        return
        jdbcTemplate.update(SqlConstant.DELETE_RECORD_SQL,record.getRecordId())>
                CommonValueConstant.NULL_RESULT;
    }

    public boolean deleteRecord(StockRecord record) {
        if(!deleteRecordWithoutCheck(record)){
            return false;
        }
        StockRecord queryRecord=getRecordById(record.getRecordId());
        return queryRecord == null;
    }
}
