package com.kwi.base;

import java.util.HashMap;
import java.util.Map;

public class QueryAttributes {

    private static QueryAttributes INSTANCE;
    private final Map<String, String> attributes;


    private QueryAttributes() {
        attributes = new HashMap<>();
    }

    public static QueryAttributes getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QueryAttributes();
        }
        return INSTANCE;
    }

    public void setQueryAttributes(String key, String value) {
        attributes.put(key, value);
    }

    public Map<String, String> getQueryAttributes() {
        return attributes;
    }

    public void clear() {
        attributes.clear();
    }
}
