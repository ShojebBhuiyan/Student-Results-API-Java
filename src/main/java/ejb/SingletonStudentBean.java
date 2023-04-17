package ejb;

import dao.StudentDAO;
import entity.Student;
import jakarta.ejb.Local;
import jakarta.ejb.Singleton;

import java.sql.SQLException;

@Local (ISingletonStudent.class)
@Singleton (name = "SingletonStudentBean", mappedName = "ejb/SingletonStudentBean.java")
public class SingletonStudentBean implements ISingletonStudent{

    private StudentDAO studentDAO = StudentDAO.getInstance();

    @Override
    public Student getHighestCGPAInfo() throws SQLException {
        return studentDAO.getHighestCGPAInfo();
    }
}
