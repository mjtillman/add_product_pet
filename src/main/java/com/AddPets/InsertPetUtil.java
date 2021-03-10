package com.AddPets;

import org.hibernate.Session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet
public class InsertPetUtil {

  public static void savePet(final Pet newPet) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    session.save(newPet);
    session.getTransaction().commit();
  }

//  public static boolean checkPetSave(Session session, Long id) {
//
//    Pet checkPet = session.createQuery("FROM Pet P WHERE P.id = " + id, Pet.class)
//        .getSingleResult();
//
//    session.close();
//
//    return checkPet != null;
//  }
}