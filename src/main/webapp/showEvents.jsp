<!DOCTYPE html>
<html data-ng-app="myApp">
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <script>

        angular.module('myApp', []).controller("events",
                function ($scope, $http) {
                    $http.get("/events.json").success(function (data) {
                        $scope.events = data;
                    });
                });

    </script>
</head>
<body>
<p>Angular says: 1 + 1 = {{1+1}}</p>

<div data-ng-controller="events">
    <ul>
        <li data-ng-repeat="event in events">
            {{event.name}}
        </li>
    </ul>
</div>
</body>
</html>
