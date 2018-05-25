<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:url value="/login/process" var="logIn" />
<form action="${logIn}" method="post">
    <h1>Калькулятор 3</h1>
    <c:if test="${param.error}" >
        <h2>Неправильный логин или пароль</h2>
    </c:if>
    <label for="loginEmail">Email: </label>
        <input id="loginEmail" type="text" placeholder="введите e-mail" name="email">
    <label for="loginPassword">Пароль: </label>
        <input id="loginPassword" type="password" placeholder="введите пароль" name="password">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button type="submit">Войти</button>
</form>

<c:url value="/registration" var="register" />
<form action="${register}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Зарегистрироваться</button>
</form>