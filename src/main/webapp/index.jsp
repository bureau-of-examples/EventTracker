<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="event" value="${sessionScope.event}" />

<t:page pageTitle="Event Tracker">

    <div class="clearfix">
        <div class="pull-right">
            <a class="btn btn-default" href="?language=en">English</a> <a class="btn btn-default"
                                                                          href="?language=es">Spanish</a>
        </div>
    </div>
    <br>

    <%--we need to put bootstrap.min.css into the css folder to get intellisense for css class in IntelliJ.--%>
    <div class="row">
        <div class="col-md-12">
            <ul class="list-group">
                <li class="list-group-item"><a href="event.html?add=true">Add event</a></li>
                <c:if test="${not empty(sessionScope.event)}">
                    <li class="list-group-item"><a href="event.html">Update current event</a></li>
                </c:if>
                <li class="list-group-item"><a href="attendee.html">Add attendee</a></li>
                <li class="list-group-item"><a href="showEvents.jsp">View all events</a></li>
                    <%--<li class="list-group-item"><a href="greeting.html">Greeting</a></li>--%>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <c:if test="${empty(event)}">
                <div class="alert alert-info" role="alert">
                    <span class="badge">!</span> Please create an event.
                </div>
            </c:if>
        </div>
    </div>


    <div class="row">

        <div class="col-md-12">
            <c:if test="${not empty(event)}">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Current event details</h3>
                    </div>
                    <div class="panel-body">

                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Id:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${event.id}</p>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Name:</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${event.name}</p>
                                </div>
                            </div>

                            <c:if test="${not empty(event.date)}">

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Date</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${event.date}</p>
                                </div>
                            </div>
                            </c:if>

                            <c:if test="${not empty(event.location)}">

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Location</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${event.location}</p>
                                </div>
                            </div>
                            </c:if>

                            <c:if test="${not empty(event.duration)}">

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Duration</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">${event.duration}</p>
                                </div>
                            </div>
                            </c:if>

                            <c:if test="${not empty(event.url)}">

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Website</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static"><a href="${event.url}">${event.url}</a></p>
                                </div>
                            </div>
                            </c:if>
                        </div>

                        <c:if test="${event.attendees.size() == 0}">

                            <div class="alert alert-info" role="alert">
                                <span class="badge">!</span> Please add attendees.
                            </div>
                        </c:if>

                        <c:if test="${event.attendees.size() > 0}">
                            <table class="table">
                                <tr>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                </tr>
                                <c:forEach items="${event.attendees}" var="attendee">
                                    <tr>
                                        <td>${attendee.name}</td>
                                        <td>${attendee.email}</td>
                                        <td>${attendee.phone}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                    </div>
                </div>

            </c:if>

        </div>
    </div>
</t:page>

