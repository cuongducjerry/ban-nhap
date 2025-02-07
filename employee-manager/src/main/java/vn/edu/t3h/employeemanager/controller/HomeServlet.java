package vn.edu.t3h.employeemanager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getMethod();
        String url = req.getRequestURI();
        String param = req.getParameter("name");
        Map<String,String[]> params = req.getParameterMap();
        HttpSession session = req.getSession();
        session.setAttribute("user","kiennd25");
        String sessionId = session.getId();


        // config kiểu dữ liiệu trả về trong response là html/text
        resp.setContentType("text/html");


        // ghi dữ liệu vào response
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> hello servlet </h1>");
        out.println("<h2> method:" + method + "</h2>");
        out.println("<h2> url:" + url + "</h2>");
        out.println("<h2> param:" + param + "</h2>");
        out.println("<h2> sessionId:" + sessionId + "</h2>");
        out.println("</body></html>");
    }
}
