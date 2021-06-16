<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head style="text-align:center;">

    <meta charset="UTF-8">
    <title>系统登录 - 用户管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<%--<link rel="stylesheet" href="css/style.css">--%>
    <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">


    <style type="text/css">
        .container{
            width: 420px;
            height: 320px;
            min-height: 320px;
            max-height: 320px;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            padding: 20px;
            z-index: 130;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
            font-size: 16px;
        }
        .close{
            background-color: white;
            border: none;
            font-size: 18px;
            margin-left: 410px;
            margin-top: -10px;
        }

        .layui-input{
            border-radius: 5px;
            width: 300px;
            height: 40px;
            font-size: 15px;
        }
        .layui-form-item{
            margin-left: -20px;
            margin-top: 25px;
        }
        #logoid{
            margin-top: -16px;
            padding-left:150px;
            padding-bottom: 15px;
        }
        .layui-btn{
            margin-left: -50px;
            border-radius: 5px;
            width: 350px;
            height: 40px;
            font-size: 15px;
        }
        .verity{
            width: 120px;
        }
        .font-set{
            font-size: 13px;
            text-decoration: none;
            margin-left: 120px;
        }
        a:hover{
            text-decoration: underline;
        }

    </style>
</head>
<body>
<form class="layui-form"  name="actionForm" action="${pageContext.request.contextPath }/login.do" method="get">
    <div class="container">
        <button class="close" title="关闭">X</button>
        <div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="images\zzz.jpg" height="35">
        </div>
        <br style="clear: both;">
        <div class="info">${error}</div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="userCode">用户名</label>
            <div class="layui-input-block">
                <input type="text" id="userCode" name = "userCode" required  placeholder="请输入用户名"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="userPassword">密 &nbsp;&nbsp;码</label>
            <div class="layui-input-inline">
                <input type="password"  id="userPassword" name = "userPassword" required  placeholder="请输入密码"  class="layui-input">
            </div>
            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
        </div>
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">验证码</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" name="title" required  lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input verity">--%>
<%--            </div>--%>
<%--            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->--%>

<%--        </div>--%>
        <!-- 			  <div class="layui-form-item">
                            <label class="layui-form-label">记住密码</label>
                            <div class="layui-input-block">
                              <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                            </div>
                      </div> -->

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a href="javascript:actionForm.submit();"><button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button></a>

            </div>
        </div>
<%--        <a href="" class="font-set">忘记密码?</a>  <a href="" class="font-set">立即注册</a>--%>
    </div>
</form>


<input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>" />
</body>
</html>
