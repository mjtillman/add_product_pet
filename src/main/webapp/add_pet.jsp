<%@ page import="com.AddPets.Pet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Pet newPet = (Pet)request.getAttribute("newPet");
%>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>Submit New Pet</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>

<%
    String msg, title;
    if (newPet != null) {
        title = "Pet Successfully Saved";
        msg = "The pet was saved in the adoption database";
    } else {
        title = "Pet Save Failure";
        msg = "The pet was not saved in the adoption database";
    }
%>

<h2><% out.println(title); %></h2>
<div><em><% out.println(msg); %></em></div>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Name</th>--%>
<%--        <th>Animal</th>--%>
<%--        <th>Color</th>--%>
<%--        <th>Adoption Fee</th>--%>
<%--    </tr>--%>
<%--    --%>
<%--    <% if (petSaved) { %>--%>
<%--    <tr>--%>
<%--        <td><% out.println(name); %></td>--%>
<%--        <td><% out.println(type); %></td>--%>
<%--        <td><% out.println(color); %></td>--%>
<%--        <td><% out.println(fee); %></td>--%>
<%--    </tr>--%>
<%--    <% } %>--%>
<%--    <tr>--%>
<%--        <td colspan='4'>--%>
<%--            <% out.println(msg); %>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--</table>--%>
</body>
</html>


