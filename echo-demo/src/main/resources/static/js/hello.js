angular.module('turbine', ['turbine.directive'])
    .controller('turbineCtrl', function ($scope, $http) {

        var turbineList = this;
        turbineList.items = [];
        turbineList.addItemRequest = function (data) {
            $http.post('/turbine/config/', data).then(function (response) {
                turbineList.initlist();
            })
        };

        turbineList.create = function () {
            requestModel = {
                name: this.name,
                pace: {
                    first: this.firstPace,
                    last: this.lastPace
                },
                pressure: {
                    first: this.firstPressure,
                    last: this.lastPressure
                },
                prodFactor: {
                    first: this.firstProdFactor,
                    last: this.lastProdFactor
                }
            };
            strRequest = JSON.stringify(requestModel);
            this.addItemRequest(strRequest);
        }

        turbineList.startItem = function (itemName) {
            $http.post('/turbines/' + itemName).then(function (response) {
                turbineList.initlist();
            })
        }

        turbineList.stopItem = function (itemName) {
            $http.delete('/turbines/' + itemName).then(function (response) {
                turbineList.initlist();
            })
        }

        turbineList.setGraph = function (itemName) {
            turbineList.activeGraph = itemName;
            turbineList.updateGraph();
        }

        turbineList.updatePrice = function (itemName) {
            var unitprice = document.getElementsByName("pr" + itemName)[0].value;
            $http.post('/turbines/' + itemName + '/' + unitprice).then(function (response) {
                turbineList.initlist();
            })
        }


        turbineList.initlist = function () {
            $http.get('/turbines').then(function (response) {
                turbineList.items = response.data;
            })
        }

        turbineList.initlist();

        turbineList.isConnected = false;


        var socket = new SockJS('/websocket');


        stompClient = Stomp.over(socket);
        stompClient.debug = null
        console.log('Init');
        stompClient.connect({}, function (frame) {

            isConnected = true;
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/turbines', function (message) {
                turbineList.showMessage(JSON.parse(message.body));
            });
        });

        var allCharts = {};
        var chartItems = [];

        turbineList.showMessage = function (message) {

            chartItems = allCharts[message.turbineName];

            if (!chartItems) {
                chartItems = [];
            }

            var dataItem = {
                timestamp: message.time,
                value: message.prod
            };

            chartItems.push(dataItem);

            if (chartItems.length > 40) {
                chartItems.shift();
            }

            allCharts[message.turbineName] = chartItems;

        }
        turbineList.updateGraph = function () {
            chartItems = allCharts[turbineList.activeGraph];

            if (chartItems) {
                $scope.chart = {
                    data: chartItems,
                    max: 30
                };

                $scope.$apply();
            }
        }

        myVar = setInterval(function () {
            turbineList.updateGraph();
        }, 1000);


    });