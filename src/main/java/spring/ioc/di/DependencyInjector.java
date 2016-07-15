package spring.ioc.di;


import spring.ioc.common.Inject;
import spring.ioc.db.AppDb;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 14.07.2016.
 */
public class DependencyInjector {

    private Map<String,Object> context;

    public DependencyInjector() {
        context = new HashMap<>();
        context.put("spring.ioc.db.AppDb", new AppDb());
    }

    public void inject(Object target){
        Class cl = target.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field filed : fields) {
            filed.setAccessible(true);
            if (filed.isAnnotationPresent(Inject.class)) {
                String typeName = filed.getType().getTypeName();
                Object injectObj = context.get(typeName);
                try {
                    filed.set(target, injectObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
