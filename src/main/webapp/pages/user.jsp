<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/11/2023
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<form action="/user/reg" method="post">
    <input type = "text" name = "id" placeholder="Id">
    <input type = "text" name = "email_address" placeholder="Email_address">
    <input type = "text" name = "phone_number" placeholder="Phone_number">
    <input type = "text" name = "password" placeholder="Password">
    <button>Submit</button>
</form>

</body>
</html>
