<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="nc.model.Dipendente" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <c:forEach var="dipendente" items="${Dipendenti}">
        ${dipendente.nome}
    </c:forEach>
</body>
</html>