package resource;

import ejb.SingletonStudentBean;
import ejb.StudentBean;
import entity.Student;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/student")
public class StudentResource {
    @EJB (beanName = "StudentBean")
    StudentBean studentBean;

    @EJB (beanName = "SingletonStudentBean")
    SingletonStudentBean singletonStudentBean;

    @GET
    @Path("/student-list")
    public ArrayList<Student> getStudentList() throws SQLException {
        return studentBean.getStudentList();
    }

    @GET
    @Path("/add-student")
    public void addStudent(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("semester") String semester, @QueryParam("cgpa") double cgpa) {
        studentBean.addStudent(id, name, semester, cgpa);
    }

    @GET
    @Path("/name/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(@PathParam("id") String id) throws SQLException {
        return studentBean.getStudentName(id);
    }
    @GET
    @Path("/compare/{id1}/{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getHigherCGPAInfo(@PathParam("id1") String id1, @PathParam("id2") String id2) throws SQLException {
        return studentBean.getHigherCGPAStudentInfo(id1, id2);
    }



    @GET
    @Path("/update-name")
    public void updateStudentName(@QueryParam("id") String id, @QueryParam("name") String name) throws SQLException {
        studentBean.updateStudentName(id, name);
    }

    @GET
    @Path("/get-highest")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getHighestCGPAInfo() throws SQLException {
        return singletonStudentBean.getHighestCGPAInfo();
    }
}
