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
<button style="vertical-align: middle; font-weight: bold;  size: 9px; background-color: lightcyan"><a href="addingNewReviewsButton"> Добавить отзыв </a></button>



<h1>Список отзывов:</h1>

<c:if test="${not empty listReviews}">
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
        <c:forEach items="${listReviews}" var="reviews">
            <tr>
                <td>${reviews.idReview}</td>
                <td>${reviews.titleReview}</td>
                <td>${reviews.contentReview}</td>
                <td>${reviews.country}</td>
                <td>${reviews.genreOne}</td>
                <td>${reviews.genreTwo}</td>
                <td>${reviews.year}</td>
                <td>${reviews.seasons}</td>
                <td>${reviews.likesQuantityReview}</td>
                <td>${reviews.commentQuantityReview}</td>
                <td><a href="<c:url value='/editSeries/${reviews.idReviews}'/>">Редактировать</a></td>
                <td style="background-color: red"><a href="<c:url value="/removeSeries/${reviews.idReviews}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>

</html>