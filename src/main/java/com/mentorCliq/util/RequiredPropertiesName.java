package com.mentorCliq.util;

public enum RequiredPropertiesName {
    AGE("age"), DIVISION("division"), TIMEZONE("timezone");
    private String value;

    RequiredPropertiesName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
