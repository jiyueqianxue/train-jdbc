package io.mine.ft.train.dao;


import lombok.Getter;

@Getter
public enum DatabaseType {
    OPS("OPS", "信贷云opsDB"),
    TRANS("TRANS", "信贷云前置DB"),
    FRONT("FRONT", "信贷云前置DB"),
    USER("USER", "信贷云额度DB");
    private String dbKey;
    private String dbDesc;

    DatabaseType(String dbKey, String dbDesc) {
        this.dbKey = dbKey;
        this.dbDesc = dbDesc;
    }
}
