package ua.homework.testio.soap.endpoint;

import ua.homework.testio.exception.NoStudentFoundException;
import ua.homework.testio.exception.RegisterException;
import ua.homework.testio.model.Student;
import ua.homework.testio.service.StudentService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentEndpoint{

    @WebMethod
    Student login(String login) throws NoStudentFoundException;

    @WebMethod
    Student getStudentInfo(int id) throws NoStudentFoundException;

    @WebMethod
    Student register(Student newStudent) throws RegisterException;

   /* @Override
    @WebMethod
    List<Student> getAll(int start, int end);*/
}
