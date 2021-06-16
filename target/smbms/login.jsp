<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
    <script type="text/javascript">
	/* if(top.location!=self.location){
	      top.location=self.location;
	 } */
    </script>

    <!-- <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${error}</div>
            <div class="inputbox">
                <label for="userCode">用户名：</label>
                <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label for="userPassword">密码：</label>
                <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">

                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>
        </form>
    </section> -->
</head>
<body>
<div class="login_main">
    <div class="fulldiv">

    </div>
    <div class="login_sub">
        <section class="loginCont">
            <form class="loginForm" action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
                <div class="info">${error}</div>
                <div class="inputbox">
                    <label for="userCode">用户名：</label>
                    <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="userPassword">密码：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">

<%--                    <input type="submit" value="登录"/>--%>
                    <a href="javascript:actionForm.submit();"><buttom class="layui-btn layui-btn-radius layui-btn-primary">登录</buttom></a>
                    <a href="#"><buttom class="layui-btn layui-btn-radius layui-btn-primary">注册</buttom></a>
                </div>
            </form>
        </section>
    </div>

</div>

<input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>" />
</body>
</html>
