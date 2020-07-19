package exe009.BeanLifeCycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {

    @Test
    public void testCar() {

        // ApplicationContext context ע��ApplicationContext���ṩclose ����
        // ��Ҫ����ConfigurableApplicationContext
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beanCarScope.xml");

        // Bean��life Cycle
        Car3 car = context.getBean("Car3", Car3.class);
        System.out.println("stage 4: ʹ��Bean " + car);

        //�ر�����
        context.close();

        /*
         * Result
         * stage 1: ���ù���������Bean����
         * stage 2: ����set������Bean����ֵ
         * stage 3: ����Bean�ĳ�ʼ������
         * stage 4: ʹ��Bean Car2 [brand=Audi, corp=Volkswagen, price=171000.0]
         * stage 5: ����Bean�����ٷ���
         */
        
        //ע�����������<bean class="exe009.BeanLifeCycle.MyBeanPostProcessor"></bean> 
        //BeanPostProcessor����ᱻ������ ��MyBeanPostProcessor.java
        
        

    }

}
