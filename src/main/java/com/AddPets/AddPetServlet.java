package com.AddPets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet
public class AddPetServlet extends HttpServlet {
  public AddPetServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Pet newPet = new Pet();

    newPet.setName(request.getParameter("petName"));
    newPet.setAnimalType(request.getParameter("petType"));
    newPet.setColor(request.getParameter("petColor"));
    newPet.setAdoptionFee(request.getParameter("petFee"));

    InsertPetUtil.savePet(newPet);

//    if (petSaved) {
//      request.setAttribute("saveSuccess", "true");
//    } else {
//      request.setAttribute("saveSuccess", "false");
//    }

    request.setAttribute("newPet", newPet);

    try {
      request.getServletContext().getRequestDispatcher("/add_pet.jsp").forward(request, response);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  private static List<String> getColors() {
    return new ArrayList<>(Arrays.asList(
        "red", "orange", "yellow", "green", "blue", "violet", "pink",
        "brown", "gold", "silver", "white", "black", "grey"));
  }
}

