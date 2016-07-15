package ua.homework.testio.service;

import ua.homework.testio.exception.NoStudentFoundException;
import ua.homework.testio.exception.RegisterException;
import ua.homework.testio.model.Student;

import java.util.List;

/**
 * Created by Alex on 07.07.2016.
 */
public interface StudentService {

    Student login(String login) throws NoStudentFoundException;
    Student getStudentInfo(int id) throws NoStudentFoundException;
    Student register(Student newStudent) throws RegisterException;
    List<Student> getAll(int start, int end);


}
