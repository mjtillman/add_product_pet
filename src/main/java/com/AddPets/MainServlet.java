package com.AddPets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
public class MainServlet extends HttpServlet {
  public MainServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<Pet> pets = new ArrayList<>();

    try {
      SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session = factory.openSession();
      pets = session.createQuery("FROM Pet", Pet.class).list();
      session.close();

    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

    request.setAttribute("pets", pets);
    request.setAttribute("colors", getColors());

    try {
      request.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
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
