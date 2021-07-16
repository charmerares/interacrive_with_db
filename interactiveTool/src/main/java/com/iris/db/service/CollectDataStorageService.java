package com.iris.db.service;

import com.iris.db.domain.StockRecord;

import java.util.List;

public interface CollectDataStorageService {
    /**
     * save record
     * @param record
     */
    int saveRecord(StockRecord record);

    /**
     * find record by default id
     * @param stockRecordId
     * @return
     */
    StockRecord getRecordById(String stockRecordId);

    /**
     * giving tag to find record, this method may get indefinite quantity records
     * @param tag
     * @return
     */
    List<StockRecord> getRecordListByTag(String tag);

    /**
     * change something for record
     * @param record
     * @return
     */
    boolean updateRecord(StockRecord record);

    /**
     * delete record, this method will not check whether the record is really deleted
     * @param record
     * @return
     */
    boolean deleteRecordWithoutCheck(StockRecord record);

    /**
     * delete record,then check the record is really deleted
     * @param record
     * @return
     */
    boolean deleteRecord(StockRecord record);
}
