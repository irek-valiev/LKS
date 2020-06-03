<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #fffda0">
   <form style="width: 100%; height: 100%" id="transferForm" action="${pageContext.servletContext.contextPath}/transfer" method="post">
      <table style="height: 100%">
         <tr>
            <td><label>Кому</label></td>
            <td><select name="toPolicyholder" style="width: 100%">
               <option selected disabled>Выберите страхователя</option>
               <c:forEach items="${allPolicyholders}" var="policyholder">
                  <option value="${policyholder.account.id}">${policyholder.nameOfCompany}</option>
               </c:forEach>
            </select>
            </td>
         </tr>
         <tr>
            <td><label>Сумма</label></td>
            <td><input style="width: 100%" type="number" min="0" max="99999" name="transferSum"></td>
         </tr>
         <tr>
            <td colspan="2"><input style="width: 100%" type="submit" value="Отправить"></td>
         </tr>
      </table>
   </form>
</div>
</body>
</html>
