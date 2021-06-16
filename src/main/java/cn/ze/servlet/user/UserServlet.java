package cn.ze.servlet.user;

import cn.ze.entity.Role;
import cn.ze.entity.User;
import cn.ze.service.role.RoleService;
import cn.ze.service.role.RoleServiceImpl;
import cn.ze.service.user.UserService;
import cn.ze.service.user.UserServiceImpl;
import cn.ze.util.Constants;
import cn.ze.util.PageSupport;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//实现servlet服用
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("savepwd") && method != null){
            this.updatePwd(req, resp);
        }else if(method.equals("pwdmodify") && method != null){
            this.pwdmodify(req, resp);
        }else if(method.equals("query") && method != null){
            this.query(req,resp);
        }else if(method != null && method.equals("deluser")){
            this.delUser(req, resp);
        }else if(method != null && method.equals("view")){
            //通过ID查找指定用户 并且返回信息给查询界面
            this.getUserById(req,resp,"userview.jsp");
        }else if(method != null && method.equals("modify")){
            this.getUserById(req, resp,"usermodify.jsp");
        }else if (method != null && method.equals("add")){
            this.add(req, resp);
        }else if (method != null && method.equals("modifyexe")){
            this.modify(req, resp);
        }else if (method != null && method.equals("getrolelist")){
            this.getRoleList(req, resp);
        }
    }

    private void getRoleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        //把roleList转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(roleList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add()================");
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());

        UserService userService = new UserServiceImpl();
        if(userService.add(user)){
            try {
                response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                request.getRequestDispatcher("useradd.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void modify(HttpServletRequest req, HttpServletResponse resp) {

        String id = req.getParameter("uid");
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        if (!StringUtils.isNullOrEmpty(gender)) user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        UserService userService = new UserServiceImpl();
        if(userService.modify(user)){
            try {
                resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                req.getRequestDispatcher("usermodify.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getUserById(HttpServletRequest req, HttpServletResponse resp, String url) {
        String id = req.getParameter("uid");
        if(!StringUtils.isNullOrEmpty(id)){
            //调用后台方法得到user对象
            UserService userService = new UserServiceImpl();
            User user = userService.getUserById(id);
            req.setAttribute("user", user);
            try {
                req.getRequestDispatcher(url).forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void delUser(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("uid");
        Integer delId = 0;
        try{
            delId = Integer.parseInt(id);
        }catch (Exception e) {
            // TODO: handle exception
            delId = 0;
        }
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(delId <= 0){
            resultMap.put("delResult", "notexist");
        }else{
            UserService userService = new UserServiceImpl();
            if(userService.deleteUserById(delId)){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        }

        //把resultMap转换成json对象输出
        resp.setContentType("application/json");
        PrintWriter outPrintWriter = null;
        try {
            outPrintWriter = resp.getWriter();
            outPrintWriter.write(JSONArray.toJSONString(resultMap));
            outPrintWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            outPrintWriter.close();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //有点问题
    public void query(HttpServletRequest req, HttpServletResponse resp){
        //数据
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");

        //获取用户列表 第一次进去第一页
        UserServiceImpl userService = new UserServiceImpl();
        //可以写Constants里面
        int pageSize = 15;
        int currentPageNo = 1;

        int queryUserRole = 0;
        if(queryUserName == null){
            queryUserName = "";
        }
        if(temp != null && !temp.equals("")){
            //默认 0  赋值
            queryUserRole = Integer.parseInt(temp);
        }
        if(pageIndex != null){
            //可能出现异常 ---> 重定向到error
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户总数(分页)
        int totalCount = userService.getUserCount(queryUserName,queryUserRole);
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();
        //控制首页和尾页
        //若页面小于1  显示第一页的东西..
        if(totalPageCount < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        //获取用户列表展示
        List<User> userList = userService.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
        /*
        for(User user:userList){
            System.out.println(user.getUserName());
        }*/
        //给前端
        req.setAttribute("userList",userList);
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        //从Session里面拿ID
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);

        String newpassword = req.getParameter("newpassword");
        boolean flag = false;
        if(o!=null && !StringUtils.isNullOrEmpty(newpassword)){
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) o).getId(), newpassword);
            if(flag){
                req.setAttribute("message","修改密码成功 请使用新密码登录");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else{
                req.setAttribute("message","密码修改失败");
            }
        }else {
            req.setAttribute("message","新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //验证旧密码 SESSION
    public void pwdmodify(HttpServletRequest req, HttpServletResponse resp){
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        HashMap<String,String> resultMap = new HashMap<>();
        if(o == null){
            //session 失效了
            resultMap.put("result","session error");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){
            resultMap.put("result","error");
        }else {
            //用户旧密码
            String userPassword = ((User) o).getUserPassword();
            if(oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            // JSONArray
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
