<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.base.model.UseValue"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
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
	<link href="css/attention.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body style="background:#f0eff5;">
	<div class="all">
	   <div class="add"></div>
	   <div class="main">
	   	 <img id="log" src="${requestScope.loginMaster.logoUrl}" alt="logo"data-ratio="1" data-w="344">
	   </div>
	   <center><h4 style="line-height:40px;">长按图片识别二维码 关注我们！</h4></center>
	   <div style="width:100%;height:16px;background:white;"></div>
	   <div class="container">
			<div class="content">
			<h1 style="margin-top:10px;">你造吗？</h1>
	   	   <h4 style="color:white;">关注后,返回重新打开即可摇取优惠！</h4>
			</div>
			<s id="san"><i></i></s>
		</div>
	</div>
   <div class="foot">
   <h5 style="font-weight:normal;"><a href="http://<%=UseValue.Url%>" style="text-decoration:none;color:#666666;">技术支持&nbsp;比文科技</a>
   </h5>
  </div>
  <script>
	$(document).ready(function(){
		    var a = $(window).width();
		    var b = $(window).height();
			var h = $(".main").height();
			var w = $(".main").width();
			var k = $(".container").width();
			//alert(k);
			var p=(a-w)/2;
			var q=b*0.15;
			var v=b*0.2;
			$("#san").css("margin-left",k*0.5);
			$(".main").css("margin-left",p);
			$(".add").css("height",q*0.7);
			$(".container").css("top",p+q+120);
			$(".container").css("height",b*0.15);
			$(".main").css("height",w);
			$("#log").css("height",w);
			$("#log").css("width",w);
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