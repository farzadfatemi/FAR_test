package com.farzad.enums;

/**
 * Created by VOLCANO on 5/2/2017.
 */
public enum ArchiEnum {
    APPLICATION_COLLABORATION(Category.APPLICATION),
    APPLICATION_COMPONENT(Category.APPLICATION),
    APPLICATION_FUNCTION(Category.APPLICATION),
    APPLICATION_INTERACTION(Category.APPLICATION),
    APPLICATION_INTERFACE(Category.APPLICATION),
    APPLICATION_OBJECT(Category.APPLICATION),
    APPLICATION_SERVICE(Category.APPLICATION),
    BUSINESS_ACTOR(Category.BUSINESS),
    BUSINESS_COLLABORATION(Category.BUSINESS),
    BUSINESS_EVENT(Category.BUSINESS),
    BUSINESS_FUNCTION(Category.BUSINESS),
    BUSINESS_INTERACTION(Category.BUSINESS),
    BUSINESS_INTERFACE(Category.BUSINESS),
    BUSINESS_LOCATION(Category.BUSINESS),
    BUSINESS_MEANING(Category.BUSINESS),
    BUSINESS_OBJECT(Category.BUSINESS),
    BUSINESS_PROCESS(Category.BUSINESS),
    BUSINESS_PRODUCT(Category.BUSINESS),
    BUSINESS_REPRESENTATION(Category.BUSINESS),
    BUSINESS_ROLE(Category.BUSINESS),
    BUSINESS_SERVICE(Category.BUSINESS),
    BUSINESS_STAKEHOLDER(Category.BUSINESS),
    BUSINESS_VALUE(Category.BUSINESS),
    GOALS_ASSESSMENT(Category.GOALS),
    GOALS_CONSTRAINT(Category.GOALS),
    GOALS_DRIVER(Category.GOALS),
    GOALS_GAP(Category.GOALS),
    GOALS_GOAL(Category.GOALS),
    GOALS_PLATEAU(Category.GOALS),
    GOALS_PRINCIPAL(Category.GOALS),
    GOALS_REPRESENTATION(Category.GOALS),
    GOALS_REQUIREMENT(Category.GOALS),
    GOALS_ROLE(Category.GOALS),
    GOALS_UNAMED(Category.GOALS),
    MAPS(Category.MAPS),
    MAP_BLUE_STRATAMAP(Category.STRATAMAP_MAPS),
    MAP_GREEN_STRATAMAP(Category.STRATAMAP_MAPS),
    MAP_OUTLINE_STRATAMAP(Category.STRATAMAP_MAPS),
    STRATAMAP_BLUE_STRATAMAP(Category.STRATAMAP_MAPS),
    STRATAMAP_GREEN_STRATAMAP(Category.STRATAMAP_MAPS),
    STRATAMAP_OUTLINE_STRATAMAP(Category.STRATAMAP_MAPS),
    TECHNOLOGY_ARTIFACT(Category.TECHNOLOGY),
    TECHNOLOGY_COMMUNICATION_PATH(Category.TECHNOLOGY),
    TECHNOLOGY_DATABASE(Category.TECHNOLOGY),
    TECHNOLOGY_DEVICE(Category.TECHNOLOGY),
    TECHNOLOGY_FUNCTION(Category.TECHNOLOGY),
    TECHNOLOGY_INTERFACE(Category.TECHNOLOGY),
    TECHNOLOGY_NETWORK(Category.TECHNOLOGY),
    TECHNOLOGY_NODE(Category.TECHNOLOGY),
    TECHNOLOGY_SERVICE(Category.TECHNOLOGY),
    TECHNOLOGY_SYSTEM_SOFTWARE(Category.TECHNOLOGY),
    CONTRACT(Category.BUSINESS),
    LOCATION(Category.LOCATION),
    DATA_OBJECT(Category.DATA_OBJECT),
    ARTIFACT(Category.ARTIFACT),
    NETWORK(Category.NETWORK),
    DEVICE(Category.DEVICE),
    INFRASTRUCTURE_INTERFACE(Category.INFRASTRUCTURE),
    INFRASTRUCTURE_SERVICE(Category.INFRASTRUCTURE),
    SYSTEM_SOFTWARE(Category.SYSTEM_SOFTWARE),
    NODE(Category.INFRASTRUCTURE),
    GROUP(Category.GROUP),
    MEANING(Category.MEANING),
    COMMUNICATION_PATH(Category.COMMUNICATION_PATH),
    DATABASE(Category.DATABASE),
    NOTE(Category.NOTE),
    DEFAULT(Category.DEFAULT);
    //    private final String name;
    private Category category;

    ArchiEnum(Category category) {
        this.category = category;
    }

    public enum Category {
        APPLICATION,
        BUSINESS,
        GOALS,
        MAPS,
        STRATAMAP_MAPS,
        TECHNOLOGY,
        LOCATION,
        DATA_OBJECT,
        ARTIFACT,
        DEVICE,
        NETWORK,
        INFRASTRUCTURE,
        SYSTEM_SOFTWARE,
        INDIVIDUAL,
        GROUP,
        MEANING,
        COMMUNICATION_PATH,
        DATABASE,
        NOTE,
        DEFAULT;
    }

    public String categoryToString() {
        switch (this.category) {
            case APPLICATION:
                return "application";
            case BUSINESS:
                return "business";
            case GOALS:
                return "goals";
            case MAPS:
                return "maps";
            case STRATAMAP_MAPS:
                return "stratamap_maps";
            case TECHNOLOGY:
                return "technology";
            case LOCATION:
                return "location";
            case DATA_OBJECT:
                return "dataObject";
            case ARTIFACT:
                return "artifact";
            case NETWORK:
                return "network";
            case DEVICE:
                return "device";
            case INFRASTRUCTURE:
                return "infrastructure";
            case SYSTEM_SOFTWARE:
                return "system_software";
            case INDIVIDUAL:
                return "individual";
            case GROUP:
                return "group";
            case MEANING:
                return "meaning";
            case COMMUNICATION_PATH:
                return "communicationpath";
            case DATABASE:
                return "database";
            case NOTE:
                return "note";
            case DEFAULT:
                return "default";
            default:
                return null;
        }
    }

    public String getStringValue() {
        switch (this) {
            case APPLICATION_COLLABORATION:
                return "ApplicationCollaboration";
            case APPLICATION_COMPONENT:
                return "ApplicationComponent";
            case APPLICATION_FUNCTION:
                return "ApplicationFunction";
            case APPLICATION_INTERACTION:
                return "ApplicationInteraction";
            case APPLICATION_INTERFACE:
                return "ApplicationInterface";
            case APPLICATION_OBJECT:
                return "ApplicationObject";
            case APPLICATION_SERVICE:
                return "ApplicationService";
            case BUSINESS_ACTOR:
                return "BusinessActor";
            case BUSINESS_COLLABORATION:
                return "BusinessCollaboration";
            case BUSINESS_EVENT:
                return "BusinessEvent";
            case BUSINESS_FUNCTION:
                return "BusinessFunction";
            case BUSINESS_INTERACTION:
                return "BusinessInteraction";
            case BUSINESS_INTERFACE:
                return "BusinessInterface";
            case BUSINESS_LOCATION:
                return "BusinessLocation";
            case BUSINESS_MEANING:
                return "BusinessMeaning";
            case BUSINESS_OBJECT:
                return "BusinessObject";
            case BUSINESS_PROCESS:
                return "BusinessProcess";
            case BUSINESS_PRODUCT:
                return "BusinessProduct";
            case BUSINESS_REPRESENTATION:
                return "BusinessRepresentation";
            case BUSINESS_ROLE:
                return "BusinessRole";
            case BUSINESS_SERVICE:
                return "BusinessService";
            case BUSINESS_STAKEHOLDER:
                return "BusinessStakeholder";
            case BUSINESS_VALUE:
                return "BusinessValue";
            case GOALS_ASSESSMENT:
                return "GoalsAssessment";
            case GOALS_CONSTRAINT:
                return "GoalsConstraint";
            case GOALS_DRIVER:
                return "GoalsDriver";
            case GOALS_GAP:
                return "GoalsGap";
            case GOALS_GOAL:
                return "GoalsGoal";
            case GOALS_PLATEAU:
                return "GoalsPlateau";
            case GOALS_PRINCIPAL:
                return "GoalsPrincipal";
            case GOALS_REPRESENTATION:
                return "GoalsRepresentation";
            case GOALS_REQUIREMENT:
                return "GoalsRequirement";
            case GOALS_ROLE:
                return "GoalsRole";
            case GOALS_UNAMED:
                return "GoalsUnamed";
            case MAPS:
                return "Maps";
            case MAP_BLUE_STRATAMAP:
                return "StratamapMapBlue";
            case MAP_GREEN_STRATAMAP:
                return "StratamapMapGreen";
            case MAP_OUTLINE_STRATAMAP:
                return "StratamapMapOutline";
            case STRATAMAP_BLUE_STRATAMAP:
                return "StratamapStratamapBblue";
            case STRATAMAP_GREEN_STRATAMAP:
                return "StratamapStratamapGreen";
            case STRATAMAP_OUTLINE_STRATAMAP:
                return "StratamapStratamapOutline";
            case TECHNOLOGY_ARTIFACT:
                return "TechnologyArtifact";
            case TECHNOLOGY_COMMUNICATION_PATH:
                return "TechnologyCommunicationPath";
            case TECHNOLOGY_DATABASE:
                return "TechnologyDatabase";
            case TECHNOLOGY_DEVICE:
                return "TechnologyDevice";
            case TECHNOLOGY_FUNCTION:
                return "TechnologyFunction";
            case TECHNOLOGY_INTERFACE:
                return "TechnologyInterface";
            case TECHNOLOGY_NETWORK:
                return "TechnologyNetwork";
            case TECHNOLOGY_NODE:
                return "TechnologyNode";
            case TECHNOLOGY_SERVICE:
                return "TechnologyService";
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return "TechnologySystemSoftware";
            case LOCATION:
                return "Location";
            case CONTRACT:
                return "Contract";
            case DATA_OBJECT:
                return "DataObject";
            case ARTIFACT:
                return "Artifact";
            case NETWORK:
                return "Network";
            case DEVICE:
                return "Device";
            case INFRASTRUCTURE_INTERFACE:
                return "InfrastructureInterface";
            case INFRASTRUCTURE_SERVICE:
                return "InfrastructureService";
            case NODE:
                return "node";
            case GROUP:
                return "DiagramModelGroup";
            case SYSTEM_SOFTWARE:
                return "SystemSoftware";
            case MEANING:
                return "Meaning";
            case COMMUNICATION_PATH:
                return "CommunicationPath";
            case DATABASE:
                return "Database";
             case NOTE:
                return "DiagramModelNote";
            default:
                return null;
        }
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
//        System.out.println("%%%%%%%%%%%%  Other name : "+otherName +" getStringValue() : " + (getStringValue() !=null?getStringValue().toLowerCase():"")
//                + " -- " + (otherName != null && getStringValue()!=null && getStringValue().toLowerCase().equals(otherName.toLowerCase())));
        return otherName != null && getStringValue() != null && getStringValue().toLowerCase().equals(otherName.toLowerCase());
    }

    public static ArchiEnum getArchiEnum(String value){
        if (ArchiEnum.APPLICATION_COLLABORATION.equalsName(value)) {
            return ArchiEnum.APPLICATION_COLLABORATION;

        } else if (ArchiEnum.APPLICATION_COMPONENT.equalsName(value)) {
            return ArchiEnum.APPLICATION_COMPONENT;

        } else if (ArchiEnum.APPLICATION_FUNCTION.equalsName(value)) {
            return ArchiEnum.APPLICATION_FUNCTION;

        } else if (ArchiEnum.APPLICATION_INTERACTION.equalsName(value)) {
            return ArchiEnum.APPLICATION_INTERACTION;

        } else if (ArchiEnum.APPLICATION_INTERFACE.equalsName(value)) {
            return ArchiEnum.APPLICATION_INTERFACE;

        } else if (ArchiEnum.APPLICATION_OBJECT.equalsName(value)) {
            return ArchiEnum.APPLICATION_OBJECT;

        } else if (ArchiEnum.APPLICATION_SERVICE.equalsName(value)) {
            return ArchiEnum.APPLICATION_SERVICE;

        } else if (ArchiEnum.BUSINESS_ACTOR.equalsName(value)) {
            return ArchiEnum.BUSINESS_ACTOR;

        } else if (ArchiEnum.BUSINESS_COLLABORATION.equalsName(value)) {
            return ArchiEnum.BUSINESS_COLLABORATION;

        } else if (ArchiEnum.BUSINESS_EVENT.equalsName(value)) {
            return ArchiEnum.BUSINESS_EVENT;

        } else if (ArchiEnum.BUSINESS_FUNCTION.equalsName(value)) {
            return ArchiEnum.BUSINESS_FUNCTION;

        } else if (ArchiEnum.BUSINESS_INTERACTION.equalsName(value)) {
            return ArchiEnum.BUSINESS_INTERACTION;

        } else if (ArchiEnum.BUSINESS_INTERFACE.equalsName(value)) {
            return ArchiEnum.BUSINESS_INTERFACE;

        } else if (ArchiEnum.BUSINESS_LOCATION.equalsName(value)) {
            return ArchiEnum.BUSINESS_LOCATION;

        } else if (ArchiEnum.BUSINESS_MEANING.equalsName(value)) {
            return ArchiEnum.BUSINESS_MEANING;

        } else if (ArchiEnum.BUSINESS_OBJECT.equalsName(value)) {
            return ArchiEnum.BUSINESS_OBJECT;

        } else if (ArchiEnum.BUSINESS_PROCESS.equalsName(value)) {
            return ArchiEnum.BUSINESS_PROCESS;

        } else if (ArchiEnum.BUSINESS_PRODUCT.equalsName(value)) {
            return ArchiEnum.BUSINESS_PRODUCT;

        } else if (ArchiEnum.BUSINESS_ROLE.equalsName(value)) {
            return ArchiEnum.BUSINESS_ROLE;

        } else if (ArchiEnum.BUSINESS_REPRESENTATION.equalsName(value)) {
            return ArchiEnum.BUSINESS_REPRESENTATION;

        } else if (ArchiEnum.BUSINESS_SERVICE.equalsName(value)) {
            return ArchiEnum.BUSINESS_SERVICE;

        } else if (ArchiEnum.BUSINESS_STAKEHOLDER.equalsName(value)) {
            return ArchiEnum.BUSINESS_STAKEHOLDER;

        } else if (ArchiEnum.BUSINESS_VALUE.equalsName(value)) {
            return ArchiEnum.BUSINESS_VALUE;

        } else if (ArchiEnum.GOALS_ASSESSMENT.equalsName(value)) {
            return ArchiEnum.GOALS_ASSESSMENT;

        } else if (ArchiEnum.GOALS_CONSTRAINT.equalsName(value)) {
            return ArchiEnum.GOALS_CONSTRAINT;

        } else if (ArchiEnum.GOALS_DRIVER.equalsName(value)) {
            return ArchiEnum.GOALS_DRIVER;

        } else if (ArchiEnum.GOALS_GAP.equalsName(value)) {
            return ArchiEnum.GOALS_GAP;

        } else if (ArchiEnum.GOALS_GOAL.equalsName(value)) {
            return ArchiEnum.GOALS_GOAL;

        } else if (ArchiEnum.GOALS_PLATEAU.equalsName(value)) {
            return ArchiEnum.GOALS_PLATEAU;

        } else if (ArchiEnum.GOALS_PRINCIPAL.equalsName(value)) {
            return ArchiEnum.GOALS_PRINCIPAL;

        } else if (ArchiEnum.GOALS_REPRESENTATION.equalsName(value)) {
            return ArchiEnum.GOALS_REPRESENTATION;

        } else if (ArchiEnum.GOALS_REQUIREMENT.equalsName(value)) {
            return ArchiEnum.GOALS_REQUIREMENT;

        } else if (ArchiEnum.GOALS_ROLE.equalsName(value)) {
            return ArchiEnum.GOALS_ROLE;

        } else if (ArchiEnum.GOALS_UNAMED.equalsName(value)) {
            return ArchiEnum.GOALS_UNAMED;

        } else if (ArchiEnum.MAPS.equalsName(value)) {
            return ArchiEnum.MAPS;

        } else if (ArchiEnum.MAP_BLUE_STRATAMAP.equalsName(value)) {
            return ArchiEnum.MAP_BLUE_STRATAMAP;

        } else if (ArchiEnum.MAP_GREEN_STRATAMAP.equalsName(value)) {
            return ArchiEnum.MAP_GREEN_STRATAMAP;

        } else if (ArchiEnum.MAP_OUTLINE_STRATAMAP.equalsName(value)) {
            return ArchiEnum.MAP_OUTLINE_STRATAMAP;

        } else if (ArchiEnum.STRATAMAP_BLUE_STRATAMAP.equalsName(value)) {
            return ArchiEnum.STRATAMAP_BLUE_STRATAMAP;

        } else if (ArchiEnum.STRATAMAP_GREEN_STRATAMAP.equalsName(value)) {
            return ArchiEnum.STRATAMAP_GREEN_STRATAMAP;

        } else if (ArchiEnum.STRATAMAP_OUTLINE_STRATAMAP.equalsName(value)) {
            return ArchiEnum.STRATAMAP_OUTLINE_STRATAMAP;

        } else if (ArchiEnum.TECHNOLOGY_ARTIFACT.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_ARTIFACT;

        } else if (ArchiEnum.TECHNOLOGY_COMMUNICATION_PATH.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_COMMUNICATION_PATH;

        } else if (ArchiEnum.TECHNOLOGY_DATABASE.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_DATABASE;

        } else if (ArchiEnum.TECHNOLOGY_DEVICE.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_DEVICE;

        } else if (ArchiEnum.TECHNOLOGY_FUNCTION.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_FUNCTION;

        } else if (ArchiEnum.TECHNOLOGY_INTERFACE.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_INTERFACE;

        } else if (ArchiEnum.TECHNOLOGY_NETWORK.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_NETWORK;

        } else if (ArchiEnum.TECHNOLOGY_NODE.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_NODE;

        } else if (ArchiEnum.TECHNOLOGY_SERVICE.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_SERVICE;

        } else if (ArchiEnum.TECHNOLOGY_SYSTEM_SOFTWARE.equalsName(value)) {
            return ArchiEnum.TECHNOLOGY_SYSTEM_SOFTWARE;

        } else if (ArchiEnum.CONTRACT.equalsName(value)) {
            return ArchiEnum.CONTRACT;

        } else if (ArchiEnum.LOCATION.equalsName(value)) {
            return ArchiEnum.LOCATION;

        } else if (ArchiEnum.DATA_OBJECT.equalsName(value)) {
            return ArchiEnum.DATA_OBJECT;

        } else if (ArchiEnum.ARTIFACT.equalsName(value)) {
            return ArchiEnum.ARTIFACT;

        } else if (ArchiEnum.NETWORK.equalsName(value)) {
            return ArchiEnum.NETWORK;

        } else if (ArchiEnum.DEVICE.equalsName(value)) {
            return ArchiEnum.DEVICE;

        } else if (ArchiEnum.INFRASTRUCTURE_INTERFACE.equalsName(value)) {
            return ArchiEnum.INFRASTRUCTURE_INTERFACE;

        } else if (ArchiEnum.INFRASTRUCTURE_SERVICE.equalsName(value)) {
            return ArchiEnum.INFRASTRUCTURE_SERVICE;

        } else if (ArchiEnum.NODE.equalsName(value)) {
            return ArchiEnum.NODE;

        } else if (ArchiEnum.SYSTEM_SOFTWARE.equalsName(value)) {
            return ArchiEnum.SYSTEM_SOFTWARE;

        } else if (ArchiEnum.GROUP.equalsName(value)) {
            return ArchiEnum.GROUP;

        } else if (ArchiEnum.MEANING.equalsName(value)) {
            return ArchiEnum.MEANING;

        } else if (ArchiEnum.COMMUNICATION_PATH.equalsName(value)) {
            return ArchiEnum.COMMUNICATION_PATH;

        }else if (ArchiEnum.DATABASE.equalsName(value)) {
            return ArchiEnum.DATABASE;

        } else if (ArchiEnum.NOTE.equalsName(value)) {
            return ArchiEnum.NOTE;

        } else {
            return ArchiEnum.DEFAULT;

        }
    }
}
