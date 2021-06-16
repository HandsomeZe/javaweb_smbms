<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>location:</strong>
                <span>query</span>
            </div>
            <div class="search">
           		<form method="get" action="${pageContext.request.contextPath }/jsp/user.do">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>姓名：</span>
					 <input name="queryname" class="input-text" placeholder="输入姓名限定范围"	type="text" value="${queryUserName }">
					 
					 <span>职位：</span>
					 <select name="queryUserRole">
						<c:if test="${roleList != null }">
						   <option value="0">-未选择-</option>
						   <c:forEach var="role" items="${roleList}">
						   		<option <c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
						   		value="${role.id}">${role.roleName}</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 
					 <input type="hidden" name="pageIndex" value="1"/>
<%--					 <input	value="查 询" type="submit" id="searchbutton">--%>
                    <button class="layui-btn layui-btn-radius layui-btn-normal">查询</button>


					<button class="layui-btn layui-btn-radius layui-btn-normal"><a href="${pageContext.request.contextPath}/jsp/useradd.jsp" >添加用户</a></button>

				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">账号</th>
                    <th width="20%">姓名</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">权限</th>
                    <th width="30%">操作</th>
                </tr>
                   <c:forEach var="user" items="${userList }" varStatus="status">
					<tr>
						<td>
						<span>${user.userCode }</span>
						</td>
						<td>
						<span>${user.userName }</span>
						</td>
						<td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
						</td>
						<td>
						<span>${user.age}</span>
						</td>
						<td>
						<span>${user.phone}</span>
						</td>
						<td>
							<span>${user.userRoleName}</span>
						</td>
						<td>
						<span><a class="viewUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>

            <a href="#" id="yes">
				<button class="layui-btn layui-btn-radius layui-btn-normal">确定</button>
			</a>
            <a href="#" id="no">
				<button class="layui-btn layui-btn-radius layui-btn-normal">取消</button>
			</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userlist.js"></script>
<script src="//unpkg.com/layui@2.6.8/dist/layui.js">