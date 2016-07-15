package ua.homework.testio.test.spring_run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.homework.testio.exception.NoStudentFoundException;
import ua.homework.testio.exception.RegisterException;
import ua.homework.testio.model.Student;
import ua.homework.testio.model.StudentType;
import ua.homework.testio.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 15.07.2016.
 */
public class StartApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);

        try {
            Student student = studentService.getStudentInfo(2);
            studentService.register(new Student("Ivan", 5, StudentType.JUNIOR, new Date(), "123"));

            List<Student> studentList = studentService.getAll(0, 100);
            studentList.stream().forEach(System.out::println);
        } catch (NoStudentFoundException e) {
            e.printStackTrace();
        } catch (RegisterException e) {
            e.printStackTrace();
        }

    }
}
