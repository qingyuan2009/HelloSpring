package exe009.BeanLifeCycle;

public class Car3 {

    private String brand;
    private String corp;
    private double price;

    public Car3() {
        System.out.println("stage 1: ���ù���������Bean����");
    }

    // �Լ�ʵ�ֵĳ�ʼ����������Bean�ļ�������
    public void BeanInit() {
        System.out.println("stage 3: ����Bean�ĳ�ʼ������");
    }

    // IOC�����رգ��Լ�ʵ�ֵ����ٷ���
    public void BeanDestroy() {
        System.out.println("stage 5: ����Bean�����ٷ���");
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
        System.out.println("stage 2: ����set������Bean����ֵ");
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
