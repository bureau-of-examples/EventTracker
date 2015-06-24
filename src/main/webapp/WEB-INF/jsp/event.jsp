<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 21/06/2015
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Event</title>
    <link rel="stylesheet" href="/css/site.css">
</head>
<body>
<div>
    <form:form commandName="event">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <p>
            <label for="txtName">Event:</label><form:input id="txtName" path="name" cssErrorClass="error" /><br>
            <form:errors path="name" cssClass="error" element="div" />
        </p>
        <input type="submit" value="Enter event">
    </form:form>
</div>
</body>
</html>
