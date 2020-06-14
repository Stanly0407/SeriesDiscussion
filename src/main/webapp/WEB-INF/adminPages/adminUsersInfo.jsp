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
<h1>Список пользователей:</h1>

<c:if test="${not empty listUsers}">
<table>
    <tr>
        <th width="120">Email</th>
        <th width="120">Имя</th>
        <th width="120">Фамилия</th>
        <th width="80">Пароль</th>
        <th width="80">Рейтинг</th>
        <th width="80">Дата рождения</th>
        <th width="80">isEnabled</th>
        <th width="80">Роль</th>
        <th width="80"></th>
        <th width="80"></th>
        <th width="80"></th>
        </tr>
    <c:forEach items="${listUsers}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.forename}</td>
            <td>${user.surname}</td>
             <td>${user.password}</td>
            <td>${user.rateUser}</td>
            <td>${user.birthdate}</td>
            <td>${user.enabled}</td>
            <td>${user.authorities}</td>
            <form action="admin/UsersInfoList" method="get">
            <td><a href="<c:url value='/blockingUser/${user.username}'/>">Заблокировать</a></td>
            <td><a href="<c:url value='/unBlockingUser/${user.username}'/>">Разблокировать</a></td>
            <td ><a href="<c:url value='/editUser/${user.username}'/>">Редактировать</a></td>
<%--            <td style="color: red"><a href="<c:url value="/remove/${user.idUser}"/>">Удалить</a></td>--%>
            </form>
        </tr>
    </c:forEach>
</table>
</c:if>


</body>

</html>