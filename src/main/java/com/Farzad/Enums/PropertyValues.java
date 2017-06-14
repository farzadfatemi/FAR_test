package com.Farzad.Enums;

/**
 * Created by FARzad - VOLCANO on 6/14/2017.
 */
public enum PropertyValues {
    ICON ("_icon");

    private final  String name;

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public  String toString() {
        return this.name;
    }

    private PropertyValues( String s) {
        name = s;
    }
}
