package exe015.jdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class TestJDBCTemplate {
    
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate npjt;
    private StudentDAO studentDao;
    
    @Before
    public void init() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        npjt = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        
        //注意一定要开启组件扫描 <context:component-scan base-package="exe015.jdbcTemplate"></context:component-scan> 
        studentDao = context.getBean("studentDAO", StudentDAO.class);
    }
    
    //@Test
    // update: CUD
    public void testUpdate() {        
        String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, 1, 879,998, "Qingyuan","shanghai", 99); 
        jdbcTemplate.update(sql, new Object[] {2,345,567,"Rui","Sydney", 33});
    }
    
    //@Test
    // batch update
    public void testBatchUpdate() {
        String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) values (?,?,?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{2,111,222,"Sun","QingDao", 88});
        batchArgs.add(new Object[]{3,222,333,"Zhang","Shanghai", 55});
        jdbcTemplate.batchUpdate(sql, batchArgs);        
    }
    
    @Test
    //queryforObject  -- 返回mapping好的对象
    public void testQueryForObject() {
        String sql = "select flowid, studentname, grade from examstudent where flowid  = ?";
        //rowMapper: 将结果集映射到对象
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper, 2);  // 2 = query argument
        System.out.println(student);
    }
    
    @Test
    //queryforObjectReturnValue   -- 返回单个值
    public void testQueryForObjectReturnValue() {
        String sql = "select count(flowid) from examstudent";     
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);  
        System.out.println(result);
    }
    
    @Test
    //query   -- 返回mapping好的对象List
    public void testQuery() {
        String sql = "select flowid, studentname, grade from examstudent";     
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> students = jdbcTemplate.query(sql, rowMapper);  
        System.out.println(students);
    }
    
    //@Test
    //具名参数模板   -- paramMap 不推荐
    public void testNamedParameterJdbcTemplate() {
        String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) values (:type, :idcard,:examcard,:name, :loc, :grade)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("type", 333);
        paramMap.put("idcard", 555);        
        paramMap.put("examcard", 666);
        paramMap.put("name", "Xu");
        paramMap.put("loc", "Beijing");
        paramMap.put("grade", 56);
        npjt.update(sql, paramMap);
    }
    
    //@Test
    //具名参数模板   -- SqlParameterSource
    public void testNamedParameterObject() {
        //SQL 里的parameter必须和类里的attribute完全一致, 区别大小写
        String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) "
                + "values (:type, :idcard,:examcard,:studentName, :location, :grade)";        
        Student student = new Student(777, 888, 999, "Wang", "German", 55);
        SqlParameterSource sps = new BeanPropertySqlParameterSource(student);
        npjt.update(sql, sps);        
    }
    
    //@Test
    //使用DAO  -- 推荐
    public void testStudentDAO() {
        Student student = new Student(356, 766, 888, "LI", "Wuhan", 66);
        studentDao.insertStudent(student);    
    }
   
    
    
    
    

}
