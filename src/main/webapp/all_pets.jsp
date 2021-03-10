<%@ page import="com.AddPets.Pet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Pet> pets = (ArrayList<Pet>)request.getAttribute("pets");
%>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>View All Pets</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<h2>View All Pets</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Animal</th>
        <th>Color</th>
        <th>Adoption Fee</th>
    </tr>
    <%
        for (Pet p : pets) {
            out.println("" +
                    "<tr><td>" +
                    p.getName() +
                    "</td><td>" +
                    p.getAnimalType() +
                    "</td><td>" +
                    p.getColor() +
                    "</td><td>" +
                    p.getAdoptionFee() +
                    "</td></tr>");
        }
    %>
</table>
</body>
</html>;

