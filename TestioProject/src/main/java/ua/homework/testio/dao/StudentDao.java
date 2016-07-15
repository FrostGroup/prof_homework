package ua.homework.testio.dao;

import ua.homework.testio.model.Student;

import java.util.List;

/**
 * Created by Alex on 15.07.2016.
 */
public interface StudentDao {

    Student create(Student student);

    Student remove(int id);

    Student find(String login);

    Student find(int id);

    List<Student> getAll(int start, int end);
}
