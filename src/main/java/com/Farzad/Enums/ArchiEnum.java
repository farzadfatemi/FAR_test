package com.Farzad.Enums;

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
    DATA_OBJECT(Category.APPLICATION),
    ARTIFACT(Category.DEFAULT),
    NETWORK(Category.DEFAULT),
    DEVICE(Category.DEFAULT),
    INFRASTRUCTURE_INTERFACE(Category.DEFAULT),
    SYSTEM_SOFTWARE(Category.DEFAULT),
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
        DEFAULT;
    }
    public String getStringValue(){
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
             case SYSTEM_SOFTWARE:
                return "SystemSoftware";
            default:
                return null;
        }
    }
    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        System.out.println("%%%%%%%%%%%%  Other name : "+otherName +" getStringValue() : " + (getStringValue() !=null?getStringValue().toLowerCase():"")
                + " -- " + (otherName != null && getStringValue()!=null && getStringValue().toLowerCase().equals(otherName.toLowerCase())));
        return otherName != null && getStringValue()!=null && getStringValue().toLowerCase().equals(otherName.toLowerCase());
    }
}
