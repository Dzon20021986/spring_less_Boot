package ru.geekbrains.spring_less_Boot.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyApp {   // многие ко многим.////
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        System.out.println("--------------------------------------");
        try{
            session = factory.getCurrentSession();

        session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            System.out.println(product.getCustomers());
            session.getTransaction().commit();














//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Customer customer = session.createQuery("SELECT c FROM Customer c WHERE c.products.size = (select MAX(c2.products.size) from Customer  c2)", Customer.class).getSingleResult();
//            System.out.println(customer);
//            session.getTransaction().commit();




        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }

    }
}
