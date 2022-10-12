package Controller;

import DAO.StudentDAO;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    public void init(){
        studentDAO = new StudentDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewStudent(request, response);
                    break;
                case "edit":
                    showEditStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        }catch(SQLException ex)
        {
            throw new ServletException(ex);
        }
    }
    private void showNewStudent(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> listStudent = studentDAO.selectAllStudent();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        insertStudent(request, response);
                        break;
                    case "edit":
                        updateStudent(request, response);
                        break;
                    case "searchByName" :
                        searchByStudentName(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date doB = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String classRoom = request.getParameter("classroom");
        Student newStudent = new Student(id, name, doB, address, phoneNumber, email, classRoom);
        studentDAO.insertStudent(newStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date doB = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String classRoom = request.getParameter("classroom");
        Student newStudent = new Student(id, name, doB, address, phoneNumber, email, classRoom);;
        studentDAO.updateStudent(newStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        List<Student> listStudent = studentDAO.selectAllStudent();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request, response);
    }
    private void searchByStudentName(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException {
        String name = request.getParameter("searchName");
        List<Student> students = studentDAO.searchByStudentName(name);
        request.setAttribute("listStudent", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/search.jsp");
        requestDispatcher.forward(request, response);
    }
    }
