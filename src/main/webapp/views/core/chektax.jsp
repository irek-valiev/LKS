<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
    <form style="width: 100%; height: 100%" id="chekTaxForm" action="${pageContext.servletContext.contextPath}/chekTax" method="post">
        <table style="height: 100%">
            <tr>
                <td><label>Год</label></td>
                <td><select name="year" required style="width: 100%" >
                    <option selected disabled>Выберите год</option>
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                    <option value="2020">2020</option>
                </select>
                </td>
            </tr>
            <tr>
                <td><label>Месяц</label></td>
                <td><select name="month" required style="width: 100%" >
                    <option selected disabled>Выберите месяц</option>
                    <option value="01">Январь</option>
                    <option value="02">Февраль</option>
                    <option value="03">Март</option>
                    <option value="04">Апрель</option>
                    <option value="05">Май</option>
                    <option value="06">Июнь</option>
                    <option value="07">Июль</option>
                    <option value="08">Август</option>
                    <option value="09">Сентябрь</option>
                    <option value="10">Октябрь</option>
                    <option value="11">Ноябрь</option>
                    <option value="12">Декабрь</option>

                </select>
                </td>
            </tr>
            <tr>
                <td><label>Фонд оплаты труда за указанный месяц</label></td>
                <td><input style="width: 100%" type="number" min="0" max="999999" step="0.01" name="totalSalaryMonth" required placeholder="Введите ФОТ"></td>
            </tr>
            <tr>
                <td><label>Код основного вида экономической<br>деятельности в предыдущем финансовом году</label></td>
                <td><select name="kodOkved" required style="width: 100%">
                    <option selected disabled>Выберите код ОКВЭД</option>
                    <c:forEach items="${allOkveds}" var="okved">
                        <option value="${okved.kod_okved}">${okved.kod_okved}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input style="width: 100%" type="submit" value="Расчитать"></td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>