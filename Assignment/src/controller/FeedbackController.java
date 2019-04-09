package controller;

import entity.Feedback;
import model.FeedBackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FeedbackController extends HttpServlet {
    FeedBackModel feedBackModel = new FeedBackModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("feedback.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String des = req.getParameter("description");
       Feedback  feedback = new Feedback(email,des);
       if (!feedback.isValid()){
           HashMap<String, ArrayList<String>> errors = feedback.getErrors();
           req.setAttribute("feedback",feedback);
           req.setAttribute("errors",errors);
           req.getRequestDispatcher("feedback.jsp").forward(req,resp);
           return;
       }
       feedBackModel.insert(feedback);
       resp.sendRedirect("index.jsp");
    }
}
