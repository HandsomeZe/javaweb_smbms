<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
            <div class="location">
                <strong>location:</strong>
                <span>password revise</span>
            </div>
            <div class="providerAdd">


                <form class=layui-form" id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/jsp/user.do">
                    <div class="layui-input-block">
                    </div>
                    <input type="hidden" name="method" value="savepwd">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="info info1">${message}</div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="oldPassword">旧密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="oldpassword" name="oldpassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            <font color="red"></font>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="newPassword">新密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="newpassword" id="newpassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            <font color="red"></font>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="rNewPassword">确认新密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="rnewpassword" name="rnewpassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            <font color="red"></font>
                        </div>
                    </div>

<%--                    <div>--%>
<%--                        <label for="reNewPassword">确认新密码：</label>--%>
<%--                        <input type="password" name="rnewpassword" id="rnewpassword" value=""> --%>
<%--						<font color="red"></font>--%>
<%--                    </div>--%>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
<%--                        <input type="button" name="save" id="save" value="保存" class="layui-btn layui-btn-radius">--%>
                        <button class="layui-btn layui-btn-radius pwdbutton" name="save" id="save" value="保存">保存</button>

                    </div>
                </form>
            </div>
        </div>
    </section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/pwdmodify.js"  charset="UTF-8"></script>