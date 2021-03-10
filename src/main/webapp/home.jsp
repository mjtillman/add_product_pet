<%@ page import="com.AddPets.Pet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Pet> pets = (ArrayList<Pet>)request.getAttribute("pets");
    List<String> colors = (ArrayList<String>)request.getAttribute("colors");
%>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>Adopt A Pet!</title>
    <link rel="stylesheet" href="style.css" />
    <script src="validate.js"></script>
</head>
<body>
    <h2>Adopt A Pet!</h2>
    <form action='pet_details' method='POST'>
    <table>
        <tr>
            <th colspan='4'>
                <h3>Choose a pet...</h3>
            </th>
        </tr>
        <tr>
            <% for (Pet p : pets) {
                    out.println("<td>");
                    out.println("<button type='submit' name='pet_id' value='" + p.getId() + "'>");
                    out.println(p.getId());
                    out.println("</button></td>");
                    if (p.getId() % 4 == 0) {
                        out.println("</tr><tr>");
                    }
                }
            %>
        </tr>
        </form>
        <tr>
            <td colspan='4'>
                <form action='all_pets' name="allPets" method='GET'>
                    <input type='submit' value='...or view all pets' />
                </form>
            </td>
        </tr>
    </table>
    </form>
    <div>
        <h2>Add A New Pet</h2>
        <form action='/add_pet' name="addPetForm" method='post' id='addPetForm' onsubmit='return validateForm()'>
        <table style='margin-top: 20px;'>
            <tr>
                <td class='left'>
                    <label for='petName'>Pet's Name:</label>
                </td>
                <td class='right'>
                    <input type='text' id='petName' name ='petName'>
                </td>
            </tr>
            <tr>
                <td class='left'>
                    <label for='type'>Animal Type:</label >
                </td>
                <td class='right'>
                    <input type='text' id ='petType' name='petType'>
                </td>
            </tr>
            <tr>
                <td class='left'>
                    <label for='color'>Color:</label><br />
                </td>
                <td class='right'>
                    <select name='petColor' id='petColor' form='addPetForm' >
                        <option value=''>Select color</option>
                        <% for (String c : colors) {
                            out.println("<option value='" + c + "'>" + c + "</option>");
                        } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td class='left'>
                    <label for='fee'>Adoption Fee:</label>
                </td>
                <td class='right'>
                    <input type='text' id ='petFee' name='petFee'>
                </td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input type='submit' value='Add Pet'>
                </td>
            </tr>
        </table>
        </form>
    </div>
    <div id='formMsg'>
    </div>
</body>
</html>