package servlet;

import jakarta.json.JsonArray;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/student-list")
public class StudentListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String baseURI = "http://localhost:8080/WebArchAsssignment4-1.0-SNAPSHOT/api/student/student-list";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);

        JsonArray studentList = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Student List</h1>");
        out.println(studentList);
        out.println("</body></html>");
    }
}
