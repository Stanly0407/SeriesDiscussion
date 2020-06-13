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
<button style="vertical-align: middle; font-weight: bold;  size: 9px; background-color: lightcyan"><a href="addingNewSeriesButton"> Добавить сериал </a></button>



<h1>Список сериалов:</h1>

<c:if test="${not empty listSeries}">
    <table>
        <tr>
            <th width="20">ID</th>
            <th width="200">Наименование</th>
            <th width="2000">Описание</th>
            <th width="80">Страна</th>
            <th width="80">Жанр (1)</th>
            <th width="80">Жанр (2)</th>
            <th width="30">Вышел</th>
            <th width="20">Сезоны</th>
            <th width="80">Отметок "Нравится":</th>
            <th width="80">Коментарии <br>
                (без подкомментариев)
            </th>
            <th width="80"></th>
            <th width="80" style="text-blink: red">В крайнем случае!</th>
        </tr>
        <c:forEach items="${listSeries}" var="series">
            <tr>
                <td>${series.idSeries}</td>
                <td>${series.titleSeries}</td>
                <td>${series.contentSeries}</td>
                <td>${series.country}</td>
                <td>${series.genreOne}</td>
                <td>${series.genreTwo}</td>
                <td>${series.year}</td>
                <td>${series.seasons}</td>
                <td>${series.likesQuantitySeries}</td>
                <td>${series.commentQuantitySeries}</td>
                <td><a href="<c:url value='/editSeries/${series.idSeries}'/>">Редактировать</a></td>
                <td style="background-color: red"><a href="<c:url value="/removeSeries/${series.idSeries}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>

</html>