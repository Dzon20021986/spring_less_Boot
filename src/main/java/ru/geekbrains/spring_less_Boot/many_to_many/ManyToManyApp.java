package ru.geekbrains.spring_less_Boot.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("many_ta_many/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Customer customer = session.createQuery("SELECT c FROM Customer c WHERE c.products.size = (select MAX(c2.products.size) from Customer  c2)", Customer.class).getSingleResult();
            System.out.println(customer);
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }

    }
}
