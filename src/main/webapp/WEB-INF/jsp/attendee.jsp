<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Add Attendee">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="clearfix">
                <div class="pull-right">
                    <a class="btn btn-default" href="?language=en">English</a> <a class="btn btn-default"
                                                                                  href="?language=es">Spanish</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <form:form commandName="attendee">
                        <form:errors path="*" cssClass="errorblock" element="div"/>

                        <div class="form-group">
                            <label> <spring:message code="attendee.name"/> </label>
                            <form:input id="txtName" path="name" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label> <spring:message code="attendee.email"/></label>
                            <form:input id="txtEmail" path="email" cssClass="form-control"/></div>
                        <div class="form-group">
                            <label> <spring:message code="attendee.phone"/></label>
                            <form:input id="txtPhone" path="phone" cssClass="form-control"/>
                        </div>
                        <input type="submit" class="btn btn-default" value="<spring:message code="attendee.add" />">

                    </form:form>
                </div>

            </div>
        </div>
    </div>
</t:page>

