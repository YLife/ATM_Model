<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="session.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>main.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<style>
	a{
		width: 150px;
	}
	.top{
		font-size: 18px;
		font-weight: bold;
		margin: 0px 18px 50px 18px;
	}
	.special{
		padding-top: 30px;
	}
</style>
</head>

<body>
	<div class="container special">
		<div class="top">
			<p>欢迎使用邮政储蓄银行ATM (<a href="www.psbc.com">www.psbc.com</a>)</p>
		</div>
		<p class="clearfix">
			<a href="deposit.jsp" class="pull-left btn btn-default">存款</a>
			<a href="getBalance.jsp" class="pull-right btn btn-default">查询余额</a>
		</p>
		<p class="clearfix">
			<a href="trans.jsp" class="pull-left btn btn-default">转账</a>
			<a href="withDraw.jsp" class="pull-right btn btn-default">取款</a>
		</p>
		<p class="clearfix">
			<a href="modify.jsp" class="pull-left btn btn-default">修改密码</a>
			<a href="exit.jsp" class="pull-right btn btn-default">退出</a>
		</p>
	</div>
</body>
</html>
