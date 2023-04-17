package ejb;

import entity.Student;
import jakarta.ejb.Local;

import java.sql.SQLException;
import java.util.ArrayList;

@Local
public interface IStudent {
    ArrayList<Student> getStudentList() throws SQLException;
    void addStudent(String id, String name, String semester, double cgpa);
    String getStudentName(String id) throws SQLException;
    Student getHigherCGPAStudentInfo(String id1, String id2) throws SQLException;
    void updateStudentName(String id, String name) throws SQLException;
}
