<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page pageTitle="All events" useAngular="true">
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
                <tr data-ng-repeat="event in events">
                    <td>{{event.name}}</td>
                    <td>{{event.date | date : 'dd/MM/yyyy hh:mm'}}</td>
                    <td>{{event.location}}</td>
                    <td>{{event.attendees.length}}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/setCurrent" >
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
                    });
        </script>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="${pageContext.request.contextPath}/" class="btn btn-default">Go back</a>
        </div>
    </div>
</t:page>

