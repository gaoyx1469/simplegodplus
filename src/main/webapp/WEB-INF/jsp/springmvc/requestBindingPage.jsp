<%--
  Created by IntelliJ IDEA.
  User: Gaoyx1469
  Date: 2020/7/22
  Time: 22:11
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>测试请求参数绑定</title>
</head>
<body>
<form method="post" action="paramsBinding/bindingMostTypes">
    测试数字类型<input name="intParam" type="number"/><br/>
    测试字符串类型<input name="stringParam" type="password"/><br/>
    测试金额类型<input name="bigDecimal" type="text"/><br/>
    <hr/>
    测试引用javabean数字类型<input name="beanParam.intVal" type="number"/><br/>
    测试引用javabean字符串类型<input name="beanParam.stringVal" type="text"/><br/>
    测试List数字类型<input name="listParam[0].intVal" type="number"/><br/>
    测试List字符串类型<input name="listParam[0].stringVal" type="text"/><br/>
    测试Map数字类型<input name="mapParam['myKey'].intVal" type="number"/><br/>
    测试Map字符串类型<input name="mapParam['myKey'].stringVal" type="text"/><br/>
    <input type="submit" value="提交">
</form>
<hr/>
<hr/>
<form method="post" action="paramsBinding/bindingSelfConvertType">
    姓名<input name="name" type="text"/><br/>
    id<input name="id" type="text"/><br/>
    日期<input name="birthday" type="text"/><br/>
    <input type="submit" value="提交">
</form>
<hr/>
<hr/>
<a href="paramsBinding/getServletAPI">获取Servlet原生API</a>
</body>
</html>
