package spring.ioc.db;

import org.springframework.stereotype.Component;
import spring.ioc.model.MyUser;

import java.util.HashMap;
import java.util.Map;

@Component(value = "appDbBeen") //been id=appDbBeen"...
public class AppDb {

    private Map<String, MyUser> usrMap;

    public AppDb() {
        usrMap = new HashMap<>();
        usrMap.put("123@gmail.com", new MyUser("123@gmail.com","12345678"));
        usrMap.put("Kola@gmail.com", new MyUser("Kola@gmail.com","1234"));
    }

    public Map<String, MyUser> getUsrMap() {
        return usrMap;
    }
}
