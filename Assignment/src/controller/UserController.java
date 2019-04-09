package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        User user = new User(username,email,pass);
        if (!user.isValid()){
            HashMap<String, ArrayList<String>> errors = user.getErrors();
            req.setAttribute("user",user);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        UserModel userModel = new UserModel();
        userModel.insert(user);
        HttpSession session = req.getSession();
        session.setAttribute("email",user);
        resp.sendRedirect("index.jsp");

    }
}
