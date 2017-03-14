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
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1 user-scalable=no">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
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
label{
	font-family:Microsoft JhengHei;
}
</style>
</head>
<body  class="img-responsive" style="background-color:#efeff4;background-size:cover;">
<!-- 主题内容 -->
	<div>
		<div style="text-align:center; margin-top:25%;">
		<img src="<%=request.getContextPath()%>/img/clock.png" width="65%" height="" alt="" />
		</div>
		<div style="margin:0 0 20% 0;text-align:center;">
			<label> <font size="5" color="#333333">今日优惠券已领完</font></label><br/>
			<label> <font size="4" color="#666666">别摇啦，专心吃饭饭</font></label>
			<div style="margin:20px 10px 0 10px;">
				<a href="<%=request.getContextPath()%>/getUserInfo.action"><button style="background:#f60c3d;color:#ffffff;width:80%; margin:0 auto;" class="btn  btn-lg btn-block">返回首页</button></a>
			</div>
		</div>
		<!--诱导框开始-->
			<div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"aria-hidden="true"style="background-image:url(<%=request.getContextPath()%>/img/share1.png);background-size:100% 100%;fixed;">
         	<div class="modal-dialog">
                 <br/><br/>
                  <div class="form-group has-success"style="margin-top:50%;">
 <%--                    <span class="btn-primary btn-lg btn-block" style="color:#ffff99;font-size:18px;text-align:center;background-color:transparent;border:0;">每天摇完都可以给朋友摇哦</span> <br/>
                    <span  class=" btn-primary btn-lg btn-block"style="color:#ffff99;font-size:18px;text-align:center;background-color:transparent;border:0;">&nbsp;&nbsp;分享给朋友大家一起玩</span>  		 --%>			
                  </div>
				  <div class="form-group has-success" style="margin-top:95%;border:2px white solid;border-radius:5px;">
                    <button type="button" data-dismiss="modal" class="btn btn-primary btn-lg btn-block"style="background-color:transparent;border:0;" ><b style="color:#ffffff;"data-dismiss="modal">我知道了</b></button>         
                  </div>				  
          	</div> 
       	</div>  	
      	<!--诱导框结束-->
	</div>
<!-- 主题内容结束 -->
	<div class="foot">
	  	  <a href="http://<%=UseValue.Url%>"><font style="color:rgba(255,255,255,0.3);">技术支持&nbsp;比文科技</font></a>
	  	
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$('#myModal').modal({
		keyboard: true
	});
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
</html>