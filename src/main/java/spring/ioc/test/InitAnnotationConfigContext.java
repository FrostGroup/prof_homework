package spring.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.dao.GeneralDao;
import spring.ioc.model.MyUser;

/**
 * Created by Alex on 15.07.2016.
 */
public class InitAnnotationConfigContext {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.ioc");

        GeneralDao  generalDao = applicationContext.getBean(GeneralDao.class);
        MyUser myUser = generalDao.find("123@gmail.com");

        System.out.println(myUser);

    }
}
