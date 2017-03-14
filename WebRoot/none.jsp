<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
a:hover{text-decoration:none;}
.foot{
	position: absolute;
	width: 100%;
	clear: both;
	height: 12px;
	margin-top: 20px;
	bottom: 0;
	line-height: 0;
	text-align: center;
}
</style>
</head>
<body  class="img-responsive" style="background-image:url(img/bg_yellow.png);background-size:cover;">
<!-- 主题内容 -->
	<div>
		<div style="margin:30% 0 10% 27%">
		<img src="<%=request.getContextPath()%>/img/clock.png" width="150" height="" alt="" />
		</div>
		<div style="margin:0 0 20% 0;text-align:center;">
			<label> <font size="5" color="#660033"><s:property value="#request.info" /></font></label><br/>
			<label> <font size="4" color="#993333"><s:property value="#request.timeString" />:<s:date name="#request.time" format="yyyy-MM-dd HH:mm:ss" nice="false" /></font></label>
			<div id="" class="" style="margin:20px 10px 0 10px;">
				<a href="<%=request.getContextPath()%>/getUserInfo.action"><button class="btn btn-success btn-lg btn-block" >返回首页</button></a>
			</div>
		</div>
	</div>
	<div class="foot">
		   <font style="font-weight:normal;color:rgba(179,102,0,0.7);"><a href="http://<%=UseValue.Url%>">技术支持&nbsp;比文科技</a>
		   </font>
		</div>
<!-- 主题内容结束 -->
</body>
</html>