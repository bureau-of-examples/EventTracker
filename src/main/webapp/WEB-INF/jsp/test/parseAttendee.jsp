<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page pageTitle="Parse an attendee from string">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <div class="row">
                <div class="col-md-12">
                    <form method="POST">

                        <input name="attendeeString">
                        <button type="submit">Do it</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</t:page>

