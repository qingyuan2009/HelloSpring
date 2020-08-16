package exe015.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository("studentDAO")
public class StudentDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate npjt;
    
    public void insertStudent(Student student) {        
        String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) "
                + "values (:type, :idcard,:examcard,:studentName, :location, :grade)";        
        SqlParameterSource sps = new BeanPropertySqlParameterSource(student);
        npjt.update(sql, sps);         
    }

}
