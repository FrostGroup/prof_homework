package maping;

import com.google.gson.Gson;

/**
 * Created by Alex on 31.05.2016.
 */
public class TestMapping {

    public static void main(String[] args) {
        Gson gson = new Gson();

        String jsonDep = gson.toJson(new DepartmentPrivatBank("name1", "sdd", 1, "UA", "Kyev", 1234,
                "+38050", "@gmail.com", "mdfdfsd"));

        String jsonDep2 = gson.toJson(new DepartmentPrivatBank());

        System.out.println(jsonDep);

        System.out.println(jsonDep2);
    }
}
