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

@WebServlet
public class DetailServlet extends HttpServlet {

  private final Logger log = LogManager.getLogger(DetailServlet.class);
  public DetailServlet() { super(); }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String strID = request.getParameter("pet_id");
      Long id = Long.parseLong(strID);
      Pet pet = new Pet();

      try {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

         pet = session.createQuery("FROM Pet P WHERE P.id = " + id, Pet.class).getSingleResult();

        session.close();
      } catch (Exception ex) {
        log.error(ex.getMessage());
        log.error(ex.getStackTrace().toString());
      }

      request.setAttribute("pet", pet);
      try {
        request.getServletContext().getRequestDispatcher("/pet_details.jsp")
            .forward(request, response);
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
