<%--
  Created by IntelliJ IDEA.
  User: Gaoyx1469
  Date: 2020/7/28
  Time: 21:49
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Request相关注解</title>
</head>
<body>
<a href="testRequestParam?abc=RequestParam绑定请求参数成功">RequestParam注解测试</a>
<hr/>
<form action="testRequestBody" method="post">
    姓名<input name="name" type="text">
    性别<input name="sex" type="text">
    <input type="submit" value="RequestBody注解测试">
</form>
<hr/>
<a href="testPathVariable/什么鬼">PathVariable注解测试</a>
<hr/>
<a href="testRequestHeader">RequestHeader注解测试</a>
<hr/>
<a href="testCookieValue">CookieValue注解测试</a>
<hr/>
<form action="testModelAttribute" method="post">
    ID<input name="intVal" type="number">
    <input type="submit" value="ModelAttribute注解测试">
</form>
<hr/>
<form action="testModelAttributeAnother" method="post">
    ID<input name="intVal" type="number">
    <input type="submit" value="ModelAttribute注解测试">
</form>
<hr/>
<a href="testSessionAttributes?sessionA=sessionA存入session成功">SessionAttributes注解测试</a>
<hr/>
<a href="testDeleteSessionAttributes">SessionAttributes注解测试删除session中的所有值</a>
</body>
</html>
