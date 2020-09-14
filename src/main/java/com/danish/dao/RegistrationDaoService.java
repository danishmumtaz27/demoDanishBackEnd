package com.danish.dao;
import java.util.List;

import com.danish.model.Student;

public interface RegistrationDaoService {

	public List<Student> getAllStudents();
	public int saveStudent(Student student);
	public int deleteStudent(long id);
	public void updateStudent(Student student);
}
