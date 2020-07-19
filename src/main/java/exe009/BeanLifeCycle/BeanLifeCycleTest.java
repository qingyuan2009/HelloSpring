package exe009.BeanLifeCycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {

    @Test
    public void testCar() {

        // ApplicationContext context 注意ApplicationContext不提供close 方法
        // 需要改用ConfigurableApplicationContext
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beanCarScope.xml");

        // Bean的life Cycle
        Car3 car = context.getBean("Car3", Car3.class);
        System.out.println("stage 4: 使用Bean " + car);

        //关闭容器
        context.close();

        /*
         * Result
         * stage 1: 调用构造器创建Bean对象
         * stage 2: 调用set方法给Bean对象赋值
         * stage 3: 调用Bean的初始化方法
         * stage 4: 使用Bean Car2 [brand=Audi, corp=Volkswagen, price=171000.0]
         * stage 5: 调用Bean的销毁方法
         */
        
        //注意如果配置了<bean class="exe009.BeanLifeCycle.MyBeanPostProcessor"></bean> 
        //BeanPostProcessor处理会被触发， 见MyBeanPostProcessor.java
        
        

    }

}
