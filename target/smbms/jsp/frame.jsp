<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="/jsp/common/head.jsp"%>
<div class="right">

    <div class="card">
        <div class="card-header">
            usage
        </div>
        <div class="card-body">
            <p>Thank you for using this system</p>
            <p>
                <ul class="card-body-ul">
                    <li>
                        if you want to query user message please click
                        <a href="${pageContext.request.contextPath }/jsp/user.do?method=query">THIS</a>
                        or the item in the function bar on the left
                    </li>
                    <li>
                        if you want to modify your passward please click
                        <a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">THIS</a>
                        or the item in the function bar on the left
                    </li>

                </ul>
            </p>

        </div>
    </div>

    <div class="card">
        <div class="card-header">
            reference resources
        </div>
        <div class="card-body">
            <p>Resources referenced in a project</p>
            <p>
            <ul class="card-body-ul">
                <li>
                    UI color reference :<a href="https://pintia.cn/problem-sets?tab=1&filter=active" target="_blank">PTA</a>
                </li>
                <li>
                    UI frame : <a href="https://www.layui.com/" target="_blank">layui</a>
                </li>
                <li>
                    Project reference : <a href="https://www.kuangstudy.com" target="_blank">KuangStudy</a>
                </li>
            <li>
                icon use : <a href="https://www.iconfont.cn/" target="_blank">iconfont</a>
            </li>

            </ul>
            </p>

        </div>

    </div>

    <%--    <img class="wColck" src="${pageContext.request.contextPath }/images/clock.jpg" alt=""/>--%>
<%--    <div class="wFont">--%>
<%--        <h2>${userSession.userName }</h2>--%>
<%--        <p>WELCOME!</p>--%>
<%--    </div>--%>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
