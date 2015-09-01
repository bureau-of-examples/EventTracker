<%--
  Created by IntelliJ IDEA.
  User: ZHY
  Date: 21/06/2015
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Update Event">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table">
                <caption>Event Details</caption>
                <thead>
                <tr>
                    <th>Id</th>
                    <td>${event.id}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${event.name}</td>
                </tr>
                <tr>
                    <th>Date</th>
                    <td>${event.date}</td>
                </tr>
                <tr>
                    <th>Location</th>
                    <td>${event.location}</td>
                </tr>
                <tr>
                    <th>Duration</th>
                    <td>${event.duration}</td>
                </tr>
                <tr>
                    <th>Link</th>
                    <td>${event.url}</td>
                </tr>
                </thead>
            </table>

            <table class="table table-striped">
                <caption>Attendees</caption>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${event.attendees}" var="attendee">
                    <tr>
                        <td>${attendee.name}</td>
                        <td>${attendee.email}</td>
                        <td>${attendee.phone}</td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a href="${pageContext.request.contextPath}/" class="btn btn-default">Go back</a>
        </div>
    </div>
</t:page>

