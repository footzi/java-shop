package com.java_shop.DbConnection;

import java.util.HashMap;
import java.util.Map;

public class DbConnectionResult {
    Map<String, String> resultString = new HashMap<>();
    Map<String, Integer> resultInt = new HashMap<>();
    Map<String, Integer[]> resultArray = new HashMap<>();

    public void setFieldString(String name, String result) {
        this.resultString.put(name, result);
    }

    public void setFieldInt(String name, Integer result) {
        this.resultInt.put(name, result);
    }

    public void setFieldArray(String name, Integer[] result) {
        this.resultArray.put(name, result);
    }

    public String getFieldString(String name) {
        return this.resultString.get(name);
    }

    public Integer getFieldInt(String name) {
        return this.resultInt.get(name);
    }

    public Integer[] getFieldArray(String name) {
        return this.resultArray.get(name);
    }
}
