<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 <!--  enctype="multipart/form-data" -->
  <body>
    <form action="/liyujian/manage/findAllCompany.action" method="GET" onsubmit="return logincheck();">
			<!-- <div class="login_row">
			<input type="text" name="item_id" value=""> 
			</div> -->
			
			<!-- <div>
			<input type="text" name="image_name" value="6">
			</div>
			<div>
			<input type="text" name="image_state" value="6">
			</div>
			<div>
			<input type="file" name="file">
			</div> -->
		  
			<div>
			<input id="loginbut" type="submit" name="login_sub" value="登       录" tabindex="4">
			</div>
	</form>
  </body>
</html>
