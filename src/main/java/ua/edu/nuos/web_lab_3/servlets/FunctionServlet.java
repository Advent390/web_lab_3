package ua.edu.nuos.web_lab_3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.edu.nuos.web_lab_3.model.FunctionCalculator;

import java.io.IOException;

@WebServlet(name = "FunctionServlet", value = "/function-servlet")
public class FunctionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        double a, start, end, h;
        try {
            a = Double.parseDouble(req.getParameter("a"));
            start = Double.parseDouble(req.getParameter("start"));
            end = Double.parseDouble(req.getParameter("end"));
            h = Double.parseDouble(req.getParameter("step"));
        } catch (NumberFormatException | NullPointerException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некоректні числові дані");
            return;
        }
        if (h <= 0 || end < start) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Крок має бути > 0, а кінець >= початку");
            return;
        }

        FunctionCalculator fc = new FunctionCalculator(a, start, end, h);

        req.setAttribute("fc", fc);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
