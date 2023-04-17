package dao;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;

public final class StudentDAO {

    private static volatile StudentDAO instance = null;
    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;
    public StudentDAO() {}
    String url = "jdbc:mariadb://localhost:3306/WebArch_Assignment4";
    String user = "Shojeb";
    String pwd = "password";

    public static StudentDAO getInstance() {
        if (instance == null) {
            synchronized (StudentDAO.class) {
                if (instance == null) {
                    instance = new StudentDAO();
                }
            }
        }

        return instance;
    }

    public ArrayList<Student> getStudentList() throws SQLException {
        String query = "select * from WebArch_Assignment4.Student;";
        databaseOperation(query);

        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student();

        if (resultSet.next()) {
            student.setID(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
            student.setSemester(resultSet.getString("semester"));
            student.setCGPA(resultSet.getFloat("cgpa"));

            studentList.add(student);
        }

        return studentList;
    }

    public void addStudent(String id, String name, String semester, double cgpa) {
        String queryValues = id + ", " + name + ", " + semester + ", " + cgpa;
        String query = "insert into WebArch_Assignment4.Student(id, name, semester, cgpa) values (" + queryValues + ");";
        databaseOperation(query);
    }

    public String getStudentName(String id) throws SQLException {
        String query = "select name from WebArch_Assignment4.Student where id = " + id + ";";
        databaseOperation(query);
        String name = "";

        if (resultSet.next()) {
            name = resultSet.getString("name");
        }

        return name;
    }

    public Student getHigherCGPAStudentInfo(String id1, String id2) throws SQLException {
        String query = "select id, name, cgpa from WebArch_Assignment4.Student where id in (" + id1 + ", " + id2 + ") order by cgpa desc limit 1;";
        databaseOperation(query);

        Student student = new Student();

        if (resultSet.next()) {
            student.setID(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
            student.setCGPA(resultSet.getFloat("cgpa"));
        }

        return student;
    }

    public void updateStudentName(String id, String name) throws SQLException {
        String query = "update WebArch_Assignment4.Student set name = " + name + " where id = " + id + ";";
        databaseOperation(query);
    }

    public Student getHighestCGPAInfo() throws SQLException {
        String query = "select id, name from WebArch_Assignment4.Student order by cgpa desc limit 1";
        databaseOperation(query);

        Student student = new Student();

        if (resultSet.next()) {
            student.setID(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
        }

        return student;

    }
    private void databaseOperation(String query) {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
