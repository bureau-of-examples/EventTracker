<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:page pageTitle="All events" useAngular="true" useJQuery="true">
    <div class="row" data-ng-app="myApp">
        <div class="col-md-12" data-ng-controller="events">

            <p>Angular says: 1 + 1 = {{1+1}}</p>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Event</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Number of attendees</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:url var="details" value="/eventDetails.html?id={{event.id}}" />
                <tr data-ng-repeat="event in events">

                    <td>  <a href="${details}">{{event.name}}</a> <span class="glyphicon glyphicon-arrow-left" data-ng-show="{{event.id == currentEventId}}"></span></td>
                    <td>{{event.date | date : 'dd/MM/yyyy hh:mm'}}</td>
                    <td>{{event.location}}</td>
                    <td>{{event.attendees.length}}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/setCurrent.html" >
                            <input type="hidden" name="eventId" value="{{event.id}}">
                            <button class="btn btn-primary btn-sm">Set as current</button>
                        </form>

                    </td>
                </tr>
                </tbody>
            </table>


        </div>

        <script>
            angular.module('myApp', []).controller("events",
                    function ($scope, $http) {
                        $http.get("/events.json").success(function (data) {
                            $scope.events = data;
                        });

                        $scope.currentEventId = $("#input-current_event_id").val();
                    });
        </script>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="${pageContext.request.contextPath}/" class="btn btn-default">Go back</a>
        </div>
    </div>

    <input id="input-current_event_id" type="hidden" value="${currentEventId}">
</t:page>

