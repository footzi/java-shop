package com.java_shop.DbConnection;

import java.util.HashMap;
import java.util.Map;

public class DbConnectionResult {
    Map<String, String> resultString = new HashMap<>();
    Map<String, Integer> resultInt = new HashMap<>();

    public void setFieldString(String name, String result) {
        this.resultString.put(name, result);
    }

    public void setFieldInt(String name, int result) {
        this.resultInt.put(name, result);
    }

    public String getFieldString(String name) {
        return this.resultString.get(name);
    }

    public int getFieldInt(String name) {
        return this.resultInt.get(name);
    }
}
