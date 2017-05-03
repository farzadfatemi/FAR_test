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
    READ_AND_WRITE("read/write");
    private final java.lang.String name;

    public boolean equalsName(java.lang.String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public java.lang.String toString() {
        return this.name;
    }

    private ConnectionsEnum(java.lang.String s) {
        name = s;
    }


}
