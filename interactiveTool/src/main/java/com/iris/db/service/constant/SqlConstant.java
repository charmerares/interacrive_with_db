package com.iris.db.service.constant;

public class SqlConstant {
    public static final String INSERT_RECORD_SQL="insert into tb_record(record_id,record_point) value(?,?)";
    public static final String QUERY_RECORD_SQL="select * from tb_record where record_id=?";
    public static final String UPDATE_RECORD_SQL="update tb_record set record_point=? where record_id=?";
    public static final String DELETE_RECORD_SQL="delete from tb_record where record_id=?";

}
