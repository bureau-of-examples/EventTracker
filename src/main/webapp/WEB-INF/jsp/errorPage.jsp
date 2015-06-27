
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="Oops...">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p class="errorblock">
               ${errorMessage}
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a href="${pageContext.request.contextPath}/" class="btn btn-default">Go back</a>
        </div>
    </div>
</t:page>
