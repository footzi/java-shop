package com.java_shop.DbConnection;

import java.util.HashMap;
import java.util.Map;

public class DBConnectionInput {
    Map<String, String> map = new HashMap<>();

    public DBConnectionInput addField(String name, String type) {
        this.map.put(name, type);

        return this;
    }

    public Map<String, String> getInputMap() {
        return this.map;
    }
}
