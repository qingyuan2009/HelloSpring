package exe015.jdbcTemplate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJDBCTemplate {
    
    private JdbcTemplate jdbcTemplate;
    
    @Before
    public void init() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
    }
    
    //@Test
    // update: CUD
    public void testUpdate() {        
        String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, 1, 879,998, "Qingyuan","shanghai", 99); 
        jdbcTemplate.update(sql, new Object[] {2,345,567,"Rui","Sydney", 33});
    }

}
