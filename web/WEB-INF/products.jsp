<%-- 
    Document   : products
    Created on : Feb 24, 2020, 8:07:56 PM
    Author     : Christos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Product> products = (List<Product>)request.getAttribute("products"); %>
        <c:out value = "${products}"/>
        
        <c:forEach items="${products}" var="p">
            ${p.price}
        </c:forEach>
        <% for(Product pr: products){
            out.print(pr.getTitle());
        } %>
        
    </body>
</html>
