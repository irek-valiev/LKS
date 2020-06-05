<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Ошибка регистрации</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/>
<div style="width: 100%; height: 600px;  display: flex; justify-content: center; align-items: center; background-color: #1082d4">
    <div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
        <form style="width: 100%; height: 100%" id="policyholderDoubleregForm" action="${pageContext.servletContext.contextPath}/index" method="post">
            <table>
                <tr>
                    <td align="center"><label>Страхователь с указанным логином уже зарегистрирован!<br>
                        Повторите регистрацию или авторизуйтесь под действующим профилем!</label></td>
                </tr>
            </table>
            <table align="center" style="height: 100%; width: 100%; border-spacing: 10px">
                <tr>
                    <td width="50%" align="right">
                        <input type="submit" name="enter" value="Войти"
                               style="width: 200px; height: 50px; font-size: large"/>
                    </td>
                    <td width="50%">
                        <input type="submit" name="reg" value="Зарегистрироваться"
                               style="width: 200px; height: 50px; font-size: large"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
