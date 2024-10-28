package sessions_management;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet1")
public class Request1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "Jay";
        String userid = "1234";
        Cookie cookie1 = new Cookie("username", username);
        Cookie cookie2 = new Cookie("userid", userid);
        cookie1.setMaxAge(10*60);
        resp.addCookie(cookie1);
        cookie2.setMaxAge(5*60);
        resp.addCookie(cookie2);

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Cookie set successfully</h2>");
    }
}
