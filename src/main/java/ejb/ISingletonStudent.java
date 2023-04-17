package ejb;

import entity.Student;

import java.sql.SQLException;

public interface ISingletonStudent {
    Student getHighestCGPAInfo() throws SQLException;
}
