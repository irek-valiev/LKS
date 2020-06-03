<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Регистрация</title>
</head>
<body>
<jsp:include page="../views/headers/index_header.jsp"/>
<div style="width: 100%; height: 600px;  display: flex; justify-content: center; align-items: center; background-color: #1082d4">
       <div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
           <form style="height: 60px">
               <label></label>

           </form>
       <form id ="policyholderRegistrationForm" action="${pageContext.servletContext.contextPath}/regPolicyholder" method="post">
        <table align="center" >
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
<footer>
    <table align="center" style="height: 100%; width: 100%">
        <td align="center">
            <label>Copyright: IT-park Kazan. Valiev Irek, 2020</label>
        </td>
    </table>
</footer>
</html>
