package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="student_details")
public class Student {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="student_id")		
	    private int studentId;
		
		@Column(name="student_name")		
		private String studentName;
		
		@Column(name="student_city")
		private String studentCity;			
		
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Student(int studentId, String studentName, String studentCity) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentCity = studentCity;
		}
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getStudentCity() {
			return studentCity;
		}
		public void setStudentCity(String studentCity) {
			this.studentCity = studentCity;
		}		

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity
					+ "]";
		}

		
}
