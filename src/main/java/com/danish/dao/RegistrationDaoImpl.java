package com.danish.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.danish.model.Student;


@Repository
public class RegistrationDaoImpl implements RegistrationDaoService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Student> getAllStudents() {
		
		String sql = " Select * from Student";
		return jdbcTemplate.query(sql,
		        new BeanPropertyRowMapper<Student>(Student.class));
		
	}

	public int saveStudent(Student student) {
		
		

		return jdbcTemplate.update("insert into student(firstName,lastName,joiningDate) values (?,?,?)",
				student.getFirstName(), student.getLastName(),student.getJoiningDate());
	}

	public int deleteStudent(long id) {
		
		return jdbcTemplate.update("Delete from student where id=?",id);
		

	}

	public void updateStudent(Student student) {
		

	}

}
