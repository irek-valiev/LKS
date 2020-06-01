<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Регистрация</title>
</head>
<body>
<jsp:include page="../views/headers/registration_header.jsp"/>
<div style="width: 100%; line-height: 600px; vertical-align: bottom">
<div align="center" style="background-color: #0a1bd4">
    <form id ="policyholderRegistrationForm" action="${pageContext.servletContext.contextPath}/regPolicyholder" method="post">
        <table>
            <tr>
                <td>
                    <label>Логин</label>
                    <input type="text" name="login">
                    <label>Пароль</label>
                    <input type="text" name="pswd">
                    <label>Наименование организации</label>
                    <input type="text" name="nameOfCompany">
                    <label>ИНН</label>
                    <input type="text" name="inn">
                    <label>Директор</label>
                    <input type="text" name="director">
                    <input type="submit" value="Зарегистрировать">
                </td>
            </tr>
            <tr>
                <td>
                    ${param.message}
                </td>
            </tr>
        </table>

    </form>
    </div>
</div>
</body>
</html>
