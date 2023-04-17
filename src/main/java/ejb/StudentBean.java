package ejb;

import dao.StudentDAO;
import entity.Student;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

import java.sql.SQLException;
import java.util.ArrayList;

@Local (IStudent.class)
@Stateless (name = "StudentBean", mappedName = "ejb/StudentBean.java")
public class StudentBean implements IStudent {

    private StudentDAO studentDAO = StudentDAO.getInstance();

    @Override
    public ArrayList<Student> getStudentList() throws SQLException {
        return studentDAO.getStudentList();
    }
    @Override
    public void addStudent(String id, String name, String semester, double cgpa) {
        studentDAO.addStudent(id, name, semester, cgpa);
    }

    @Override
    public String getStudentName(String id) throws SQLException {
        return studentDAO.getStudentName(id);
    }

    @Override
    public Student getHigherCGPAStudentInfo(String id1, String id2) throws SQLException {
        return studentDAO.getHigherCGPAStudentInfo(id1, id2);
    }

    @Override
    public void updateStudentName(String id, String name) throws SQLException {
        studentDAO.updateStudentName(id, name);
    }
}
