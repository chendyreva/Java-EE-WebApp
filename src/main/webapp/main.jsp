<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%@include file="WEB-INF/menu.jsp"%>
<h2>Welcome to main page of our shop!</h2>
<div><strong>URL of website:</strong> <%=request.getRequestURI()%></div>
<div><strong>ID session:</strong> <%=session.getId()%></div>
<%-- Создание атрибута сессии --%>
<%
    session.setAttribute("hello", "Привет");
%>

</body>
</html>
