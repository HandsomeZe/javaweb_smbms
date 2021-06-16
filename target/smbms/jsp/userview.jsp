<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>location:</strong>
            <span> user view</span>
        </div>
        <div class="providerView">
            <p class="userViewp"><strong>用户编号：</strong><span>${user.userCode }</span></p>
            <p class="userViewp"><strong>用户名称：</strong><span>${user.userName }</span></p>
            <p class="userViewp"><strong>用户性别：</strong>
            	<span>
            		<c:if test="${user.gender == 1 }">男</c:if>
					<c:if test="${user.gender == 2 }">女</c:if>
				</span>
			</p>
            <p class="userViewp"><strong>出生日期：</strong><span>${user.birthday }</span></p>
            <p class="userViewp"><strong>用户电话：</strong><span>${user.phone }</span></p>
            <p class="userViewp"><strong>用户地址：</strong><span>${user.address }</span></p>
            <p class="userViewp"><strong>用户角色：</strong><span>${user.userRoleName}</span></p>
<%--			<div class="providerAddBtn">--%>
<%--            	<input class="layui-input-inline" type="button" id="back" name="back" value="返回" >--%>
<%--            </div>--%>
            <div class="providerAddBtn">
                <!--<a href="#">保存</a>-->
                <%--                        <input type="button" name="save" id="save" value="保存" class="layui-btn layui-btn-radius">--%>
                <button class="layui-btn layui-btn-radius pwdbutton" name="back" id="back" value="返回">返回</button>

            </div>



        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userview.js"></script>