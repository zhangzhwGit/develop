<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/view/common/include.jsp"/>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h3>this is home page</h3>
<shiro:hasRole name="role_admin">
    <h3>这里是admin角色</h3>
</shiro:hasRole>
<shiro:hasRole name="role_user">
    <h3>这里是user角色</h3>
</shiro:hasRole>
<shiro:hasPermission name="add">
    <h3>新增权限</h3>
</shiro:hasPermission>
<shiro:hasPermission name="query">
    <h3>查询权限</h3>
</shiro:hasPermission>

<a href="${APP_PATH}/service/getAll">admin service url</a>
<br>
<a href="${APP_PATH}/service/getAny">user service url</a>
<br>
<a href="${APP_PATH}/service/getService">none service url</a>
</body>
</html>
