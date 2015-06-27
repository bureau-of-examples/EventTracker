
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Event Tracker">

    <%--we need to put bootstrap.min.css into the css folder to get intellisense for css class in IntelliJ.--%>
    <div class="row">
        <div class="col-md-12">
            <ul>
                <li><a href="event.html">Event</a></li>
                <li><a href="attendee.html">Attendee</a></li>
                <li><a href="greeting.html">Greeting</a></li>
                <li><a href="showEvents.jsp">Report</a></li>
            </ul>
        </div>

    </div>


    <div class="row">
        <div class="col-md-12">
            <c:if test="${empty(event)}">
                <div>Please create event first.</div>
            </c:if>
        </div>
    </div>


    <div class="row">

        <div class="col-md-12">
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


    </div>
</t:page>

