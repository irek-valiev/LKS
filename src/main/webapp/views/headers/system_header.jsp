<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<table width="100%">
    <tr>
        <td width="30%" align="left"><img src="${pageContext.servletContext.contextPath}/pic/fss.png"></td>
        <td width="40%"> <h1 align="center">Личный кабинет страхователя</h1></td>
        <td width="15%" align="right">
            <form id="profileHeaderSystemForm" action="${pageContext.servletContext.contextPath}/initProfile" method="post">
                <input id="profileHeaderSystemButton" type="submit" name="profileButton" value="Профиль" style="width: 200px; height: 50px; font-size: medium">
            </form>
        </td>
        <td width="15%" align="right">
            <form id="logoutForm" action="../logout" method="post">
                <input id="logoutButton" type="submit" name="logoutButton" value="Выйти" style="width: 200px; height: 50px; font-size: medium">
            </form>
        </td>
    </tr>

</table>
</body>
</html>
