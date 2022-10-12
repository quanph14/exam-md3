package DAO;

import connection.ConnectionDB;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO implements IStudentDAO {
    private static final String INSERT_STUDENT_SQL = "insert into student(id, name, dob, address, phonenumber, email, classroom) values (?,?,?,?,?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id = ?";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String SELECT_BY_STUDENT_NAME = "select * from student where name like ?";
    private static final String DELETE_STUDENT_SQL ="delete from student where id = ?";
    private static final String UPDATE_STUDENT_SQL = "update student set id =?, name = ?, dob = ?, address = ?, phonenumber = ?, email = ?, classroom = ? where id = ?";
    public StudentDAO() {
    }
    @Override
    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENT_SQL);
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setDate(3, student.getDoB());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setString(7, student.getClassRoom());
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Student selectStudent(int searchById) {
        Student student = null;
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1,searchById);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date doB = rs.getDate("dob");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String classRoom = rs.getString("classroom");

                student = new Student(id,name,doB,address,phoneNumber,email,classRoom);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }
    public List<Student> searchByStudentName(String inputName) {
        List<Student> students = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_BY_STUDENT_NAME);
            ps.setString(1, "%"+ inputName + "%");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date doB = rs.getDate("dob");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String classRoom = rs.getString("classroom");

                students.add(new Student(id, name, doB, address, phoneNumber, email, classRoom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setDate(3, student.getDoB());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setString(7, student.getClassRoom());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date doB = rs.getDate("dob");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String classRoom = rs.getString("classroom");
                students.add(new Student(id, name, doB, address, phoneNumber, email, classRoom));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
