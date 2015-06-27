<%@tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="false" %>
<%@ attribute name="useJQuery" required="false" type="java.lang.Boolean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href='${pageContext.request.contextPath}/css/site.css'>

    <%if(Boolean.TRUE.equals(useJQuery)){%>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <%}%>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${pageTitle}</title>
</head>
<body>
<div class="container">

    <div class="page-header bg-success">
        <h2>Event Tracker <small>Spring MVC4 + Bean Validation demo webapp</small></h2>
    </div>

    <jsp:doBody/>


    <footer>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <small>Demo source code: <a href="https://github.com/zhy2002/EventTracker">https://github.com/zhy2002/EventTracker</a></small>
            </div>
        </div>

    </footer>

</div>
</body>
</html>
