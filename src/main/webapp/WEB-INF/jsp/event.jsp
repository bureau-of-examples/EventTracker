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
        <div class="col-md-8 col-md-offset-2 event-form">
            <form:form commandName="event">
                <div class="row">
                    <div class="col-md-12">
                        <form:errors path="*" cssClass="errorblock" element="div"/>
                    </div>
                </div>

                <form:input path="id" type="hidden" />
                <div class="row">
                    <div class="col-md-3"><label for="txtName">Name:</label></div>
                    <div class="col-md-9">
                        <form:input id="txtName" path="name" cssClass="form-control"/>
                        <div class="row">
                            <div class="col-md-12">
                                <form:errors path="name" cssClass="error" element="div"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3"><label for="txtDate">Date:</label></div>
                    <div class="col-md-9">
                        <form:input id="txtDate" path="date" cssClass="form-control" placeholder="${dateInputFormat}"/>
                        <div class="row">
                            <div class="col-md-12">
                                <form:errors path="date" cssClass="error" element="div"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3"><label for="txtLocation">Location:</label></div>
                    <div class="col-md-9">
                        <form:input id="txtLocation" path="location" cssClass="form-control"/>
                        <div class="row">
                            <div class="col-md-12">
                                <form:errors path="location" cssClass="error" element="div"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3"><label for="txtDuration">Duration:</label></div>
                    <div class="col-md-9">
                        <form:input id="txtDuration" path="duration" cssClass="form-control"/>
                        <div class="row">
                            <div class="col-md-12">
                                <form:errors path="duration" cssClass="error" element="div"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3"><label for="txtDuration">Website:</label></div>
                    <div class="col-md-9">
                        <form:input id="txtUrl" path="url" cssClass="form-control"/>
                        <div class="row">
                            <div class="col-md-12">
                                <form:errors path="url" cssClass="error" element="div"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-2">
                        <input type="submit" class="btn btn-default" value="Save">
                    </div>
                    <div class="col-md-2">
                        <form action="${pageContext.request.contextPath}/deleteEvent" method="post">
                            <input name="eventId" type="hidden" value="${event.id}">
                            <input type="submit" class="btn btn-default" value="Delete">
                        </form>
                    </div>
                    <div class="col-md-5">
                        <a href="${pageContext.request.contextPath}/" class="btn btn-default">Cancel</a>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</t:page>

