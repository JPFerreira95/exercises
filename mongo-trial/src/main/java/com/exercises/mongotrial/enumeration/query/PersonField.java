package com.exercises.mongotrial.enumeration.query;

import com.exercises.mongotrial.util.SearchField;

public enum PersonField implements SearchField {

    FIRST_NAME("firstName"),
    AGE("age"),
    CITY("addresses.city");

    private final String fieldName;

    PersonField(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String fieldName() {
        return this.fieldName;
    }
}
