<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<param name="FlashVars" value="${fn:escapeXml(flashVars)}" />
<%@ page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <title>Сериалы тут!</title>
    <link rel="shortcut icon"  type="ico/png" href="images/favicon.ico">
</head>
<body>
<p style="text-align: right">
    <button><a href="registration"> Личный кабинет </a></button>
    <button> <a href="authentication"> Выход </a>  </button>  </p>
</p>
</body>



<p style="text-align: right">
<input name="s" placeholder="Искать здесь..." type="search" >
<button type="submit"><img src="/images/loupe.png"
                           style="vertical-align: middle"></button>


<p style="horiz-align: center">
    <img src="<spring:url value="../images/lion.png"/>">



<body style="background-color: cadetblue; text-align: center">
<h1>СЕРИАЛЫ ТУТ!</h1>
</body>


<body>
<p style="text-align: center">
    <button>ТОП сериалов!
        <img src="../images/fire.png"
             style="vertical-align: middle"></button>
    <button>ТОП обсуждений!
        <img src="../images/fire.png"
             style="vertical-align: middle"></button></p>
</body>

</html>