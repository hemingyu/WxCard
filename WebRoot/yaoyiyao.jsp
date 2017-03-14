<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.base.model.UseValue"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>欢迎</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1 user-scalable=no">
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<style type="text/css">
	body{
		background-color: #efeff4;
	}
	</style>
</head>
<body>
<!-- 主题内容 -->
	<div>
		<div style="margin:55% auto 0;text-align:center;">
			<img src="<%=request.getContextPath()%>/img/loading.gif" width="60px" height="60px" alt="" />
		</div>
	</div>
<!-- 主题内容结束 -->

</body>
<script type="text/javascript">
$(document).ready(function(){
	var appid='${param.appid}';
	var code='${param.code}';
	var id='${param.id}';
	if (appid!='1'&&code=='1')
	{
		window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?"
 		+"appid="+appid+"&redirect_uri=http%3A%2F%2F"+"<%=UseValue.Url%>"+"%2FCard%2FCardOAuth"
 		+"&response_type=code&scope=snsapi_base&state="+appid+"&component_appid="+"<%=UseValue.ComponentAppid%>"+"#wechat_redirect";
	} 
	if (appid=='1'&&code!='1'){
		var url = "${pageContext.request.contextPath}/welcomeAuth.action";
		$
			.ajax({
				type : 'get',
				url : url,
				dataType : 'json',
				data:{code:""+code+""},
				success : function(data) {	
					if(data[0].result=="start"){
						window.location.replace("${pageContext.request.contextPath}/getUserInfo.action");
					}else{
						window.location.href="${pageContext.request.contextPath}/weixinOauth.action";
					}
				},
				failure : function(data) {
					alert(data);
				}
			});	
	}
 	if (id=="OAUthId"){
 		window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?"
	 		+"appid="+"<%=UseValue.AppId%>"+"&redirect_uri=http%3A%2F%2F"+"<%=UseValue.Url%>"+"%2FCard%2FAuthCardOAuth"
	 		+"&response_type=code&scope=snsapi_userinfo&state="+"<%=UseValue.AppId%>"
	 		+"&component_appid="+"<%=UseValue.ComponentAppid%>"+"#wechat_redirect";
 	}	
});
</script>
</html>

