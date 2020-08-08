package exe014.dataSource;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestDataSource {

    @Test
    public void test() throws Exception {
        
        //通过Spring C3P0连接池来连接
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        //DataSource 是ComboPooledDataSource的父类
        DataSource ds = context.getBean("dataSource", DataSource.class);
        System.out.println("datasource is " + ds);
        System.out.println("connection is " + ds.getConnection());        
    }

}