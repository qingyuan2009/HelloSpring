package exe003;

public class Car {
    
    private String brand;
    private String corp;
    private double price;
    
    public Car() {
        super();       
    }    
    public Car(String brand, String corp, double price) {
        super();
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    } 
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCorp() {
        return corp;
    }
    public void setCorp(String corp) {
        this.corp = corp;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + "]";
    }  

}
