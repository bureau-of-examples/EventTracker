<%@tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="false" %>
<%@ attribute name="useJQuery" required="false" type="java.lang.Boolean" %>
<%@ attribute name="useAngular" required="false" type="java.lang.Boolean" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/site.css'>

    <%if(Boolean.TRUE.equals(useJQuery)){%>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <%}%>

    <%if(Boolean.TRUE.equals(useAngular)){%>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <%}%>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${pageTitle}</title>
</head>
<body>
<div class="container">

    <div class="page-header bg-success">
        <h2><spring:message code="appname" /> &nbsp; <small><spring:message code="project.name" /></small></h2>
    </div>

    <jsp:doBody/>

    <footer>
        <hr>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
             <p><small>A demo web project based on <a href="http://www.pluralsight.com/courses/spring-mvc4-introduction">Introduction to Spring MVC 4</a></small> course on Pluralsight.</p>
             <p><small>Source code: <a href="https://github.com/zhy2002/EventTracker">https://github.com/zhy2002/EventTracker</a></small></p>
            </div>
        </div>

    </footer>

</div>
</body>
</html>
