package spring.ioc.model;

/**
 * Created by Alex on 14.07.2016.
 */
public class MyUser {

    private String email;
    private String pass;

    public MyUser(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "email='" + email + '\'' +
                '}';
    }
}
