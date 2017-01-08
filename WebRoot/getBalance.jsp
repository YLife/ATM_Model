<%@page import="bizImpl.BankBizImpl"%>
<%@page import="biz.BankBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="session.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询余额</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style >
		.balance{
			font-size: 18px;
			font-weight: bold;
			padding: 60px 0px 70px 70px;
		}
	</style>
  </head>
  
  <body>
    <%
    	String cardId = (String) session.getAttribute("cardId"); 
    	BankBiz biz = new BankBizImpl();
    	double balance = biz.getBalance(cardId);
    %>
    <div class="container">
    	<p class="balance">
    		您的当前余额为：<%=balance %>
    		<a href="main.jsp" class="btn btn-default">返回</a>
    	</p>
    </div>
  </body>
</html>
