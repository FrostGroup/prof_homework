package ua.homework.testio.soap.endpoint;

import ua.homework.testio.exception.NoStudentFoundException;
import ua.homework.testio.exception.RegisterException;
import ua.homework.testio.model.Student;
import ua.homework.testio.service.StudentService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ua.homework.testio.soap.endpoint.StudentEndpoint")
public class StudentEndpointImpl implements StudentEndpoint {

    private StudentService studentService;

    public StudentEndpointImpl() {
    }

    public StudentEndpointImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Student login(String login) throws NoStudentFoundException {
        return studentService.login(login);
    }

    @Override
    public Student getStudentInfo(int id) throws NoStudentFoundException {
        return studentService.getStudentInfo(id);
    }

    @Override
    public Student register(Student newStudent) throws RegisterException {
        return studentService.register(newStudent);
    }

   /* @Override
    public List<Student> getAll(int start, int end) {
        return studentService.getAll(start, end);
    }*/
}
