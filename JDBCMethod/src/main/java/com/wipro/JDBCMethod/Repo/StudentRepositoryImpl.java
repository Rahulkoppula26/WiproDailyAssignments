package com.wipro.JDBCMethod.Repo;

import java.util.List;

import com.wipro.JDBCMethod.Student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
 
 @Autowired
 JdbcTemplate jdbcTemplate;
 
 @Override
 public int addStudent(Student student) {
  String insertQuery = "insert into student values(?,?,?,?)";
  return jdbcTemplate.update(insertQuery,student.getId(),student.getName(),student.getContactNumber(), student.getAddress());
 }
 @Override
 public List<Student> getAllStudents() {
  String selectAllQuery = "select id, name, contact_number, address from student";
  List<Student> allStudentsList = jdbcTemplate.query(selectAllQuery, new BeanPropertyRowMapper<Student>(Student.class));
  return allStudentsList;
 }
 @Override
 public Student getStudentById(int id) {
  String selectByIdQuery = "select id, name, contact_number, address from student where id = ?";
  Student student = jdbcTemplate.queryForObject(selectByIdQuery, BeanPropertyRowMapper.newInstance(Student.class), id);
  return student;
 }
 @Override
 public int updateStudent(Student student) {
  String updateQuery = "update student set id = ?, name = ?, contact_number = ?, address = ? where id = ?";
  return jdbcTemplate.update(updateQuery,student.getId(),student.getName(),student.getContactNumber(), student.getAddress(),student.getId());
 }
 @Override
 public int deleteStudentById(int id) {
  String deleteByIdQuery = "delete from student where id = ?";
  return jdbcTemplate.update(deleteByIdQuery, id);
 }
}
