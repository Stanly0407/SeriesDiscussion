<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<param name="FlashVars" value="${fn:escapeXml(flashVars)}" />
<%@ page contentType="text/html;charset=utf-8" %>


<html>
<body>
<p style="text-align: right">
    <button>Регистрация</button>
    <button>Вход</button></p>
</body>
</html>

<html>
<body>
<p style="text-align: right">
<input name="s" placeholder="Искать здесь..." type="search" >
<button type="submit"><img src="images/loupe.png"
                           style="vertical-align: middle"></button>
</body>
</html>

<html>
<body>
<p style="horiz-align: center">
<img src="images/lion.png">
</body>
</html>

<html>
<body style="background-color: cadetblue; text-align: center">
<h2>СЕРИАЛЫ ТУТ!</h2>
</body>
</html>

<html>
<body>
<p style="text-align: center">
    <button>ТОП сериалов!
        <img src="images/fire.png"
             style="vertical-align: middle"></button>
    <button>ТОП обсуждений!
        <img src="images/fire.png"
             style="vertical-align: middle"></button></p>
</body>
</html>