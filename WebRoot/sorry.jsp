<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.base.model.UseValue"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <!-- Declare page as iDevice WebApp friendly -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/picturestyle.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<title><%=UseValue.name%></title>
	<link href="<%=request.getContextPath()%>/css/sorry.css" type="text/css" rel="stylesheet" />
</head>
	<body>
		<div class="main">
			<div class="c1">
				 <img src="<%=request.
				 getContextPath()%>/images/01.png" class="img1" />
			</div>
	  		<h2>哎呀…不是我干的</h2>	
	  		<h2>亲！记得到店里摇啊</h2>
	  		<!-- 定位 -->
			<div class="one_4">
			   <div onclick="getLocation()">
			   	<!-- 位置 -->
			      <div style="float:left;margin-left:10px;margin-top:5px;width:65%;">
			   	   <b style="font-size:20px;">${requestScope.storesInfo.name}&nbsp;<img src="<%=request.getContextPath()%>/img/ditu.png" alt=""width="15px"height="25px"></b>
			   	   <p style="color:#8e8e8e">${requestScope.storesInfo.address}</p>
			      </div>
			   </div>
			   <div style="position:absolute;border:1px white solid;margin:8px 30% 5px 70%;height:70px;">
			   	
			   </div>
			   <div style="float:right;margin-right:15px;margin-top:10px;">
			   	<a href="tel:${requestScope.storesInfo.phone}">
			   		<img src="<%=request.getContextPath()%>/img/phonehook.png"width="60px"height="60px">
			   	</a>
			   </div>
			</div>	
		</div>
	<script type="text/javascript">
	$(function(){
		var url = "${pageContext.request.contextPath}/wechatSignConfig.action";
		var cuUrl=location.href.split('#')[0];
		$.ajax({
			type : 'get',
			url : url,
			dataType : 'json',
			async : false,
			data:{currentUrl:""+cuUrl+""},
			success : function(data) {
				 wx.config({
					    debug: false,
					    appId: ""+'<%=UseValue.CustAppId%>'+"",
					    timestamp: ""+data[0].timestamp+"",
					    nonceStr: ""+data[0].nonceStr+"",
					    signature: ""+data[0].signature+"",
					    jsApiList: [
							"openLocation"
					    ]
				  });
			},
			failure: function(data) {
			}
		});
	});	
	function getLocation(){
   		var latitude = parseFloat("${requestScope.storesInfo.latitude}");
   		var longitude = parseFloat("${requestScope.storesInfo.longitude}");
   		wx.openLocation({
   		    latitude: latitude, // 纬度，浮点数，范围为90 ~ -90
   		    longitude: longitude, // 经度，浮点数，范围为180 ~ -180。
   		    name: "${requestScope.storesInfo.name}", // 位置名
   		    address: "${requestScope.storesInfo.address}", // 地址详情说明
   		    scale: 128, // 地图缩放级别,整形值,范围从1~28。默认为最大
   		    infoUrl: '', // 在查看位置界面底部显示的超链接,可点击跳转
   		});
   	}
	</script>
	</body>
</html>