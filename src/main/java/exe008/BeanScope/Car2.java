package exe008.BeanScope;

public class Car2 {
    
    private String brand;
    private String corp;
    private double price;
    
    public Car2() {
        System.out.println("Invoke Car2 constructor");       
    }    
    public Car2(String brand, String corp, double price) {
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
        return "Car2 [brand=" + brand + ", corp=" + corp + ", price=" + price + "]";
    }  

}
