package com.AddPets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class PetServlet extends HttpServlet {

  private final Logger log = LogManager.getLogger(PetServlet.class);

  public PetServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<Pet> pets = new ArrayList<>();

    try {
      SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session = factory.openSession();

      pets = session.createQuery("from Pet", Pet.class).list();

      session.close();
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }

    request.setAttribute("pets", pets);
    try {
      request.getServletContext().getRequestDispatcher("/all_pets.jsp").forward(request, response);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
