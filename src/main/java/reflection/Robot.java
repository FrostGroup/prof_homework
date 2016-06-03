package reflection;

/**
 * Created by Alex on 31.05.2016.
 */
public class Robot {
    @Save
    private int id;
    @Save
    private String model;
    @Save
    private double price;

    public Robot(){
    }

    public Robot(int id, String model, double price){
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public int getId(){
       return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (id != robot.id) return false;
        if (Double.compare(robot.price, price) != 0) return false;
        return model != null ? model.equals(robot.model) : robot.model == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
