package cn.ze.servlet.user;

import cn.ze.entity.User;
import cn.ze.service.user.UserService;
import cn.ze.service.user.UserServiceImpl;
import cn.ze.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    //Servlet 控制层调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        System.out.println(userCode);
        System.out.println(userPassword);
        //和数据库数据对比
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if(user != null && userCode.equals(user.getUserCode()) && userPassword.equals(user.getUserPassword()) ){
            //将用户的信息放到session 中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            //跳回登录页面 顺便提示用户名或者密码错误
            req.setAttribute("error","用户名或者密码错误");
            req.getRequestDispatcher("login1.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
