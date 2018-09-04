package com.wwwy.liuxing.message.httpApiDemo;



import com.wwwy.liuxing.message.httpApiDemo.common.Config;
import com.wwwy.liuxing.message.httpApiDemo.common.HttpUtil;

import java.net.URLEncoder;

/**
 * 会员营销短信接口
 * 
 * @ClassName: AffMarkSMS
 * @Description: 会员营销短信接口
 *
 */
public class AffMarkSMS
{
	private static String operation = "/affMarkSMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "13297033971";
	private static String smsContent = "登录验证码：{1}，如非本人操作，请忽略此短信。打死也不能给别人！！";

	/**
	 * 会员营销短信
	 */
	public static void execute()
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}
