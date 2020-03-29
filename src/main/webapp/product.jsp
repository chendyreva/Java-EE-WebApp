<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <%@include file="menu.jsp"%>
        <h2>You are in product page!</h2>
</head>
<body>

<%@page import="java.util.ArrayList"%>
<%@page import="com.shop.persist.Product"%>
<%@page import="java.util.Iterator"%>

<% ArrayList<Product> prodList = (ArrayList) request.getAttribute("ProdList"); %>
<strong><a href="<%=request.getContextPath()%>/product?type=getDetails">Show Products</a></strong>
<br></br>

<table cellspacing="2" cellpadding="2">

    <tr><th>Product_ID</th><th>Name</th><th>Description</th><th>Price</th></tr>
    <%


        if(request.getAttribute("ProdList") != null)
        {
            Iterator<Product> iterator = prodList.iterator();

            while(iterator.hasNext())
            {
                Product product = iterator.next();
    %>
    <tr><td><%=product.getProductId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getPrice()%></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>