<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<title>错误提示</title> 
<body>
<h1>ss</h1>
     <%    // 重定向到新地址    

   String site = new String("http://localhost:8080/liyujian/login.html");  
   response.setStatus(response.SC_MOVED_TEMPORARILY);  
   response.setHeader("Location", site);  %>
</body>

</html>