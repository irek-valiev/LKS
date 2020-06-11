
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
    <form style="width: 100%; height: 100%" id="replenishForm" action="${pageContext.servletContext.contextPath}/replenish" method="post">
        <table style="height: 100%">
            <tr>
                <td><label>Сумма</label></td>
                <td><input type="number" min="0" max="999999" step="0.01" name="replenish_sum" required placeholder="Введите сумму"></td>
            </tr>
            <tr>
                <td colspan="2"><input style="width: 100%" type="submit" value="Пополнить"></td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
