<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.base.model.UseValue"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bing.css">
    <script src="js/jquery.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body>
	<div class="head"id="hd">
		 <div class="logo">
		     <img src="${requestScope.userInfo.headimgurl}" alt="logo">
		  </div>
		  <center>
		  	<h3 style="color:white;">${requestScope.userInfo.nickname}欢迎光临</h3>
		  </center> 
	</div>
	<nav>
	   <a onclick="getZhu()">
		<div id="yao">
			<div class="card">
		     	<img src="<%=request.getContextPath()%>/img/yao.png" alt="logo">
		   </div>
		     <div class="font">
		        <b>进入摇一摇</b>
		        <h6>领取更多优惠</h6>
		     </div>
		</div>
		</a>
	<a href="<%=request.getContextPath()%>/guanzhu.action">
		<div id="tip1">
			 <h4>关注公众号</h4>
			<h5>获得更多资讯</h5>
		</div>
		</a>
	<a href="<%=request.getContextPath()%>/share.action">
		<div id="tip2">
			<h4>分享朋友圈</h4>
			<h5>立即获得超值福利</h5>
		</div>
	</a>
	<!--弹出窗口-->
	<div id="dialogBg2">
	    <div class="diob">
	         <h2>先关注<%=UseValue.name%>吧</h2>
	    	<div class="loo"></div>
	    </div>
	    <a href="<%=request.getContextPath()%>/guanzhu.action" style="text-decoration:none;color:white">
	    <div class="dioc">
	    	<h3 class="bb">关注公众号</h3>
			<h5>获得更多资讯</h5>
	    </div>
	    </a>
	</div>	
	<!--弹出窗口-end-->
	</nav>
<div class="foot">
   <h5 style="font-weight:normal;"><a href="http://<%=UseValue.Url%>" style="text-decoration:none;color:#666666;">技术支持&nbsp;比文科技</a>
   </h5>
</div>
	<script>
	$(document).ready(function(){
			var h = $(window).height();
			var w = $(window).width();
			var n=h*0.35;
			var l=h*0.25;
			var p=h*0.2;
			//alert(n);
			$("#hd").css("height",n);
			$("#yao").css("width",w*0.92);
			$("#yao").css("margin-left",w*0.04);
			$("#yao").css("margin-rigth",w*0.04);
			$("#tip1").css("width",(w*0.92)/2-5);
			$("#tip1").css("margin-left",w*0.04);
			$("#tip2").css("width",(w*0.92)/2-5);
			$("#tip2").css("margin-right",w*0.04);
			$("#yao").css("height",l);
			$(".diob").css("height",l);
			$(".diob").css("margin-top",n+20);
			$(".loo").css("margin-top",l-150);
			$(".loo").css("margin-left",w*0.1);
			$("#tip1").css("height",p+10);
			$("#tip2").css("height",p+10);
			$(".dioc").css("height",p+10);
			$(".dioc").css("width",(w*0.92)/2-5);
			var o=(l-80)/2;
			var d=w*0.1;
			$(".card").css("margin-top",o);
			$(".card").css("margin-left",d);
			$(".font").css("margin-top",o);
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
								"hideOptionMenu"/* ,"onMenuShareTimeline","onMenuShareAppMessage" */
						    ]
					  });
				},
				failure: function(data) {
					alert(data);
				}
			});
			
		}); 
	function getDia(){
		//显示弹框
		$('#dialogBg2').fadeIn(300);
	}
	(function(){
        var div=$(".dioc .bb");
        var borderFlag=false;
        var time;
        setTimeout(blinkBorder,2000);
        function blinkBorder()
        {
            time=0;
            for(var i=0;i<6;i++)
            {
                time+=100;
                setTimeout(function()
                {
                    modifyBorder();                
                },time);    
            }
            setTimeout(blinkBorder,2000);
        }
        function modifyBorder()
        {
            borderFlag=!borderFlag;
            if(borderFlag)
            {
                div.removeClass("bb1").addClass("bb2");    
            }
            else
            {
                div.removeClass("bb2").addClass("bb1");
            }
        }
})
function getZhu(){
	var url = "${pageContext.request.contextPath}/getAttion.action";
	$
		.ajax({
			type : 'get',
			url : url,
			dataType : 'json',
			success : function(data) {	
				if(data[0].result=="success"){
					window.location.href="${pageContext.request.contextPath}/loginYao.action";
				}else if(data[0].result=="fail"){
					getDia();
				}else{
					window.location.href="${pageContext.request.contextPath}/weixinOauth.action";
				}
			},
			failure : function(data) {
				alert(data);
			}
		});
}
	wx.ready(function(){
		wx.hideOptionMenu();
		<%-- wx.onMenuShareTimeline({
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
		}); --%>
	});
	</script>
</body>
</html>
