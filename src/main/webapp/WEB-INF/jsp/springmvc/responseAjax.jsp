<%--
  Created by IntelliJ IDEA.
  User: 高宇翔
  Date: 2020/7/29
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ajax测试response返回json数据</title>
    <script src="../WEB-INF/js/jquery-1.12.0.min.js"/>
    <script>
        $(function () {
            $("#getData").click(function () {
                alert("getData");
            });
        });
    </script>
</head>
<body>
<button id="getData">获取数据</button>
</body>
</html>
