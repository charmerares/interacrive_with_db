package com.iris.db.constant;

public class SqlConstant {
    public static final String INSERT_RECORD_SQL="insert into tb_record(recordId,recordPoint) value(?,?)";
    public static final String QUERY_RECORD_SQL="select * from tb_record where recordId=?";
    public static final String UPDATE_RECORD_SQL="update tb_record set recordPoint=? where recordId=?";
    public static final String DELETE_RECORD_SQL="delete from tb_record where recordId=?";

}
