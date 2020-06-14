package factoryBean;

import org.springframework.beans.factory.FactoryBean;

import exe003.Car;

public class CarFactoryBean implements FactoryBean<Car>{

    //���ض���
    public Car getObject() throws Exception {
        Car car = new Car("Toyota", "BMW", 200000.00);        
        return car;
    }

    //Bean��������
    public Class<?> getObjectType() {
       return Car.class;
    }

    //����
    public boolean isSingleton() {       
        return true;
    }

}
