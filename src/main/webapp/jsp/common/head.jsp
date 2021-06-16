<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head lang="en">
    <meta charset="UTF-8">
    <title>System</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="../../../../node_modules/layui/dist/css/layui.css">
    <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">

</head>
<section>
<!--头部-->
    <header class="publicHeader">
        <h1><a href="${pageContext.request.contextPath }/jsp/frame.jsp">System</a> </h1>
        <div class="publicHeaderR">
            <p><span>Hello!</span><span> ${userSession.userName }</span> </p>
            <a href="${pageContext.request.contextPath }/jsp/logout.do"><button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">退出</button></a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
    </section>
 <!--主体内容-->
 <section class="publicMian ">

     <div class="left">

    <ul class="layui-nav layui-nav-tree layui-nav-side">
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">System</a>
            <dl class="layui-nav-child">
                <dd><a href="${pageContext.request.contextPath }/jsp/user.do?method=query">用户查询</a></dd>
                <dd><a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">密码更改</a></dd>
            </dl>
        </li>
    </ul>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>" />