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
<body style="background-color: cadetblue; ">

<p style="horiz-align: center">
    <img src="<spring:url value="../images/lion.png"/>">
<hr style="border-width: 3px;">

<p style="text-align: center; color: red; background-color: lightgoldenrodyellow">
   Ваш аккаунт заблокирован! <br>
   Скорее всего вы нарушили правила пользования сайтом! <br>
   <b>Для уточнения причины Вы можете обратиться в службу поддержки!</b>
  </p>
<br>
<br>
<br>
<br>
<br>
<%--<form action="adminUsersInfoList" method="get">--%>
    <p style="text-align: center;">
        <button style="vertical-align: middle; font-weight: bold;  size: 9px; background-color: lightcyan"> Обратиться в службу поддержки </button>
    </p>
<%--</form>--%>

</body>

</html>