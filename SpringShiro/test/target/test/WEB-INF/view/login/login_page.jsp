<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/view/common/include.jsp"/>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submitBtn").click(function () {
                var param = {
                    "username": $("#username").val(),
                    "password": $("#password").val()
                };
                $.ajax({
                    url: "${APP_PATH}/login",
                    data: param,
                    type: "POST",
                    dataType: "json",
                    async: false,
                    success: function (result) {
                        if (result.code === 200){
                            window.location.href="${APP_PATH}/home";
                        }else {
                            alert(result.msg);
                        }
                    },
                    error: function () {
                        <%--alert("${loginMsg}");--%>
                    }
                });
            });
        })
        ;
    </script>
</head>
<body>
<form>
    <h3>登录页面</h3>
    <label>账号：</label>
    <input type="text" id="username" name="username">
    <label>密码：</label>
    <input type="password" id="password" name="password">
    <input id="submitBtn" type="button" class="btn btn-primary" value="登录">
    <%--    <button id="submitBtn" class="btn btn-primary">登录</button>--%>
</form>

<strong>${loginMsg}</strong>

</body>
</html>
