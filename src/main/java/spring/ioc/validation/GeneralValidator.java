package spring.ioc.validation;

/**
 * Created by Alex on 14.07.2016.
 */
public class GeneralValidator {
    public boolean isValidEmailemail(String email) {
        return email != null && email.contains("@");
    }

    public boolean isValidPass(String pass) {
        return pass != null && pass.length() >= 8;
    }
}
