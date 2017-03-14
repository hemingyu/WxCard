package com.base.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.base.model.UseValue;
import com.base.service.WeiXinService;
import com.base.util.WeiXinStaticMethod;


public class WeiXinServiceImple implements WeiXinService{
	private static Logger log=Logger.getLogger(WeiXinServiceImple.class.getName());
//	public WeiXinDaoImpl weiXinDao=null;
	/**
	 * 微信接口验证֤
	 * */
	public boolean checkSignature(HttpServletRequest request, HttpServletResponse response){
		String signature = request.getParameter("signature");
		log.info("signature Value:"+signature);
        String timestamp = request.getParameter("timestamp");
        log.info("timestamp Value:"+timestamp);
        String nonce = request.getParameter("nonce");
        log.info("nonce Value:"+nonce);
        String[] tmpArr={UseValue.token,timestamp,nonce};
        Arrays.sort(tmpArr);
        String tmpStr=WeiXinStaticMethod.ArrayToString(tmpArr);
        tmpStr=WeiXinStaticMethod.SHA1Encode(tmpStr);
        log.info("tmpStr Value:"+tmpStr);
        if(tmpStr.equalsIgnoreCase(signature)){
        	log.info("checkSignature method is successful!");
			return true;
		}else{
			log.info("checkSignature method is fail!");
			return false;
		}
	}
	protected String readStreamParameter(ServletInputStream in){
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader=null;
		try{
			reader = new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line = reader.readLine())!=null){
				buffer.append(line);
	        }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}
	/**
//	 * 微信消息分类及推�?
//	 * @param request
//	 * @param response
//	 * @throws IOException
//	 */
//	public void weiXinManage(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		weiXinDao=new WeiXinDaoImpl();
//		String postStr=null;
//		PrintWriter out = response.getWriter();
//		try{
//			postStr=this.readStreamParameter(request.getInputStream());
//		}catch(Exception e){
//			log.error("Error weiXinManage method get postStr:"+ e);
//		}
//		if (null!=postStr&&!postStr.isEmpty()){
//			Document document=null;
//			try{
//				document = DocumentHelper.parseText(postStr);
//			}catch(Exception e){
//				log.error("Error weiXinManage method get document:"+ e);
//			}
//			if(null==document){
//				out.print("");
//				return;
//			}
//			Element root=document.getRootElement();
//            String fromUsername = root.elementText("FromUserName");
//            log.info("fromUsername Value:"+fromUsername);
//            String toUsername = root.elementText("ToUserName");
//            log.info("toUsername Value:"+toUsername);
//            String msgType = root.elementText("MsgType");
//            log.info("msgType Value:"+msgType);
//          if(msgType.equals("event")){
//        	  /**
//        	   * 事件消息类型
//        	   * */
//		       //目前仅仅处理subscribe(订阅)和unsubscribe(取消订阅)、CLICK(自定义菜单点击事�?暂时不处�?
//		       String event = root.elementText("Event");
//		       log.info("event Value:"+event);
//		       if(event.equals("subscribe")){
//		    	   EventEntity eventEntity=new EventEntity();
//		    	   eventEntity.setToUserName(toUsername);
//		    	   eventEntity.setFromUserName(fromUsername);
//		    	   eventEntity.setCreateTime(UseValue.getTime());
//		    	   eventEntity.setMsgType(msgType);
//		    	   eventEntity.setEvent(event);
//		    	   String eventContent=weiXinDao.doSubscribe(eventEntity);
//		           out.print(eventContent);
//		       }else if(event.equals("unsubscribe")){
//		    	   
//			     }else if(event.equals("CLICK")){
//			    	 MenuEntity menuEntity=new MenuEntity();
//			    	 menuEntity.setToUserName(toUsername);
//			    	 menuEntity.setFromUserName(fromUsername);
//			    	 menuEntity.setCreateTime(UseValue.getTime());
//			    	 menuEntity.setMsgType(msgType);
//			    	 menuEntity.setEvent(event);
//			    	 String eventKey = root.elementText("EventKey");
//				     log.info("eventKey Value:"+eventKey);
//				     menuEntity.setEventKey(eventKey);
//				     String menuContent=weiXinDao.doMenuClick(menuEntity);
//			         out.print(menuContent);
//			    }else {
//		            
//		            return;
//			    }
//		    }else if(msgType.equals("text")){
//		    	
//	        	 String content = root.elementText("Content");
//	        	 log.info("content Value:"+content);
//	        	 String msgId = root.elementTextTrim("MsgId");
//	        	 log.info("MsgId Value:"+msgId);
//	        	 TextEntity textEntity=new TextEntity();
//	        	 textEntity.setToUserName(toUsername);
//	        	 textEntity.setFromUserName(fromUsername);
//	        	 textEntity.setCreateTime(UseValue.getTime());
//	        	 textEntity.setContent(content);
//	        	 textEntity.setMsgId(msgId);
//	        	 String textContent=weiXinDao.doTextNew(textEntity);
//	        	 out.print(textContent);
//	             return;
//		     }
//		}else {
//		    out.print("");
//	    }
//	}
}
