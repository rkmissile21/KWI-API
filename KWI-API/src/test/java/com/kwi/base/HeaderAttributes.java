package com.kwi.base;

import java.util.HashMap;
import java.util.Map;

public class HeaderAttributes {

    private static HeaderAttributes INSTANCE;
    private final Map<String, String> attributes;


    private HeaderAttributes() {
        attributes = new HashMap<>();
    }

    public static HeaderAttributes getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HeaderAttributes();
        }
        return INSTANCE;
    }

    public void setHeaderAttributes(String key, String value) {
        attributes.put(key, value);
    }

    public Map<String, String> getHeaderAttributes() {
        return attributes;
    }

    public void clear() {
        attributes.clear();
    }
}
