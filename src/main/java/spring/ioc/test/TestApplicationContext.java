package spring.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.exception.MyAppException;
import spring.ioc.service.MyService;

/**
 * Created by Alex on 14.07.2016.
 */
public class TestApplicationContext {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/week8.spring/app-context.xml");
        MyService service = (MyService) context.getBean("service");
        try {
            String accessKey = service.login("123@gmail.com", "12345678");
            System.out.println(accessKey);
        } catch (MyAppException e) {
            e.printStackTrace();
        }
    }
}
