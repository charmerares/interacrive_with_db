package com.iris.db.domain.constant;

public class SqlConstant {
    /**
     * common sql
     */
    public static final String INSERT_RECORD_SQL="insert into tb_record(record_id,record_point) value(?,?)";
    public static final String QUERY_RECORD_SQL="select * from tb_record where record_id=?";
    public static final String UPDATE_RECORD_SQL="update tb_record set record_point=? where record_id=?";
    public static final String DELETE_RECORD_SQL="delete from tb_record where record_id=?";

    /**
     * initial database
     */
    public static final String DATABASE_NAME="test";
    public static final String CHECK_DATABASE="select schema_name from information_schema.schemata where schema_name = '%s';";
}
