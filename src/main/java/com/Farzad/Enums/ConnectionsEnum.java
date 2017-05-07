package com.Farzad.Enums;

import POJOs.SVGSingleShape;

/**
 * Created by VOLCANO on 4/28/2017.
 */
public enum ConnectionsEnum {
    ACCESSES ("accesses"),
    USED_BY("used by"),
    ASSIGNED("assigned"),
    USES("uses"),
    AGGREGATION("aggregation"),
    ASSOCIATION("association"),
    REALISES("realises"),
    READ_AND_WRITE("read/write"),
    COMPOSITION("composition");
    private final  String name;

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public  String toString() {
        return this.name;
    }

    private ConnectionsEnum( String s) {
        name = s;
    }


}
