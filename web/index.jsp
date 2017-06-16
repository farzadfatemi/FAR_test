<%--
  Created by IntelliJ IDEA.
  User: VOLCANO
  Date: 4/7/2017
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.farzad.utils.image.GenerateSVG" %>
<%!
    //  public static String getSVG(){
//    return "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" width=\"300\" height=\"100\">\n" +
//            "  <svg id=\"link\">\n" +
//            "    <a xlink:href=\"https://google.com\">\n" +
//            "      <rect width=\"100\" height=\"100\" />\n" +
//            "    </a>\n" +
//            "  </svg>\n" +
//            "  <use x=\"200\" xlink:href=\"#link\"></use>\n" +
//            "</svg>";
//  }
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<svg width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"
     version="1.1">
    <%=GenerateSVG.getModelSVGs()%>
</svg>
</body>
</html>
