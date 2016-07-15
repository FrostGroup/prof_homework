package ua.homework.testio.test;

import ua.homework.testio.model.Student;
import ua.homework.testio.model.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Alex on 08.07.2016.
 */
public class EntityLifecycleTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Student student = new Student("Sasha", 2, StudentType.JUNIOR, new Date(), "dfsfs");

        manager.getTransaction().begin();
        Student student1 = manager.find(Student.class, 1);
        manager.remove(student1);
        manager.getTransaction().commit();

    }

}
