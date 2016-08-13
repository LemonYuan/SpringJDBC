package com.hand.SpringJDBC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hand.SpringJDBC.entity.Student;
import com.hand.SpringJDBC.mapper.StudentMapper;

public class StudentDAO {
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplateObject;
  public void setDataSource(DataSource dataSource){
	  this.dataSource=dataSource;
	  this.jdbcTemplateObject=new JdbcTemplate(dataSource);
  }
  public void create(String name,Integer age){
	  String sql="insert into student(name,age) values(?,?)";
	  jdbcTemplateObject.update(sql,name,age);
	  System.out.println("student "+name+" created successfully");
  }
  public Student getStudent(Integer id){
	  String sql="select * from student where id=?";
	  Student student=jdbcTemplateObject.queryForObject(sql, new Object[]{id},new StudentMapper());
	  return student;
  }
  public List<Student> getStudents(){
	  String sql="select * from student";
	  List<Student> students=jdbcTemplateObject.query(sql, new StudentMapper());
	  return students;
  }
  public void delete (Integer id){
	  String sql="delete from student where id=?";
	  jdbcTemplateObject.update(sql,id);
	  System.out.println("student "+id+" deleted successfully");
  }
  public void updateAge(Integer id,Integer age){
	  String sql="update student set age=? where id=?";
	  jdbcTemplateObject.update(sql,age,id);
	  System.out.println("student "+id+" updated successfully");
  }
}
