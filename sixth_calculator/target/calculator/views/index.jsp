<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Калькулятор</title>
</head>
<body>
<h1>Web-socket калькулятор</h1>

<div>
    <button id="connect">Подключение</button>
    <button id="disconnect" disabled="disabled">Отключение</button>
</div>

<div id="calculator" style="transition: all .3s; display: none;">
    <input id="input" type="text">
    <p><span id="response"></span></p>
    <button id="plus">+</button>
    <button id="sub">-</button>
    <button id="mult">*</button>
    <button id="divide">/</button>
</div>
<script src="<c:url value="/views/js/sockjs-0.3.min.js"/>"></script>
<script src="<c:url value="/views/js/stomp.min.js"/>"></script>
<script src="<c:url value="/views/js/stompwebsocket.js"/>"></script>
</body>
</html>
