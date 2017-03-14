<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.base.model.UseValue"%>
<%	
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String openId=(String)request.getSession().getAttribute("openId");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<title><%=UseValue.name%></title>
		<link href="<%=request.getContextPath()%>/css/index.css" type="text/css" rel="stylesheet" />
		<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
 		<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	</head>
 	<style type="text/css">
		a:hover{text-decoration:none;}
		.foot{
			position: absolute;
			width: 100%;
			clear: both;
			height: 10px;
			margin-top: 20px;
			bottom: 0;
			line-height: 0;
			text-align: center;
        }
	</style>
	<script  type="text/javascript">
		$('#addFormbox').modal().css({
		 			 width: 'auto',
		  		'margin-left': function () {
		    		 return -($(this).width() / 2);
		      }
		});
	</script> 
	<body>
		<div class="back">
		    <div id="logo" class="back1" style="background: url(<%=UseValue.headImg%>) no-repeat center center;background-size: 120px 120px;">
		    </div>
		    <img id="one" src="<%=request.getContextPath()%>/img/first.png" />
			<img id="two" src="<%=request.getContextPath()%>/img/secound2.png" />
			<div id="three" style="position:relative; margin:-46% 0 22% 0%;">
				<font size="5" color="#ffffff"><strong id="title">摇一摇,摇出优惠券</strong></font><br/><br/>
				<div style="background:rgba(56,54,54,0.3);border-radius:15px;width:60%; height:35px;line-height:35px; margin:0 auto;"><font id="num-text" size="4" style="color:rgba(255,255,255,0.9);">今天还有 <span id="num">${userinfo.sharkNo}</span> 次机会</font></div>
			</div>
			<audio style="display:hide" id="musicBox1" preload="auto" src="<%=request.getContextPath()%>/video/yaoyiyao.mp3">
			</audio>
			<audio style="display:hide" id="musicBox2" preload="auto" src="<%=request.getContextPath()%>/video/result.mp3"> 
			</audio>
			<div id="dialogBg"></div>
			<div id="result" class="result">
				<h2><font style="color:#ffffff;"></font></h2>
				<p><font style="color:#ffffff;" size="4"></font></p>
			</div>
			<div id="button" class="button">
				<a>确定</a>
			</div>
			<!-- 红包开始 -->
			<div id="dialogBgRed"></div>
			<div id="Redresult" class="money" onclick="receiveRedPack()">
			    <div class="logo2">
			    <img class="bd"alt="" src="<%=UseValue.headImg%>">
			    </div>
				<h3 style="padding:0;margin:0;margin-top:15px;"><font style="color:#ffffff;"><%=UseValue.name%></font></h3>
				<p><font style="color:#ffffff;" size="3">给你发了一个红包</font></p>
			</div>
			</a>
			<!-- 红包结束 -->
	</div>
	<div class="foot">
		   <a href="http://<%=UseValue.Url%>"><font style="color:rgba(255,255,255,0.3);">技术支持&nbsp;比文科技</font></a>
   	</div>
   </body>
	<script>
		var flag = 1;
		var first = 1;
 		$(document).ready(function(){
			var h = $(window).height();
			var w = $(window).width();
			var t = (h-120)/2;
			var l = (w-120)/2;
 			$(".back").css("height",h);
			$(".back").css("width",w); 
			$("#one").width(w);
			$("#two").width(w);
			$("#one").height(h/2);
			$("#two").height(h/2);
			$(".money").css("width",w*0.8);
			var k = $(".money").width();
			$(".money").css("height",k/0.9);
			$(".money").css("margin-left",w*0.1);
			$(".money").css("margin-right",w*0.1);
			$(".money .logo2").css("margin-top",(k/0.9)*0.52);
 			$("#logo").css("top",t);
			$("#logo").css("left",l);
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
		var SHAKE_THRESHOLD = 800;
		var last_update = 0;
		var x = y = z = last_x = last_y = last_z = 0;
		var video1 = document.getElementById("musicBox1");
		var video2 = document.getElementById("musicBox2");
		$(document).on('touchstart', function() {
			video1.load();
			video2.load();
		});
		if (window.DeviceMotionEvent) {
			window.addEventListener('devicemotion', deviceMotionHandler, false);
		} else {
			alert('本设备不支持devicemotion事件');
		}

		function deviceMotionHandler(eventData) {
				var acceleration = eventData.accelerationIncludingGravity;
				var curTime = new Date().getTime();
				if ((curTime - last_update) > 200) {
					var diffTime = curTime - last_update;
					last_update = curTime;
					x = acceleration.x;
					y = acceleration.y;
					z = acceleration.z;
					var speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
					if (speed > SHAKE_THRESHOLD) {
						
						if (flag == 1){
							flag = 0;
							doResult();
						}
					}
					last_x = x;
					last_y = y;
					last_z = z;
				}
		}

		function doResult() {
			$("#one").addClass("anm1");
			$("#two").addClass("anm2");
			$("#three").hide();
			$('#title').html("摇一摇,摇出优惠券");
			video1.play();
			setTimeout(function() {
				hasCard();
				video2.play();
			}, 2000);
		}
		var cardId,cardTitle,cuUrl,timestamps,cardsignatures,AppId,redpackorcompany;
 		function hasCard(){
			setTimeout(function(){
				$("#one").removeClass("anm1");
				$("#two").removeClass("anm2");
			}, 300);
			$("#three").show();
			var url = "${pageContext.request.contextPath}/geLiPrize.action?openId="+"${userinfo.openid}";
			$
				.ajax({
					type : 'get',
					url : url,
					dataType : 'json',
					success : function(data) {
						if (data[0].Count != null){
							if (data[0].Count == "0"){
								setTimeout(function(){flag = 1;}, 1000);
								$('#num-text').remove();
								$('#title').html("继续摇一摇，还有惊喜哦");
							} else {
								$('#title').html("摇一摇,摇出优惠券");
								var num = $('#num').html(data[0].Count);
							}
							if (data[0].CardId != null ){
								cardId = data[0].CardId;
								AppId = data[0].AppId;
								cardTitle = data[0].CardTitle;
								setTimeout(function(){flag = 1;}, 5000);
								card(cardId, AppId);
							} else if (data[0].Count != null && data[0].Redpack == "success") {
								setTimeout(function(){flag = 1;}, 5000);
								redpackorcompany=data[0].RedpackState;
								redPack();
							} else if (data[0].Count != "0"){
								setTimeout(function(){flag = 1;}, 1000);
								$('#title').html("很遗憾没有摇到，再试一次");
							}
						} else {
							location.reload();
						}
					},
					failure : function(data) {
						alert(data);
					}
				});
		} 
		function card(cardId, AppId){
			$('#dialogBg').fadeIn(300);
			$(".result h2 font").html("优惠券");
			$(".result p font").html("亲，送您一张优惠券！");
			document.getElementById("result").className = "result";
			document.getElementById("button").className = "button";
			document.getElementById("result").className = "result result-show";
			document.getElementById("button").className = "button button-show";
				var url = "${pageContext.request.contextPath}/wechatConfig.action";
				 cuUrl=location.href.split('#')[0];
					$.ajax({
								type : 'get',
								url : url,
								dataType : 'json',
								async : false,
								data:{currentUrl:""+cuUrl+"",cardId:""+cardId+"",appid:""+AppId+""},
								success : function(data) {
									if (data != null) {
										timestamps=data[0].timestamp;
										cardsignatures =data[0].cardSignature;
										 wx.config({
												    debug: false,
												    appId: ""+AppId+"",
												    timestamp: ""+data[0].timestamp+"",
												    nonceStr: ""+data[0].nonceStr+"",
												    signature: ""+data[0].signature+"",
												    jsApiList: [
												      // 所有要调用的 API 都要加到这个列表中
														"addCard"
												    ]
											  });
									}
								},
								failure : function(data) {
									alert(data);
								}
							});
		}
		function redPack(){
			$('#dialogBgRed').fadeIn(300);
			document.getElementById("Redresult").className = "money";
			document.getElementById("Redresult").className = "money money-show";
		}
		function receiveRedPack(){
			if($('#Redresult').hasClass("money-show")){
				window.location.href="http://"+"<%=UseValue.Url%>"+"/Card/SendRedPackOAuth?redpackOrCompany="+redpackorcompany;
			}
		}
		$(".button a").click(function(){
			if ($('.button').hasClass("button-show")){
			$("#dialogBg").fadeOut();
			document.getElementById("result").className = "result";
			document.getElementById("button").className = "button";
			wx.error(function(res) {
				alert(res.errMsg);
			});
				wx.addCard({
					cardList: [{
					cardId: ''+cardId+'',
					cardExt: '{"code":"","openid":"","timestamp":"'+timestamps+'","signature":"'+cardsignatures+'"}'
														
					}], // 需要添加的卡券列表
					success : function(res) {
						//var cardList = res.cardList; // 添加的卡券列表信息
					},
					complete:function(res) {
						addFlag = 0;
					},
				});
			}
		});
	</script>

</html>