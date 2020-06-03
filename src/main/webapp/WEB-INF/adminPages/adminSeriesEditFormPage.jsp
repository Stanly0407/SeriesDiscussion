<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Сериалы тут!</title>
    <link rel="shortcut icon" type="ico/png" href="../images/favicon.ico">
</head>

<p style="horiz-align: center">
    <img src="<spring:url value="../images/lion.png"/>">

<body>

<h1>Редактирование сериала.</h1>
<c:url var="editSaveSeries" value="/editSaveSeries"/>


<form:form action="${editSaveSeries}" modelAttribute="command">
    <table>
        <tr>
            <td>ID:</td>
            <td>${idSeries}
                <form:hidden path="idSeries"/>
            </td>
        </tr>
        <tr>
            <td>Наименование:</td>
            <td><form:input path="titleSeries"/></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><form:input path="contentSeries"/></td>
        </tr>
        <tr>
            <td>Страна:</td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td>Жанр (1):</td>
            <td><form:input path="genreOne"/></td>
        </tr>
        <tr>
            <td>Жанр (2):</td>
            <td><form:input path="genreTwo"/></td>
        </tr>
        <tr>
            <td>Вышел:</td>
            <td><form:input path="year"/></td>
        </tr>
        <tr>
            <td>Сезоны:</td>
            <td><form:input path="seasons"/></td>
        </tr>
        <tr>
            <td>Отметок "Нравится":</td>
            <td><form:input path="likesQuantitySeries"/></td>
        </tr>
        <tr>
            <td>Коментарии:<br>
                (без подкомментариев)
            </td>
            <td><form:input path="commentQuantitySeries"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Сохранить изменения"/></td>
        </tr>
    </table>
</form:form>

</body>

</html>