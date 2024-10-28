package database_connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String message = req.getParameter("message");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("Feedback servlet working");

        writer.println("<h2> Your form details that you submitted: </h2>" +
                "<h3>Email address: </h3>"+email
                + "<h3>Phone number: </h3>"+phone
                + "<h3>Message: </h3>"+message
        );

        try{
            Connection con = connectionProvider.getConnection();

            String q = "insert into feedback_entry(EmailId, Phone, Message) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, message);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
