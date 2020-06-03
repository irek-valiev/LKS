<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница аутентификации</title>
</head>
<body>
<jsp:include page="../views/headers/index_header.jsp"/>
<div style="width: 100%; height: 600px; display: flex; justify-content: center; align-items: center; background-color: #1082d4">
    <div align="center" style="width: 100%; height: 160px; background-color: #fffda0" >
        <form style="width: 100%; height: 100%;" id="policyholderAuthForm" action="${pageContext.servletContext.contextPath}/auth" method="post">
            <table style="height: 100%">
                <tr>
                    <td>
                        <label>Логин</label>
                    </td>
                    <td>
                        <input id="authLogin" type="text" name="login">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Пароль</label>
                    </td>
                    <td>
                        <input type="password" name="pswd">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="authEnterBotton" style="width: 100%" type="submit" value="Войти">
                    </td>
                </tr>

            </table>
        </form>

    </div>

</div>

</body>
<footer>
    <table align="center" style="height: 100%; width: 100%">
        <td align="center">
            <label>Copyright: IT-park Kazan. Valiev Irek, 2020</label>
        </td>
    </table>
</footer>
</html>
