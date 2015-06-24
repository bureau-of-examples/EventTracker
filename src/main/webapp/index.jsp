<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 20/06/2015
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Event Tracker</h2>


<ul>
    <li><a href="event.html">Event</a></li>
    <li><a href="attendee.html">Attendee</a></li>
    <li><a href="greeting.html">Greeting</a></li>
    <li><a href="showEvents.jsp">Report</a></li>
</ul>

<c:if test="${empty(event)}">
    <div>Please create event first.</div>
</c:if>

<div>
    <h3>${event.name}</h3>
    <c:if test="${event.attendees.size() == 0}">

        <div>Please add attendee.</div>
    </c:if>

    <c:if test="${event.attendees.size() > 0}">
        <table>
            <tr>
                <td>Name</td>
                <td>Email</td>
            </tr>
            <c:forEach items="${event.attendees}" var="attendee">
                <tr>
                    <td>${attendee.name}</td>
                    <td>${attendee.email}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>
</html>
