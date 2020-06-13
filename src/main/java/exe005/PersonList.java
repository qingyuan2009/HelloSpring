package exe005;

import java.util.List;

import exe003.Car;

public class PersonList {
    
    private String name;
    private List<Car> cars;  // Car[] cars;  Set<Car> cars
    
    public PersonList() {
        super();
    }
    
    @Override
    public String toString() {
        return "PersonList [name=" + name + ", cars=" + cars + "]";
    }

    public PersonList(String name, List<Car> cars) {
        super();
        this.name = name;
        this.cars = cars;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
    

}
