<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Currency Converter</title>
    <link rel="stylesheet" type="text/css">
</head>
<body>
<h2>Currency Converter</h2>
<form method="post">
    <label>Rate: </label><br/>
    <input type="number" name="rate" placeholder="RATE" readonly value="23000"/><br/>
    <label>USD: </label><br/>
    <input type="number" name="usd" placeholder="USD" value="${rUSD}"/><br/>
    <label>VND: </label><br/>
    <input type="number" name="vnd" placeholder="VND" value="${rVND}"/><br/>
    <input type="submit" id="submit" value="Converter"/>
</form>
</body>
</html>