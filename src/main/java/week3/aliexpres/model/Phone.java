package week3.aliexpres.model;


import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class Phone {
    private String name;
    private String model;
    private String prise;

    public Phone() {
    }

    public Phone(String name, String model, String  prise) {
        this.name = name;
        this.model = model;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", prise='" + prise + '\'' +
                '}';
    }
}
