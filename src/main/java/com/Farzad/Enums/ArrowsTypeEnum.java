package com.Farzad.Enums;

/**
 * Created by FARzad - VOLCANO on 5/5/2017.
 */
public enum ArrowsTypeEnum {
    TRIANGLE_WHITE ("triangle_white"),
    TRIANGLE_BLACK("triangle_black"),
    DIAMOND_BLACK("diamond_black"),
    DIAMOND_WHITE ("diamond_white"),
    V_TYPE("v_type");

    private final  String name;

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public  String toString() {
        return this.name;
    }

    private ArrowsTypeEnum( String s) {
        name = s;
    }

}
