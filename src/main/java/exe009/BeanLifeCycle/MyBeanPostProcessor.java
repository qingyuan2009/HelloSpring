package exe009.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    // Bean ��ʼ��֮ǰ����
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Processor Before Initialization");
        return bean;
    }

    // Bean ��ʼ��֮�󴥷�
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Processor after Initialization");
        return bean;
    }

}
