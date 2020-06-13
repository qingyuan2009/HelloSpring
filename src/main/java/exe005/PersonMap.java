package exe005;

import java.util.Map;

import exe003.Car;

public class PersonMap {
    
    private String name;
    private Map<String, Car> cars; 
    
    @Override
    public String toString() {
        return "PersonMap [name=" + name + ", cars=" + cars + "]";
    }
    public PersonMap() {
        super();
    }
    public PersonMap(String name, Map<String, Car> cars) {
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
    public Map<String, Car> getCars() {
        return cars;
    }
    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }
    
    

}
