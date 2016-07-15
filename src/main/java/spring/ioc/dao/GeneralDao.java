package spring.ioc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.ioc.common.Inject;
import spring.ioc.model.MyUser;
import spring.ioc.db.AppDb;

@Component
public class GeneralDao {

    @Autowired
    private AppDb db;

    private String name;

    public GeneralDao() {
    }

    public GeneralDao(AppDb db, String name) {
        this.db = db;
        this.name = name;
    }

    public MyUser find(String email) {
        return db.getUsrMap().get(email);
    }

    public AppDb getDb() {
        return db;
    }

    public void setDb(AppDb db) {
        this.db = db;
    }
}
