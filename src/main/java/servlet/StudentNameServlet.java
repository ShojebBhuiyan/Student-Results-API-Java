package servlet;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
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

@WebServlet("/name")
public class StudentNameServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String id = request.getParameter("id");

        String baseURI = "http://localhost:8080/WebArchAsssignment4-1.0-SNAPSHOT/api/student/name/" + id;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);

        JsonObject studentName = target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Student List</h1>");
        out.println(studentName);
        out.println("</body></html>");
    }
}
