package ua.homework.testio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.homework.testio.dao.StudentDao;
import ua.homework.testio.exception.NoStudentFoundException;
import ua.homework.testio.exception.RegisterException;
import ua.homework.testio.model.Student;

import java.util.List;


public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student login(String login) throws NoStudentFoundException {

        Student student = studentDao.find(login);
        if (student == null){
            throw new NoStudentFoundException("no student with login" + login);
        }
        return student;
    }

    @Override
    public Student getStudentInfo(int id) throws NoStudentFoundException {

        Student student = studentDao.find(id);
        if (student == null){
            throw new NoStudentFoundException("no student with id" + id);
        }
        return student;
    }

    @Override
    public Student register(Student newStudent) throws RegisterException {
        return studentDao.create(new Student());
    }

    @Override
    public List<Student> getAll(int start, int end) {
        return studentDao.getAll(start,end);
    }
}
