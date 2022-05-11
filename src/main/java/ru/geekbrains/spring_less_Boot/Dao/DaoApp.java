package ru.geekbrains.spring_less_Boot.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.spring_less_Boot.many_to_many.PrepareDataApp;
import ru.geekbrains.spring_less_Boot.many_to_many.Product;

public class DaoApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("many_to_many/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
            ProductDao productDao = new ProductDao(factory);
            Product p = productDao.findById(1L);
        } finally {
            close();
        }
    }

    public static void close() {
        factory.close();
    }

}
