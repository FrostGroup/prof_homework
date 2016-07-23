package ua.homework.testio.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.homework.testio.service.StudentService;
import ua.homework.testio.soap.endpoint.StudentEndpointImpl;

import javax.security.auth.login.AppConfigurationEntry;
import javax.xml.ws.Endpoint;

/**
 * Created by Alex on 20.07.2016.
 */
public class RunSoapServer {
    public static void main(String[] args) {

        ApplicationContext appCon = new ClassPathXmlApplicationContext("spring-context.xml");

        StudentService studentService = appCon.getBean(StudentService.class);

        Endpoint.publish("http://192.168.0.101:9999/soap/student", new StudentEndpointImpl(studentService));
    }
}
