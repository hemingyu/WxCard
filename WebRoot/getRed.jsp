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
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<script src="js/jquery-1.7.min.js"></script>
		<link rel="stylesheet" href="css/money.css">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="js/bootstrap.min.js"></script>
		<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
		<style type="text/css">
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
		.bottom{
			text-align: bottom;
			position: absolute;
			top: 85%;
			width: 100%;
			heigh:10px;
			left: 0px;
		}
		</style>
	 <script>
	 $ (function(){
			var state='${param.state}';
			var h = $(window).height();
			var w = $(window).width();
			$(".container").css("min-height",h);
			$(".container").css("min-width",w);
			if (state=='1'){
				var url = "${pageContext.request.contextPath}/redPack.action";
				$
					.ajax({
						type : 'get',
						url : url,
						dataType : 'json',
						success : function(data) {	
							/* if(data[0].result=="sorry"){
								window.location.href="${pageContext.request.contextPath}/sorry.jsp";
							} */
						},
						failure : function(data) {
							alert(data);
						}
					});
			}else{
				var url = "${pageContext.request.contextPath}/redPackCompany.action";
				$
					.ajax({
						type : 'get',
						url : url,
						dataType : 'json',
						success : function(data) {	
							/* if(data[0].result=="sorry"){
								window.location.href="${pageContext.request.contextPath}/sorry.jsp";
							} */
						},
						failure : function(data) {
							alert(data);
						}
					});
			}
	});
	</script>
	</head>
	<body>
		<div class="container">
			<div class="button">
				<p>成功领取红包，请留意微信信息！</p>
			</div>
			<div class="bottom" style="margin:20px 10px 0 10px;">
				<a href="<%=request.getContextPath()%>/getUserInfo.action"><button style="background:#f60c3d;color:#ffffff;width:80%; margin:0 auto;" class="btn  btn-lg btn-block">返回首页</button></a>
			</div>
		</div>
		<div class="foot">
	  	  <a href="http://www.bewin-yao.com"><font style="color:rgba(255,255,255,0.3);">技术支持&nbsp;比文科技</font></a>
	  	
		</div>
	</body>
	<script>
		$(document).ready(function(){
			var h = $(window).height();
			var w = $(window).width();
			$(".container").css("min-height",h);
			$(".container").css("min-width",w);
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
</html>
