<%@ page import="com.AddPets.Pet" %><%--
  Created by IntelliJ IDEA.
  User: mjtillman
  Date: 3/9/21
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Pet pet = (Pet)request.getAttribute("pet"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Pet Details</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<h3>View Pet Details</h3>
<table>
    <tr>
        <th>Name</th>
        <th>Animal</th>
        <th>Color</th>
        <th>Adoption Fee</th>
    </tr>
    <tr>
        <td>
        <% out.println(pet.getName()); %>
        </td><td>
        <% out.println(pet.getAnimalType()); %>
        </td><td>
        <% out.println(pet.getColor()); %>
        </td><td>
        <% out.println(pet.getAdoptionFee()); %>
        </td>
    </tr>
</table>
</body>
</html>
