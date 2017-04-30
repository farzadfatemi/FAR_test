package com.Farzad.Enums;

import POJOs.SVGSingleShape;

/**
 * Created by VOLCANO on 4/30/2017.
 */
public enum IconsEnum {
    COLLABORATION_APPLICATION ("collaboration_application"),
    COMPONANT_APPLICATION ("componant_application"),
    FUNCTION_APPLICATION ("function_application"),
    INTERACTION_APPLICATION ("interaction_application"),
    INTERFACE_APPLICATION ("interface_application"),
    OBJECT_APPLICATION ("object_application"),
    SERVICE_APPLICATION ("service_application"),
    ACTOR_BUSINESS("actor_business"),
    COLLABORATION_BUSINESS("collaboration_business"),
    EVENT_BUSINESS("event_business"),
    FUNCTION_BUSINESS("function_business"),
    INTERACTION_BUSINESS("interaction_business"),
    INTERFACE_BUSINESS("interface_business"),
    LOCATION_BUSINESS("location_business"),
    MEANING_BUSINESS("meaning_business"),
    OBJECT_BUSINESS("object_business"),
    PROCESS_BUSINESS("process_business"),
    PRODUCT_BUSINESS("product_business"),
    REPRESENTATION_BUSINESS("representation_business"),
    SERVICE_BUSINESS("service_business"),
    STAKEHOLDER_BUSINESS("stakeholder_business"),
    VALUE_BUSINESS("value_business"),
    ASSESSMENT_GOALS("assessment_goals"),
    CONSTRAINT_GOALS("constraint_goals"),
    DRIVER_GOALS("driver_goals"),
    GAP_GOALS("gap_goals"),
    GOAL_GOALS("goal_goals"),
    PLATEAU_GOALS("plateau_goals"),
    PRINCIPAL_GOALS("principal_goals"),
    REPRESENTATION_GOALS("representation_goals"),
    REQUIREMENT_GOALS("requirement_goals"),
    ROLE_GOALS("role_goals"),
    UNAMED_GOALS("unamed_goals"),
    MAPS("maps"),
    MAP_BLUE_STRATAMAP("map_blue_stratamap"),
    MAP_GREEN_STRATAMAP("map_green_stratamap"),
    MAP_OUTLINE_STRATAMAP("map_outline_stratamap"),
    STRATAMAP_BLUE_STRATAMAP("stratamap_blue_stratamap"),
    STRATAMAP_GREEN_STRATAMAP("stratamap_green_stratamap"),
    STRATAMAP_OUTLINE_STRATAMAP("stratamap_outline_stratamap"),
    ARTIFACT_TECHNOLOGY("artifact_technology"),
    COMMUNICATION_PATH_TECHNOLOGY("communication path_technology"),
    DATABASE_TECHNOLOGY("database_technology"),
    DEVICE_TECHNOLOGY("device_technology"),
    FUNCTION_TECHNOLOGY("function_technology"),
    INTERFACE_TECHNOLOGY("interface_technology"),
    NETWORK_TECHNOLOGY("network_technology"),
    NODE_TECHNOLOGY("node_technology"),
    SERVICE_TECHNOLOGY("service_technology"),
    SYSTEM_SOFTWARE_TECHNOLOGY("system_software_technology");

    private final java.lang.String name;

    public boolean equalsName(java.lang.String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public java.lang.String toString() {
        return this.name;
    }

    private IconsEnum(java.lang.String s) {
        name = s;
    }

    public java.lang.String


    iconSVGCode(SVGSingleShape svgShape) {
        int x = svgShape.getX() + svgShape.getWidth() - 30;
        int y = svgShape.getY() + 5;
        int width = 30;
        int height = 30;
        switch (this) {
            case COLLABORATION_APPLICATION :
                return  "<image x=\"" + x + "\" y=\"" + y + "\" width=\""+width+"\" height=\""+height+"\" xlink:href=\"src/main/images/Collaboration_Application.svg\"/>";
            case COMPONANT_APPLICATION:
                return  "";
            case FUNCTION_APPLICATION:
                return  "";
            case INTERACTION_APPLICATION:
                return  "";
            case INTERFACE_APPLICATION:
                return  "";
            case OBJECT_APPLICATION:
                return  "";
            case  SERVICE_APPLICATION:
                return  "";
             case  ACTOR_BUSINESS:
                return  "";
             case  COLLABORATION_BUSINESS:
                return  "";
             case  EVENT_BUSINESS:
                return  "";
             case  FUNCTION_BUSINESS:
                return  "";
             case  INTERACTION_BUSINESS:
                return  "";
             case  INTERFACE_BUSINESS:
                return  "";
             case  LOCATION_BUSINESS:
                return  "";
             case  MEANING_BUSINESS:
                return  "";
             case  OBJECT_BUSINESS:
                return  "";
             case  PROCESS_BUSINESS:
                return  "";
             case  PRODUCT_BUSINESS:
                return  "";
             case  REPRESENTATION_BUSINESS:
                return  "";
             case  SERVICE_BUSINESS:
                return  "";
             case  STAKEHOLDER_BUSINESS:
                return  "";
             case  VALUE_BUSINESS:
                return  "";
             case  ASSESSMENT_GOALS:
                return  "";
             case  CONSTRAINT_GOALS:
                return  "";
             case  DRIVER_GOALS:
                return  "";
             case  GAP_GOALS:
                return  "";
             case  GOAL_GOALS:
                return  "";
             case  PLATEAU_GOALS:
                return  "";
             case  PRINCIPAL_GOALS:
                return  "";
             case  REPRESENTATION_GOALS:
                return  "";
             case  REQUIREMENT_GOALS:
                return  "";
             case  ROLE_GOALS:
                return  "";
             case  UNAMED_GOALS:
                return  "";
             case  MAPS:
                return  "";
             case  MAP_BLUE_STRATAMAP:
                return  "";
             case  MAP_GREEN_STRATAMAP:
                return  "";
             case  MAP_OUTLINE_STRATAMAP:
                return  "";
             case  STRATAMAP_BLUE_STRATAMAP:
                return  "";
             case  STRATAMAP_GREEN_STRATAMAP:
                return  "";
             case  STRATAMAP_OUTLINE_STRATAMAP:
                return  "";
             case  ARTIFACT_TECHNOLOGY:
                return  "";
             case  COMMUNICATION_PATH_TECHNOLOGY:
                return  "";
             case DATABASE_TECHNOLOGY :
                return  "";
             case DEVICE_TECHNOLOGY :
                return  "";
             case  FUNCTION_TECHNOLOGY:
                return  "";
             case  INTERFACE_TECHNOLOGY:
                return  "";
             case  NETWORK_TECHNOLOGY:
                return  "";
             case  NODE_TECHNOLOGY:
                return  "";
             case  SERVICE_TECHNOLOGY:
                return  "";
             case  SYSTEM_SOFTWARE_TECHNOLOGY:
                return  "";
             default:
                return  "";
        }
    }
}
