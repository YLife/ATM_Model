<%@page import="bizImpl.BankBizImpl"%>
<%@page import="biz.BankBiz"%>
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
    
    <title>执行取款操作</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style>
		.special{
			font-size: 18px;
			font-weight: bold;
			padding: 150px 140px;
		}
	</style>
  </head>
  
  <body>
  	<div class="container special">
    <%
    	String cardId = (String) session.getAttribute("cardId");
    	double money = Double.parseDouble(request.getParameter("outMoney"));
    	BankBiz biz = new BankBizImpl();
    	String result = biz.withDraw(cardId, money);
    	if(result.equals(BankBiz.S)){
    		out.print(BankBiz.S);
    	}else{
    		out.print(BankBiz.E);
    	}
    %>
    <a href="main.jsp" class="btn btn-default">返回</a>
  	</div>
  </body>
</html>
