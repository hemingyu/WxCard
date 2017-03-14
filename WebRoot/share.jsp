<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.base.model.UseValue"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<title><%=UseValue.name%></title>
	<link rel="stylesheet" href="css/share.css">
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script src="js/jquery.min.js"></script>
</head>
<body>
   <div class="main">
      <div class="all">
	   <div class="head">
	   	 <div class="share">
	   	 	<img src="<%=request.getContextPath()%>/img/sz.gif" alt="sz">
	   	 </div>
	   	 
	   </div>
	   <div class="content">
	   	     <div class="gift">
	   	     	<%-- <img src="<%=UseValue.headImg%>" alt="logo"> --%>
	   	     </div>
	   	     <center>
	   	     	<div style="margin-top:10%;"><font size="5"><b>送<%=UseValue.name%>大礼包</b></font></div>
	   	     	<font style="margin-top:10px;font-weight:normal;" size="3">让你的朋友也摇起来～</font>
	   	     </center>	
	   </div>
	  </div>
<div class="foot">
   <h5 style="font-weight:normal;"><a href="http://<%=UseValue.Url%>" style="text-decoration:none;color:#666666;">技术支持&nbsp;比文科技</a>
   </h5>
</div>
	<script>
	$(document).ready(function(){
		var b = $(window).height();
			var n=b*0.21;
			var m=b*0.53;
			$(".head").css("height",n);
			$(".content").css("height",m);
			var h = $(".content").height();
			var w = $(".content").width();
			var l=h/2;
			var p=(w-60)/2;
			$(".gift").css("margin-top",l);
			$(".gift").css("margin-left",p);
			
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
								"showOptionMenu","onMenuShareTimeline","onMenuShareAppMessage"
						    ]
					  });
				},
				failure: function(data) {
					alert(data);
				}
			}); 
		});
	wx.ready(function(){
		wx.showOptionMenu();
		wx.onMenuShareTimeline({
			title: '好礼抢不停，大家一起摇',
			link: "http://"+"<%=UseValue.Url%>"+"/Card/yaoyiyao?appid="+"<%=UseValue.AppId%>"+"&custAppid="+"<%=UseValue.CustAppId%>"+"&status="+"<%=UseValue.Status%>",
			imgUrl: "<%=UseValue.headImg%>",
			trigger: function (res) {
			 // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			},
			success: function (res) {
				var url = "${pageContext.request.contextPath}/saveShare.action";
				$.ajax({
					type : 'get',
					url : url,
					dataType : 'json',
					success : function(data) {
					},
					failure: function(data) {
						alert(data);
					}
				});
			},
			cancel: function (res) {
			},
			fail: function (res) {
				alert(JSON.stringify(res));
			}
		});
		wx.onMenuShareAppMessage({
		    title: '好礼抢不停，大家一起摇', // 分享标题
		   /*  desc: '', // 分享描述 */
		    link: "http://"+"<%=UseValue.Url%>"+"/Card/yaoyiyao?appid="+"<%=UseValue.AppId%>"+"&custAppid="+"<%=UseValue.CustAppId%>"+"&status="+"<%=UseValue.Status%>", 
		    imgUrl: '<%=UseValue.headImg%>',
		    type: 'link', // 分享类型,music、video或link，不填默认为link
		    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		    success: function () { 
		        // 用户确认分享后执行的回调函数
		    	var url = "${pageContext.request.contextPath}/saveShare.action";
				$.ajax({
					type : 'get',
					url : url,
					dataType : 'json',
					success : function(data) {
					},
					failure: function(data) {
						alert(data);
					}
				});
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
	});
	</script>
</body>
</html>