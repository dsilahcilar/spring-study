angular.module('turbine', [])
    .controller('turbineCtrl', function ($http) {

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

        var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        console.log('Init');
        stompClient.connect({}, function (frame) {

            isConnected = true;
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function (greeting) {
                console.log(greeting.body);
                //showGreeting(JSON.parse(greeting.body).content);
            });
        });

        turbineList.showMessage = function (message) {

        }


    });