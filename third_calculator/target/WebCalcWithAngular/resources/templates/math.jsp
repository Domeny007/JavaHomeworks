<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript">
    var csrfToken = '${_csrf.token}';
    var csrfHeader = '${_csrf.headerName}';
</script>
<c:url var="mathModuleJSUrl" value="/resources/mathAngular/angular_math.js"/>
<script src="${ mathModuleJSUrl }"></script>
<div ng-controller="calculatorController">
    <h1>Калькулятор 3</h1>
    <div class="alert alert-danger" ng-show="error">
        Ошибка на сервере
    </div>
    <form role="form" name="mathOperForm" ng-submit="sendCalc()">
        <label for="number">Значение:</label>
        <input type="text" id="number" name="number" ng-model="mathOperForm.number"/>
        <label for="function1">Операции: </label>
        <label for="function1">+</label>
        <input type="radio" id="function1" name="function" value="+" ng-model="mathOperForm.function"/>
        <label for="function2">-</label>
        <input type="radio" id="function2" name="function" value="-" ng-model="mathOperForm.function"/>
        <label for="function3">*</label>
        <input type="radio" id="function3" name="function" value="*" ng-model="mathOperForm.function"/>
        <label for="function4">/</label>
        <input type="radio" id="function4" name="function" value="/" ng-model="mathOperForm.function"/>
        <label for="function5">=</label>
        <input type="radio" id="function5" name="function" value="=" ng-model="mathOperForm.function"/>
        <br>
        <button type="submit" class="btn btn-sm">Вычислить</button>
    </form>
    <div ng-switch="isAnyCalculation">
        <div ng-switch-when="true">
            <ol>
                <li ng-repeat="calculation in sessionCalcHistory track by $index">
                    <h6> "Ваш ответ: {{sessionCalcHistory[$index]}}"</h6>
                </li>
            </ol>
        </div>
    </div>
    <c:url var="logoutUrl" value="/logout" />
    <form action="${logoutUrl}" method="post">
        <input type="submit" value="Выйти" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>