<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="session.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'withDraw.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
  <body>
    <div class="container">
    	<form action="doWithDraw.jsp" method="post">
    		<div class="form-group">
    			<label>请输入取款金额：</label>
    			<input type="text" name="outMoney" class="form-control">
    		</div>
    		<div class="form-group">
    			<button class="btn btn-success pull-right">确定</button>
    		</div>
    	</form>
    </div>
  </body>
</html>
