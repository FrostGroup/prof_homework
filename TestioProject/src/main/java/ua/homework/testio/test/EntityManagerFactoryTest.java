package ua.homework.testio.test;

import ua.homework.testio.model.Student;
import ua.homework.testio.model.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Alex on 07.07.2016.
 */
public class EntityManagerFactoryTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Student student = new Student("Sasha", 2, StudentType.JUNIOR, new Date(), "dfsfs");

        EntityTransaction transaction = manager.getTransaction();


        try {
            transaction.begin();
            manager.persist(student);
            Student st1 = manager.find(Student.class, 0);
            transaction.commit();
            System.out.println(st1);
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            manager.close();
        }

        manager = entityManagerFactory.createEntityManager();
        Student student1 = manager.find(Student.class, 0);
        System.out.println(student1);

    }

}
