<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Devcolibri.com</title>
    <style>
        a.button {
            -webkit-appearance: button;
            -moz-appearance: button;
            appearance: button;

            text-decoration: none;
            color: initial;
            padding: 3px 10px;
        }
        div.buttons {
            width: 100%;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="buttons">
    <a onclick="location.href='/products'" href="DemoServlet" class="button">Products</a>
    <a onclick="location.href='/dishes'" href="dishes.jsp" class="button">Dishes</a>
    <a onclick="location.href='/orderDishes'" href="orderDishes.jsp" class="button">Order Dishes</a>
    <a onclick="location.href='/orders'" href="orders.jsp" class="button">Orders</a>
    <a onclick="location.href='/receipts'" href="receipts.jsp" class="button">Receipts</a>
    <a onclick="location.href='/staff'" href="staff.jsp" class="button">Staff</a>
</div>
</body>
</html>
