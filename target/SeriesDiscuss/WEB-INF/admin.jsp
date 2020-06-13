<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title> Admin </title>
</head>
<body>
<h2 style="color: darkslategray; size: 12px; text-align: center; font-weight: bolder "> All users: </h2>
</body>
</html>

<html>
<body>
<form action="admin" method="get">
    <table style="margin: auto" border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Password</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td> ${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>

<hr style="border-width: 3px;">

<html>
<head>
    <a href="successfulReg.jsp"/>
</head>
<body>
<p style="text-align: center;"> Home page </p>
</body>
</html>