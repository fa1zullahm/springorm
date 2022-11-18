package com.spring.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {

	@Autowired
	//IOC Container Inject HibernateTemplate into StudentDao
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//save student
	@Transactional
	public int insert(Student student) {
		
		int i = (Integer)hibernateTemplate.save(student);
		return 1;
	}
	
	//get a single data(Objec)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	//get  all students
	public List<Student> getAllStudents() {
		
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	//deleting the data
	@Transactional
	public void delete(int studentId) {
		
		Student student = hibernateTemplate.get(Student.class, studentId);			
		hibernateTemplate.delete(student);
	}
	
	//updating an existing student
	@Transactional
	public void update(Student student) {
		hibernateTemplate.update(student);
	}

}
