<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 22/06/2015
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add attendee</title>
    <link rel="stylesheet" href="/css/site.css">
</head>
<body>
<h1>Add attendee</h1>

<div><a href="?language=en">English</a> | <a href="?language=es">Spanish</a></div>
<div>
    <form:form commandName="attendee">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <div><label> <spring:message code="attendee.name" /> </label><form:input id="txtName" path="name" cssErrorClass="error"/></div>
        <div><label> <spring:message code="attendee.email" /></label><form:input id="txtEmail" path="email" cssErrClass="error"/></div>
        <div><label> <spring:message code="attendee.phone" /></label><form:input id="txtPhone" path="phone" cssErrClass="error"/></div>
        <div><input type="submit" value="<spring:message code="attendee.add" />"></div>

    </form:form>
</div>
</body>
</html>
