package ua.homework.testio.test;

import ua.homework.testio.model.Course;
import ua.homework.testio.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.StringContent;

/**
 * Created by Alex on 09.07.2016.
 */
public class TestFetchType {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Teacher teacher1 = new Teacher("Ivan", 5);

        for (int i = 0; i < 1000; i++) {
            teacher1.getCourses().add(new Course(String.valueOf(i), "desv", teacher1));

        }

        manager.getTransaction().begin();
        manager.persist(teacher1);
        manager.getTransaction().commit();

        manager.clear();

        Teacher teacher = manager.createQuery("SELECT t FROM Teacher t WHERE t.name = :tName", Teacher.class)
                .setParameter("tName", "Ivan").getSingleResult();

        System.out.println(teacher);

        int level = teacher.getLevel();

        int size = teacher.getCourses().size();


    }
}
