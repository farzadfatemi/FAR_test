package com.Farzad.Enums;

/**
 * Created by VOLCANO on 4/28/2017.
 */
public enum ConnectionsEnum {
    ACCESSES ("AccessRelationship"),
    USED_BY("UsedByRelationship"),
    ASSIGNED("AssignmentRelationship"),
    USES("UsesRelationship"),
    AGGREGATION("AggregationRelationship"),
    ASSOCIATION("AssociationRelationship"),
    REALISES("RealisationRelationship"),
//    READ_AND_WRITE("read/write"),
    SPECIALIZATION("SpecialisationRelationship"),
    COMPOSITION("CompositionRelationship");
    private final  String name;

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.toLowerCase().equals(otherName);
    }

    public  String toString() {
        return this.name;
    }

    private ConnectionsEnum( String s) {
        name = s;
    }


}
