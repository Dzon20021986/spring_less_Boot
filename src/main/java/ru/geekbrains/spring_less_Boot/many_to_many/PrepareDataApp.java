package ru.geekbrains.spring_less_Boot.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareDataApp {
    public static void forcePrepareData() {  ///// подготовка данных
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("import.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            factory.close();
            if (session != null){
                session.close();
            }
        }
    }

    public static void main(String[] args) throws  Exception {
        forcePrepareData();
    }

}
