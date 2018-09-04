package com.wwwy.liuxing.message.httpApiDemo;


import com.wwwy.liuxing.message.httpApiDemo.common.Config;
import com.wwwy.liuxing.message.httpApiDemo.common.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 */
@Service
public class IndustrySMS {
    private static String operation = "/industrySMS/sendSMS";
    private static String accountSid = Config.ACCOUNT_SID;
    //	private static String to = "13437299800";


    /**
     * 验证码通知短信
     */
    public static String execute(String to, String randomCode) {
        /*String tmpSmsContent = null;
        try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }*/
        String smsContent = "【流星网】登录验证码：" + randomCode + "，" + "如非本人操作，请忽略此短信。打死也不能给别人！！";
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
                    + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        return result;
    }
}
