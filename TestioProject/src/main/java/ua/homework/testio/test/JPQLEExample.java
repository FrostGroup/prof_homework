package ua.homework.testio.test;

import ua.homework.testio.model.Student;
import ua.homework.testio.model.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 08.07.2016.
 */
public class JPQLEExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Query query = manager.createQuery("SELECT u FROM Student u WHERE u.name=:inName");

        List list = query.setParameter("inName", "Sasha").setFirstResult(1).setMaxResults(3).getResultList();

        list.stream().forEach(System.out::println);

    }
}
