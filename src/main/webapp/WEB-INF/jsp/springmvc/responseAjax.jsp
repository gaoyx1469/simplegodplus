<%--
  Created by IntelliJ IDEA.
  User: Gaoyx1469
  Date: 2020/7/29
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ajax测试response返回json数据</title>
    <script type="application/javascript" src="../js/jquery-1.12.0.min.js"></script>
    <script type="application/javascript">
        $(function () {
            $("#getData").click(function () {
                //alert("调试点击方法能否执行");
                $.ajax({
                    url: "ajaxOperation",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"intVal":666,"stringVal":"不错不错"}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        <!--看看数据有没有改掉-->
                        alert(data);
                        alert(data.intVal);
                        alert(data.stringVal);
                    }
                })
            });
        });
    </script>
</head>
<body>
<button id="getData">获取数据</button>
</body>
</html>
