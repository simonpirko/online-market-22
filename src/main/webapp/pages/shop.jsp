<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/11/2023
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<form action="/shop/create" method="post">
    <input type = "text" name = "id" placeholder="Id">
    <input type = "text" name = "name" placeholder="Name">
    <input type = "text" name = "shop_address_id" placeholder="Shop_address_id">
    <input type = "text" name = "product_configuration_id" placeholder="Product_configuration_id">
    <input type = "text" name = "shipping_methods_id" placeholder="Shipping_methods_id">
    <input type = "text" name = "user_owner" placeholder="User_owner">
    <button>Submit</button>
</form>

</body>
</html>
