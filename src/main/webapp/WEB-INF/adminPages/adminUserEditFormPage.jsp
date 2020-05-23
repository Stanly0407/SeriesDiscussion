<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Сериалы тут!</title>
    <link rel="shortcut icon"  type="ico/png" href="../images/favicon.ico">
</head>

<p style="horiz-align: center">
    <img src="<spring:url value="../images/lion.png"/>">

<body>


<h1>Редактирование пользователя.</h1>
<c:url var="editSave" value="/editSave"/>


<form:form  action="${editSave}" modelAttribute="command" >
<table >
    <tr>
        <td>ID: </td>
        <td>${idUser}
            <form:hidden path="idUser"/>
        </td>
    </tr>
    <tr>
        <td>Имя: </td>
        <td><form:input path="forename"  /></td>
    </tr>
    <tr>
        <td>Фамилия: </td>
        <td><form:input path="surname" /></td>
    </tr>
    <tr>
        <td>Email: </td>
        <td><form:input path="email"  /></td>
    </tr>
    <tr>
        <td>Пароль: </td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td>Рейтинг: </td>
        <td><form:input path="rateUser" /></td>
    </tr>
    <tr>
        <td>День рождения: </td>
        <td><form:input path="birthdate" /></td>
    </tr>
    <tr>
        <td> </td>
        <td><input type="submit" value="Сохранить изменения" /></td>
    </tr>
</table>
</form:form>

</body>

</html>