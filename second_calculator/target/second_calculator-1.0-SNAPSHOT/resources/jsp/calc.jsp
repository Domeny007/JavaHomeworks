<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<html>
<head>
    <title>Калькулятор 2</title>
</head>
<body>
<sf:form method="post" action="calc" modelAttribute="calc" style="border:1px solid #ccc">
    <div id="digitInput">
        <h1> Калькулятор 2</h1>
        <sf:label path="digit"><h4>Введите число</h4></sf:label>
        <sf:input path="digit"/>
        <sf:errors path="digit"/>
    </div>

    <div id="last_result">
        <div class="panel panel-default">
            <div class="panel-body lastDigit">${calc.digit}</div>
        </div>

        <div class="panel panel-default">
            <div class="panel-body lastOper">${calc.operation}</div>
        </div>
    </div>

    <div>
        <button type="submit" name="operation" value="/">/</button>
        <button type="submit" name="operation" value="*">*</button>
        <button type="submit" name="operation" value="-">-</button>
        <button type="submit" name="operation" value="+">+</button>
        <button type="submit" name="operation" value="=">=</button>
    </div>
</sf:form>

    <form action="logout">
        <button type="submit" class="btn btn-default">Выйти</button>
    </form>

</body>
</html>

