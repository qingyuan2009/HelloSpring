package exe009.BeanLifeCycle;

public class Car3 {

    private String brand;
    private String corp;
    private double price;

    public Car3() {
        System.out.println("stage 1: 调用构造器创建Bean对象");
    }

    // 自己实现的初始化方法，在Bean文件中配置
    public void BeanInit() {
        System.out.println("stage 3: 调用Bean的初始化方法");
    }

    // IOC容器关闭，自己实现的销毁方法
    public void BeanDestroy() {
        System.out.println("stage 5: 调用Bean的销毁方法");
    }

    public Car3(String brand, String corp, double price) {
        super();
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("stage 2: 调用set方法给Bean对象赋值");
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
