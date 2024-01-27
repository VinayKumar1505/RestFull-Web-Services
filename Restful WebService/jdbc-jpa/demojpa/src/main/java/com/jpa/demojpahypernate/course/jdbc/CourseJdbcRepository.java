package  com.jpa.demojpahypernate.course.jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpa.demojpahypernate.course.jpa.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbc;
	
//	private static String InsertQuery= 
//			"""
//			insert into course (id, name, author)
//             values(1, 'first query', 'vinay1');
//			
//			""";
//	
	private static String InsertQuery= 
			"""
			insert into course (id, name, author)
             values(?, ?, ?);
			
			""";
	
	private static String deleteQuery= 
			"""
			delete from course  
              where id= ?;
			
			""";
	private static String selectQuery= 
			"""
			select * from course  
              where id= ?;
			
			""";
	
//	public void insert(Course course) {
//		springJdbc.update(InsertQuery);
//	}
	public void insert(Course course) {
		springJdbc.update(InsertQuery, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void delete(int id) {
		springJdbc.update(deleteQuery, id);
	}
	
	public Course select(int id) {
		return springJdbc.queryForObject(selectQuery,new BeanPropertyRowMapper<>(Course.class), id);
	}// we want to select row and return so BeanPropertyRowMapper mapps column contents to Course class varaibles and returns
}
