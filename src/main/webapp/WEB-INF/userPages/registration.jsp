<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<param name="FlashVars" value="${fn:escapeXml(flashVars)}" />--%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <link rel="shortcut icon"  type="ico" href="../images/favicon.ico">
</head>

<body style="background-color: cadetblue; ">
<h2 style="color: darkslategray; size: 12px; text-align: center; font-weight: bolder "> Регистрация </h2>

<hr style="border-width: 3px;">

<form action="newRegistration" method="post">
    <p style="text-align: center;"> <b style="font-style: oblique; color: darkblue"> Имя:</b> <br>
        <input type="text" size="40" name="forename">
    </p>
    <p style="text-align: center;"> <b style="font-style: oblique; color: darkblue"> Фамилия:</b> <br>
        <input type="text" size="40" name="surname">
    </p>
    <p style="text-align: center;"> <b style="font-style: oblique; color: darkblue"> Email:</b> <br>
        <input type="text" size="40" name="email">
    </p>
    <p style="text-align: center;"><b style="font-style: italic ; color: darkblue">Пароль</b><br>
        <input type="password" size="40" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
               title="Должен содержать не менее одной цифры и
         одной заглавной и строчной буквы и не менее 8 или более символов" required>
    </p>
    <p style="text-align: center;"><b style="font-style: italic ; color: darkblue">Дата рождения</b><br>
        <input type="date"  name="birthdate"
          min="1940-01-01" max="2020-12-31">
    </p>
    <p style="text-align: center;">
        <button style="vertical-align: middle; font-weight: bold;  size: 9px; background-color: lightcyan"> OK </button>
    </p>
</form>

</body>

</html>



