package com.bufoon.companyredbao;

public class WechatRedPackRequest {
    /*
     * 微信红包的请求对象，为了方便构造POST的数据，没有采用JAVA常规的命名方式
     * 
     * 变量名即是发送的参数名
     */

	private String mch_appid;        // 公众账号appid
	private String mchid;          // 商户号
	private String nonce_str;       // 随机字符串，不长于32位
	private String partner_trade_no;      // 商户订单号，必须唯一，组成： mch_id+yyyymmdd+10位一天内不能重复的数字
	private String openid;      // 用户openid
	private String check_name;       // 校验用户姓名选项
	//private String re_user_name;      // 收款用户姓名（可选）
	private int amount;       // 金额 
	private String desc;       // 企业付款描述信息 
	private String spbill_create_ip;          //Ip地址
    private String sign;            // 签名
    
	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
   
	
}
