<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.base.model.UseValue"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title><%=UseValue.name%></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 user-scalable=no">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<style type="text/css">
a:hover{text-decoration:none;}
</style>
</head>
<body  class="img-responsive" style="background-image:url(<%=request.getContextPath()%>/img/bg_yellow.png);background-size:cover;">
<!-- 主题内容 -->
	<div>
		<div style="margin:30% 20% 10% 30%">
			<img src="<%=request.getContextPath()%>/img/logo.png" width="150px" alt="" />
		</div>
		<div style="margin:0 20% 20% 20%;text-align:center;">
			<label> <font size="6" color="#660033">比文</font></label><br/>
			<label> <font size="4" color="#996600">欢迎到店体验</font></label>
			<label> <font size="4" color="#996600">到店还能摇优惠劵哦</font></label>
		</div>
	</div>
<!-- 主题内容结束 -->

</body>
</html>