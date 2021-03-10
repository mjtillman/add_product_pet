package com.AddPets;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory sessionFactory;

  static {
    try {
      Configuration config = new Configuration();
      config.configure("hibernate.cfg.xml");
      config.addAnnotatedClass(com.AddPets.Pet.class);
      StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().
          configure().build();
      Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
      sessionFactory = metadata.getSessionFactoryBuilder().build();
    } catch (Throwable th) {
      System.out.println(th.getMessage());
      throw new ExceptionInInitializerError(th);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
