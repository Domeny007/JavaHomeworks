<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<c:url value="/registration" var="regUrl" />
<sf:form action="${regUrl}" modelAttribute="userform" method="post">
    <sf:errors/>

    <spring:bind path="email">
        <div class="form-group">
            <label for="regEmail">Email:</label>
            <sf:input id="regEmail" type="text" path="email" cssClass="form-control" />
            <sf:errors path="email"/>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="form-group">
            <label for="regPassword">Пароль:</label>
            <sf:input id="regPassword" type="password" path="password" cssClass="form-control password-field" />
            <sf:errors path="password"/>
        </div>
    </spring:bind>

    <spring:bind path="repassword">
        <div class="form-group">
            <label for="rePass">Повтор пароля:</label>
            <sf:input id="rePass" type="password" path="repassword" cssClass="form-control password-field" />
            <sf:errors path="repassword" />
        </div>
    </spring:bind>

    <button type="submit" class="btn btn-lg btn-primary btn-block">Зарегистрироваться</button>

</sf:form>