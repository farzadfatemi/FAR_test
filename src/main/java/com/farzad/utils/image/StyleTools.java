package com.farzad.utils.image;

import com.farzad.enums.ArchiEnum;

/**
 * Created by VOLCANO on 5/2/2017.
 */
public class StyleTools {
    public static String getIconStyles(ArchiEnum.Category type){
        switch (type){
            case APPLICATION:
                return "fill=\"#3b6cb3\"";
            case BUSINESS:
                return "fill=\"#faab19\"";
            case GOALS:
                return "fill=\"#5e4a9d\"";
            case MAPS:
                return "fill=\"#00d849\"";
            case STRATAMAP_MAPS:
                return "fill=\"#23254e\"";
            case TECHNOLOGY:
                return "fill=\"#19b47b\"";
            case INFRASTRUCTURE:
                return "fill=\"#19b47b\"";
            default:
                return "fill=\"#000000\"";
        }
    }
}
