<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
    <form style="width: 100%; height: 100%" id="chektaxResultForm" action="${pageContext.servletContext.contextPath}/chektaxResult" method="post">
        <table style="height: 100%">
            <tr>
                <td>Наименование вида деятельности</td>
                <td align="center">"${sessionScope.name_ved}"</td>
            </tr>
            <tr>
                <td>Ваш класс профессионального риска</td>
                <td align="center">"${sessionScope.risk_class}"</td>

            </tr>
            <tr>
                <td>Ваш тариф</td>
                <td align="center">"${sessionScope.rate}"</td>
            </tr>
            <tr>
                <td>Сумма страховых взносов</td>
                <td align="center">"${sessionScope.contribution} руб."</td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
