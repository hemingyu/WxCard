package com.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.base.model.AccessToken;
import com.base.model.AuthMasterToken;
import com.base.model.ComponentToken;
import com.base.model.UseValue;
import com.bufoon.util.Util;
import com.wechat.method.TrustAnyTrustManager;

public class CommonUtil {
	private static Logger log =Logger.getLogger(CommonUtil.class);
	public static JSONObject httpsRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext 对象，并且使用我们指定的任务管理初始化
			TrustManager[] tm = { new TrustAnyTrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext 对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			log.info("请求URL"+requestUrl);
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			conn.setConnectTimeout(10000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setReadTimeout(10000);
			// 设置请求方法
			conn.setRequestMethod(requestMethod);
			if (!Util.isNull(outputStr)) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.flush();
				outputStream.close();
			}
			log.info("请求到输入流");
			// 从输入流读取数据
			InputStream is = conn.getInputStream();
			log.info("输入流的值"+is);
			InputStreamReader inputStreamReader = new InputStreamReader(is,
					"UTF-8");
			log.info("input的值"+inputStreamReader);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				log.info("获得字符串"+str);
				buffer.append(str);
			}
			log.info("请求返回值"+buffer);
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			is.close();
			conn.disconnect();
			jsonObject=JSONObject.fromObject(buffer.toString());
		} catch (ConnectException e) {
			log.error("请求连接异常");
		} catch (Exception e) {
			log.error("处理异常");
		}
		return jsonObject;
		
	}
}
