package spring.ioc.test;

import spring.ioc.dao.GeneralDao;
import spring.ioc.db.AppDb;
import spring.ioc.service.MyService;

/**
 * Created by Alex on 14.07.2016.
 */
public class ServiceLocator {

    private final AppDb db;
    private MyService myService;
    private final GeneralDao genDao;

    public ServiceLocator() {
        myService = new MyService();
        genDao = new GeneralDao();
        db =new AppDb();
        genDao.setDb(db);
        myService.setGenDao(genDao);
    }

    public Object get(String name){
        if("myService".equals(name)){
            return myService;
        }
        return null;
    }
}
