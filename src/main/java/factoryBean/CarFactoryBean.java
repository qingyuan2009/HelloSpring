package factoryBean;

import org.springframework.beans.factory.FactoryBean;

import exe003.Car;

public class CarFactoryBean implements FactoryBean<Car>{

    //返回对象
    public Car getObject() throws Exception {
        Car car = new Car("Toyota", "BMW", 200000.00);        
        return car;
    }

    //Bean对象类型
    public Class<?> getObjectType() {
       return Car.class;
    }

    //单例
    public boolean isSingleton() {       
        return true;
    }

}
