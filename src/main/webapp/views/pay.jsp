<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
    <form style="width: 100%; height: 100%" id="payForm" action="${pageContext.servletContext.contextPath}/pay" method="post">
        <table style="height: 100%">
            <tr>
                <td><label>Целевой счет</label></td>
                <td><input style="width: 100%" type="number" name="payTargetCount"></td>
            </tr>
            <tr>
                <td><label>Сумма</label></td>
                <td><input style="width: 100%" type="number" min="0" max="99999" name="paySum"></td>
            </tr>
            <tr>
                <td colspan="2"><input style="width: 100%" type="submit" value="Перечислить"></td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
