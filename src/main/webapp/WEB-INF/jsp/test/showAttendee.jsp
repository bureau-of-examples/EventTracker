<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page pageTitle="Parse Result">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <div class="row">
                <div class="col-md-12">

                    <table class="table">

                        <tr><th>Name</th><td>${attendee.name}</td></tr>
                        <tr><th>Gender</th><td>${attendee.gender}</td></tr>
                        <tr><th>Email</th><td>${attendee.email}</td></tr>
                        <tr><th>Phone</th><td>${attendee.phone}</td></tr>

                    </table>

                    <p><a href=" ">Go back</a></p>
                </div>

            </div>
        </div>
    </div>
</t:page>

