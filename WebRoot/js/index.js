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

			doResult();
		}
		last_x = x;
		last_y = y;
		last_z = z;
	}
}

function doResult() {
	$("#one").addClass("anm1");
	$("#two").addClass("anm2");
	video1.addEventListener("ended", function() {
		hasCard();
		video2.play();
		window.removeEventListener('devicemotion', deviceMotionHandler, false);
	});

	if (video1.paused) {
		video1.play();
		if (video1.paused) {
			setTimeout(function() {
				hasCard();
				window.removeEventListener('devicemotion', deviceMotionHandler, false);
			}, 1000);
		}
	}
}

function hasCard(){
	var num=parseInt(Math.random()*10);
	var url = "${pageContext.request.contextPath}/geLiPrize.action?pageId="+id+"";
	$
		.ajax({
			type : 'post',
			url : url,
			dataType : 'json',
			date:pageId=id,//发送给后台数据
			success : function(data) {
			},
			failure : function(data) {
				alert(data);
			}
		});
	setTimeout(function(){
		$("#one").removeClass("anm1");
		$("#two").removeClass("anm2");
	}, 300);
	$('#dialogBg').fadeIn(300);
	document.getElementById("result").className = "result";
	document.getElementById("button").className = "button";
	document.getElementById("button").className = "button button-show";
	document.getElementById("result").className = "result result-show";
    if(num==1 || num==2 || num==3)
    {
		$(".result h1").html("工具箱");
		$(".result p").html("格力电器送你一个工具箱");
    }
    else if(num==4 || num== 5 || num == 6){		
		$(".result h1").html("汤锅");
		$(".result p").html("格力电器送你一个汤锅");
    }
    else{
    	$(".result h1").html("蒸锅");
		$(".result p").html("格力电器送你一个蒸锅");
    }
}
