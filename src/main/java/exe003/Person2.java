package exe003;

public class Person2 {

    private Integer id;
    private String name;
    private Car car;  
    
    public Person2() {
        super();
    }
    
    public Person2(Integer id, String name, Car car) {
        super();
        this.id = id;
        this.name = name;
        this.car = car;
    }
    
    @Override
    public String toString() {
        return "Person2 [id=" + id + ", name=" + name + ", car=" + car + "]";
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    
    
}
