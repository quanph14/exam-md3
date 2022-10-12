package DAO;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
public void insertStudent(Student student) throws SQLException;
public Student selectStudent(int id);
public boolean deleteStudent(int id) throws SQLException;
public boolean updateStudent(Student student) throws SQLException;
public List<Student> selectAllStudent();
public List<Student> searchByStudentName(String inputName);
}
