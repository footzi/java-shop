package com.java_shop.DbConnection;

import java.util.ArrayList;
import java.util.List;

public class DbConnectionResultList {
    List<DbConnectionResult> list = new ArrayList<DbConnectionResult>();

    public void add(DbConnectionResult result) {
        this.list.add(result);
    }

    public List<DbConnectionResult> getList() {
        return list;
    }
}
