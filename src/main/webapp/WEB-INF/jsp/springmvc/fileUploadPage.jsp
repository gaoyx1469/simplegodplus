<%--
  Created by IntelliJ IDEA.
  User: Gaoyx1469
  Date: 2020/7/30
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>文件上传页面</title>
</head>
<body>
<form action="oldWay" method="post" enctype="multipart/form-data">
    <h3>传统文件上传方式</h3>
    <input type="file" name="filename"/><!--注意！必须要有name属性！！！-->
    <input type="submit" value="上传"/>
</form>
<hr/>
<form action="newWay" method="post" enctype="multipart/form-data">
    <h3>SpringMVC文件上传方式</h3><input type="file" name="filename"/><!--注意！必须要有name属性！！！-->
    <input type="submit" value="上传"/>
</form>
</body>
</html>
