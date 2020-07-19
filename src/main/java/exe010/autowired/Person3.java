package exe010.autowired;

public class Person3 {
    
    private String name;
    
    private Car4 car;
    
    private Address2 address;
    
    public Person3() {
        super();        
    }

    public Person3(String name, Car4 car, Address2 address) {
        super();
        this.name = name;
        this.car = car;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car4 getCar() {
        return car;
    }

    public void setCar(Car4 car) {
        this.car = car;
    }

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person3 [name=" + name + ", car=" + car + ", address=" + address + "]";
    } 

}
