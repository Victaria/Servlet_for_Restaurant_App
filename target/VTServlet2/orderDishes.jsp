<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.11.2019
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Dishes</title>
    <style>
        a.button {
            -webkit-appearance: button;
            -moz-appearance: button;
            appearance: button;

            text-decoration: none;
            color: initial;
            padding: 3px 10px;
        }
        a.selected {
            color: blue;
        }
        div.buttons {
            width: 100%;
            text-align: center;
        }
        table, td, th {
            border: 1px solid black;
        }
        th{
            padding: 10px;
            text-align: center;
        }
        td {
            padding: 3px 5px;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<div class="buttons">
    <a href="DemoServlet" class="button">Products</a>
    <a href="dishes.jsp" class="button">Dishes</a>
    <a href="orderDishes.jsp" class="button selected">Order Dishes</a>
    <a href="orders.jsp" class="button">Orders</a>
    <a href="receipts.jsp" class="button">Receipts</a>
    <a href="staff.jsp" class="button">Staff</a>
</div>
<br>
<table>
    <tr>
        <th>ID</th>
        <th>Dish</th>
        <th>Order ID</th>
        <th>Amount</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Ilya</td>
        <td>12</td>
        <td>2</td>
    </tr>
</table>
</body>
</html>
