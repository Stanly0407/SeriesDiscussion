<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<param name="FlashVars" value="${fn:escapeXml(flashVars)}"/>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <link rel="shortcut icon" href="<spring:url value="../images/favicon.ico.png"/>">
</head>

<body style="background-color: cadetblue; ">

<h2 style="color: darkslategray; size: 12px; text-align: center; font-weight: bolder "> Вход </h2>

<hr style="border-width: 3px;">
<%--<security:authorize access="isAuthenticated()">--%>
<%--    <% response.sendRedirect("/"); %>--%>
<%--</security:authorize>--%>
<form action='<spring:url value="/loginAction"/>' method="post">

    <p style="text-align: center;"><b style="font-style: oblique; color: darkblue"> E-mail:</b> <br>
        <input type="text" size="40" name="username" title="Поле должно быть заполнено" required>
    </p>
    <p style="text-align: center;"><b style="font-style: italic ; color: darkblue">Пароль</b><br>
        <input type="password" size="40" name="password" title="Поле должно быть заполнено" required>
    </p>
    <p style="text-align: center;"><b style="font-style: italic ; color: darkblue">Запомнить</b><br>
        <input type="checkbox" name="remember-me"/>
    </p>
    <p style="text-align: center;">
        <button style="vertical-align: middle; font-weight: bold;  size: 9px; background-color: lightcyan"> OK</button>

</form>

</p>
<%--<security:authorize access="!isAuthenticated()">--%>
<%--</security:authorize>  --%>

    <p style="text-align: center;"><a href="${pageContext.request.contextPath}/registration">Registration </a></p>

</body>
</html>