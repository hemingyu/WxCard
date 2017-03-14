/**
 * 注册帐号
 */
function register(button) {
	
}

/**
 * 页面初始化
 */
function init() {
	dwr.engine.setActiveReverseAjax(true); // 激活反转 重要
	ChatManager.updateUsersList(true); // 当你打开界面的时候,先获得在线用户列表.
}
/**
 * 发送消息
 */
function send() {
//	var sender = dwr.util.getValue('username'); // 获得发送者名字
//	var receiver = dwr.util.getValue('receiver'); // 获得接受者id
	var msg = dwr.util.getValue('message'); // 获得消息内容
	if(msg!=""){
		ChatManager.send(msg); // 发送消息
		$('#message')[0].value="";
	}
}
function sendFlag(){
	ChatManager.setFlag();
}
setTimeout("sendFlag()",10000);
window.onload = init;//页面加载完毕后执行初始化方法init