package com.Farzad.Enums;

import POJOs.SVGSingleShape;

/**
 * Created by VOLCANO on 5/2/2017.
 */
public enum ShapeEnum {
    APPLICATION_COLLABORATION(Category.APPLICATION),
    APPLICATION_COMPONENT(Category.APPLICATION),
    APPLICATION_FUNCTION(Category.APPLICATION),
    APPLICATION_INTERACTION(Category.APPLICATION),
    APPLICATION_INTERFACE(Category.APPLICATION),
    APPLICATION_OBJECT(Category.APPLICATION),
    APLLICATION_DATA_OBJECT(Category.APPLICATION),
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
    DEFAULT(Category.TECHNOLOGY);
    //    private final String name;
    private Category category;

    ShapeEnum(Category category) {
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

    public String getStringValue() {
        switch (this) {
            case APPLICATION_COLLABORATION:
                return "ApplicationCollaboration";
            case APPLICATION_COMPONENT:
                return "ApplicationComponant";
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
            default:
                return null;
        }
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        System.out.println("%%%%%%%%%%%%  Other name : " + otherName + " getStringValue() : " + (getStringValue() != null ? getStringValue().toLowerCase() : "")
                + " -- " + (otherName != null && getStringValue() != null && getStringValue().toLowerCase().equals(otherName.toLowerCase())));
        return otherName != null && getStringValue() != null && getStringValue().toLowerCase().equals(otherName.toLowerCase());
    }
//    public boolean nameStartWith(String otherName) {
//        return otherName != null && getStringValue()!=null && getStringValue().toLowerCase().startsWith(otherName.substring(0, otherName.length() - 2).toLowerCase());
//    }

    //    public String toString() {
//        return this.name;
//    }
//
//    private IconsEnum(String s) {
//        name = s;
//    }
    public static String getSVGIcons(SVGSingleShape svgShape) {
        if (IconsEnum.APPLICATION_COLLABORATION.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_COLLABORATION.iconSVGCode(svgShape);
        } else if (IconsEnum.APPLICATION_COMPONENT.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_COMPONENT.iconSVGCode(svgShape);
        } else if (IconsEnum.APPLICATION_FUNCTION.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_FUNCTION.iconSVGCode(svgShape);
        } else if (IconsEnum.APPLICATION_INTERACTION.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_INTERACTION.iconSVGCode(svgShape);
        } else if (IconsEnum.APPLICATION_INTERFACE.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_INTERFACE.iconSVGCode(svgShape);
        } else if (IconsEnum.APPLICATION_OBJECT.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_OBJECT.iconSVGCode(svgShape);
        } else if (IconsEnum.APPLICATION_SERVICE.equalsName(svgShape.getElementType())) {
            return IconsEnum.APPLICATION_SERVICE.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_ACTOR.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_ACTOR.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_COLLABORATION.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_COLLABORATION.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_EVENT.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_EVENT.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_FUNCTION.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_FUNCTION.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_INTERACTION.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_INTERACTION.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_INTERFACE.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_INTERFACE.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_LOCATION.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_LOCATION.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_MEANING.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_MEANING.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_OBJECT.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_OBJECT.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_PROCESS.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_PROCESS.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_PRODUCT.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_PRODUCT.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_REPRESENTATION.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_SERVICE.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_SERVICE.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_STAKEHOLDER.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_STAKEHOLDER.iconSVGCode(svgShape);
        } else if (IconsEnum.BUSINESS_VALUE.equalsName(svgShape.getElementType())) {
            return IconsEnum.BUSINESS_VALUE.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_ASSESSMENT.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_ASSESSMENT.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_CONSTRAINT.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_CONSTRAINT.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_DRIVER.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_DRIVER.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_GAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_GAP.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_GOAL.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_GOAL.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_PLATEAU.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_PLATEAU.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_PRINCIPAL.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_PRINCIPAL.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_REPRESENTATION.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_REQUIREMENT.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_REQUIREMENT.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_ROLE.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_ROLE.iconSVGCode(svgShape);
        } else if (IconsEnum.GOALS_UNAMED.equalsName(svgShape.getElementType())) {
            return IconsEnum.GOALS_UNAMED.iconSVGCode(svgShape);
        } else if (IconsEnum.MAPS.equalsName(svgShape.getElementType())) {
            return IconsEnum.MAPS.iconSVGCode(svgShape);
        } else if (IconsEnum.MAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.MAP_BLUE_STRATAMAP.iconSVGCode(svgShape);
        } else if (IconsEnum.MAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.MAP_GREEN_STRATAMAP.iconSVGCode(svgShape);
        } else if (IconsEnum.MAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.MAP_OUTLINE_STRATAMAP.iconSVGCode(svgShape);
        } else if (IconsEnum.STRATAMAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.STRATAMAP_BLUE_STRATAMAP.iconSVGCode(svgShape);
        } else if (IconsEnum.STRATAMAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.STRATAMAP_GREEN_STRATAMAP.iconSVGCode(svgShape);
        } else if (IconsEnum.STRATAMAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return IconsEnum.STRATAMAP_OUTLINE_STRATAMAP.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_ARTIFACT.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_ARTIFACT.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_COMMUNICATION_PATH.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_COMMUNICATION_PATH.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_DATABASE.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_DATABASE.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_DEVICE.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_DEVICE.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_FUNCTION.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_FUNCTION.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_INTERFACE.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_INTERFACE.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_NETWORK.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_NETWORK.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_NODE.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_NODE.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_SERVICE.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_SERVICE.iconSVGCode(svgShape);
        } else if (IconsEnum.TECHNOLOGY_SYSTEM_SOFTWARE.equalsName(svgShape.getElementType())) {
            return IconsEnum.TECHNOLOGY_SYSTEM_SOFTWARE.iconSVGCode(svgShape);
        } else
            return " ";

    }

    public String SVGShapeCode(SVGSingleShape svgShape) {

        String singleRect = "<svg>" +
                " <g>" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <text x=\"" + (svgShape.getX() + 10) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 35) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n" +
                "    </a>\n" + getSVGIcons(svgShape) +
                "</g>" +
                "</svg>";
        switch (this) {
            case APPLICATION_COLLABORATION:
                return singleRect;
            case APPLICATION_COMPONENT:
                return singleRect;
            case APPLICATION_FUNCTION:
                return singleRect;
            case APPLICATION_INTERACTION:
                return singleRect;
            case APPLICATION_INTERFACE:
                return singleRect;
            case APPLICATION_OBJECT:
                return singleRect;
            case APPLICATION_SERVICE:
                return singleRect;
            case BUSINESS_ACTOR:
                return singleRect;
            case BUSINESS_COLLABORATION:
                return singleRect;
            case BUSINESS_EVENT:
                return singleRect;
            case BUSINESS_FUNCTION:
                return singleRect;
            case BUSINESS_INTERACTION:
                return singleRect;
            case BUSINESS_INTERFACE:
                return singleRect;
            case BUSINESS_LOCATION:
                return singleRect;
            case BUSINESS_MEANING:
                return singleRect;
            case BUSINESS_OBJECT:
                return singleRect;
            case BUSINESS_PROCESS:
                return singleRect;
            case BUSINESS_PRODUCT:
                return singleRect;
            case BUSINESS_REPRESENTATION:
                return singleRect;
            case BUSINESS_SERVICE:
                return singleRect;
            case BUSINESS_STAKEHOLDER:
                return singleRect;
            case BUSINESS_VALUE:
                return singleRect;
            case GOALS_ASSESSMENT:
                return singleRect;
            case GOALS_CONSTRAINT:
                return singleRect;
            case GOALS_DRIVER:
                return singleRect;
            case GOALS_GAP:
                return singleRect;
            case GOALS_GOAL:
                return singleRect;
            case GOALS_PLATEAU:
                return singleRect;
            case GOALS_PRINCIPAL:
                return singleRect;
            case GOALS_REPRESENTATION:
                return singleRect;
            case GOALS_REQUIREMENT:
                return singleRect;
            case GOALS_ROLE:
                return singleRect;
            case GOALS_UNAMED:
                return singleRect;
            case MAPS:
                return singleRect;
            case MAP_BLUE_STRATAMAP:
                return singleRect;
            case MAP_GREEN_STRATAMAP:
                return singleRect;
            case MAP_OUTLINE_STRATAMAP:
                return singleRect;
            case STRATAMAP_BLUE_STRATAMAP:
                return singleRect;
            case STRATAMAP_GREEN_STRATAMAP:
                return singleRect;
            case STRATAMAP_OUTLINE_STRATAMAP:
                return singleRect;
            case TECHNOLOGY_ARTIFACT:
                return singleRect;
            case TECHNOLOGY_COMMUNICATION_PATH:
                return singleRect;
            case TECHNOLOGY_DATABASE:
                return singleRect;
            case TECHNOLOGY_DEVICE:
                return singleRect;
            case TECHNOLOGY_FUNCTION:
                return singleRect;
            case TECHNOLOGY_INTERFACE:
                return singleRect;
            case TECHNOLOGY_NETWORK:
                return singleRect;
            case TECHNOLOGY_NODE:
                return singleRect;
            case TECHNOLOGY_SERVICE:
                return singleRect;
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return singleRect;
            default:
                return singleRect;
        }
    }

}
