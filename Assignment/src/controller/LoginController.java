package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    UserModel userModel = new UserModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if ( httpSession.getAttribute("LoggedUser") == null ){
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        User user = checkLogin(email,pass);

        if (user !=null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("LoggedUser",user);
            if (user.getRole() == "2"){
                resp.sendRedirect("das.jsp");
            }else {
                resp.sendRedirect("/index.jsp");
            }
        }else {
            req.setAttribute("errorLogin","Không thể tìm thấy thông tin tài khoản của bạn \n Ban vui lòng đăng nhập lại !!!");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
    private User checkLogin(String email, String password){
        User user = userModel.getByEmailAndPassword(email,password);
        if (user !=null){
            return user;
        }
        return null;
    }
}
