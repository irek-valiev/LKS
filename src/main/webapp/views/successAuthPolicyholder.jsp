<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Успешная аутентификация</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/>
<div style="width: 100%; height: 600px; display: flex; justify-content: center; align-items: center; background-color: #1082d4">
    <div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
        <form id="policyholderSuccessAuthentificationForm" style="height: 100%" action="${pageContext.servletContext.contextPath}/views/enterSystem.jsp" method="post">
            <table style="height: 100%">
                <tr>
                    <td>
                        <label>Страхователь</label>
                        <output>"${sessionScope.nameOfCompany}"</output>
                        <label>успешно идентифицирован!</label>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input type="submit" name="enterSystem" value="Перейти в систему"/>
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
