<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
    <form style="width: 100%; height: 100%" id="withdrawalForm" action="${pageContext.servletContext.contextPath}/withdrawal" method="post">
        <table style="height: 100%">
            <tr>
                <td><label>Сумма</label></td>
                <td><input type="number" min="0" max="99999" name="wihtdrawal_sum"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" style="width: 100%" value="Вывести"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
