<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Simple Dictionary</title>

</head>
<body>
<h2> Vietnamese Dictionary</h2>
<form method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word : " value="${Word}"/>
    <input type="text" name="search" placeholder="translate here" value="${Result}${Notfound}"/>
    <input type="submit" id="submit" value="Search"/>
</form>
</body>

</html>