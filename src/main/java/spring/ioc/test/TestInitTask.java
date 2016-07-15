package spring.ioc.test;

import spring.ioc.dao.GeneralDao;
import spring.ioc.db.AppDb;
import spring.ioc.service.MyService;

/**
 * Created by Alex on 14.07.2016.
 */
public class TestInitTask {
    public static void main(String[] args) {

        ServiceLocator serviceLocator = new ServiceLocator();
        MyService myService = (MyService)serviceLocator.get("myService");


    }
}
