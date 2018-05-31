;(function () {

    var stompClient = null;

    function setConnected(connected) {
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('calculator').style.display = connected ? 'block' : 'none';
        document.getElementById('response').innerHTML = '0';
    }

    document.getElementById("connect").onclick = function() {
        console.log("sss");
        var socket = new SockJS('/calculate');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            stompClient.subscribe('/calculator', function(greeting){
                showResult(JSON.parse(greeting.body).result);
            });
        });
    };

    document.getElementById("disconnect").onclick = function () {
        stompClient.disconnect();
        setConnected(false);
        console.log("Disconnected");
    };

    function calculate(operation) {
        var newNumber = Number.parseFloat(document.getElementById('input').value);
        var oldNumber = Number.parseFloat(document.getElementById('response').innerText);
        stompClient.send("/act/calculate",
            {},
            JSON.stringify({
                'operation': operation,
                'newNumber': newNumber,
                'oldNumber': oldNumber
            }));
    }

    document.getElementById("plus").onclick = function (e) {
        calculate(1);
    };

    document.getElementById("mult").onclick = function (e) {
        calculate(2);
    };

    document.getElementById("divide").onclick = function (e) {
        calculate(3);
    };

    document.getElementById("sub").onclick = function (e) {
        calculate(4);
    };

    function showResult(result) {
        var response = document.getElementById('response');
        response.innerText = result;
    }

})();