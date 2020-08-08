package exe014.dataSource;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestDataSource {

    @Test
    public void test() throws Exception {
        
        //ͨ��Spring C3P0���ӳ�������
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        //DataSource ��ComboPooledDataSource�ĸ���
        DataSource ds = context.getBean("dataSource", DataSource.class);
        System.out.println("datasource is " + ds);
        System.out.println("connection is " + ds.getConnection());        
    }

}