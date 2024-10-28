package sessions_management;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet2")
public class Request2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        boolean flag = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("username")) {
                    writer.println("<h2>welcome: </h2>" +cookie.getValue());
                    flag = true;
                }
                if (name.equals("userid")) {
                    writer.println("<h2>userid: </h2>" +cookie.getValue());
                    flag = true;
                }
            }
        }
        if (!flag) {
            writer.println("<h2>no username found in cookies</h2>");
            writer.println("<h2>username cookie is not there in request</h2>");
        }
    }
}
