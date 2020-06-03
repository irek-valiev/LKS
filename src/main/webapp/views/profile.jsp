<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница профиля</title>
</head>
<body>
<jsp:include page="headers/profile_header.jsp"/>
<div style="width: 100%; height: 600px; display: flex; justify-content: center; align-items: center; background-color: #1082d4">
<div align="center" style="width: 100%; height: 170px; background-color: #fffda0">
    <form style="width: 100%; height: 100%" id="policyholderAuthForm" action="${pageContext.servletContext.contextPath}/auth" method="post">
        <table style="height: 100%">
            <tr>
                <td>Логин</td>
                <td align="center">"${sessionScope.login}"</td>
            </tr>
            <tr>
                <td>Наименование<br>организации</td>
                <td align="center">"${sessionScope.nameOfCompany}"</td>

            </tr>
            <tr>
                <td>ИНН</td>
                <td align="center">"${sessionScope.inn}"</td>
            </tr>
            <tr>
                <td>Директор</td>
                <td align="center">"${sessionScope.director}"</td>
            </tr>
            <tr>
                <td>Номер счета</td>
                <td align="center">"${sessionScope.account_number}"</td>
            </tr>
            <tr>
                <td>Остаток<br>средств</td>
                <td align="center">"${sessionScope.sum} руб."</td>
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
