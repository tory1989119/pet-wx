package com.pet.wx.common.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pet.wx.common.http.HttpClientUtils;
import com.pet.wx.common.utils.MD5Utils;
import com.pet.wx.common.utils.XMLUtils;


/**
 * 短信服务
 * 
 * @author melodymao
 * @version $Id: SmsService.java, v 0.1 2015年10月12日 下午12:54:54  Exp $
 */
@Service
public class SmsService {

    
    /**
     * 文本短信服务接口
     */
    @Value("${sms.service.url}")
    private String SMS_SERVICE_URL;
    
    /**
     * 账号
     */
    @Value("${sms.account}")
    private String ACCOUNT;
    
    /**
     * 密码
     */
    @Value("${sms.pwd}")
    private String PWD;
    
    
    /**
     * 发送短信
     * 
     * @param content 发送的内容
     * @param targetPhoneNumbers 接收方手机号码数组(语音短信只能有一个号码)
     * @param type 1:文本短信 2:语音短信
     * @throws UnsupportedEncodingException 
     * @throws DocumentException 
     */
    public boolean sendSms(String[] targetPhoneNumbers,String content,int type) throws UnsupportedEncodingException, DocumentException{
        boolean result = false;
        switch (type) {
            case 1://文本
                result = sendText(content,targetPhoneNumbers);
                break;
            case 2://语音
                //暂不支持
               // result = sendVoice(content,targetPhoneNumbers);
                break;
        }
        return result;
    }
    
    //发送文本
    private boolean sendText(String content,String[] targetPhoneNumbers) throws UnsupportedEncodingException, DocumentException{
        /*Map<String,String> params = new HashMap<String,String>();
        params.put("action", "send");
        params.put("userid", "");
        params.put("account", ACCOUNT);
        params.put("password", MD5Utils.getMD5String(PWD).toUpperCase());
        params.put("mobile", appendTargetPhoneNumber(targetPhoneNumbers));
        params.put("content", new String(URLEncoder.encode(content,"utf-8")));
        params.put("sendTime", "");
        params.put("extno", "");
        String result = HttpClientUtils.post(SMS_SERVICE_URL, params);*/
        StringBuilder builder =  new StringBuilder(SMS_SERVICE_URL);
        builder.append("?").append("action=send&").append("userid=&account=").append(ACCOUNT).append("&password=")
         .append(MD5Utils.getMD5String(PWD).toUpperCase()).append("&mobile=").append(appendTargetPhoneNumber(targetPhoneNumbers))
         .append("&content=").append(URLEncoder.encode(content,"utf-8")).append("&sendTime=&extno=");
        String result = HttpClientUtils.get(builder.toString(),"UTF-8");
        Document document = XMLUtils.readXmlString(result);
        String status = XMLUtils.getChild(document.getRootElement(),"returnstatus").getText();
        return "Success".equalsIgnoreCase(status);
    }
    
    //发送语音
   /* private boolean sendVoice(String content,String[] targetPhoneNumbers) throws UnsupportedEncodingException{
        Map<String,String> params = new HashMap<String,String>();
        params.put("account", ACCOUNT);
        params.put("password", getMD5String(PWD+AUTHORIZTION_CODE_VOICE));
        params.put("srcnum", "");
        params.put("descnum", targetPhoneNumbers[0]);
        params.put("voiceid",String.valueOf(System.currentTimeMillis()));
        params.put("voicetype","1");
        params.put("confirmkey","");
        params.put("userip","127.0.0.1");
        params.put("sessionid",String.valueOf(System.currentTimeMillis()));
        params.put("shownum",SHOW_NUMBER);
        params.put("ext","");
        params.put("content", new String(content.getBytes("GBK")));
        String result = HttpClientUtils.post(VOICE_SMS_SERVICE_URL, params);
        return "0".equals(result);
    }*/
    
    /**
     * 用逗号连接手机号码
     * 
     * @param targetPhoneNumbers
     * @return
     */
    private String appendTargetPhoneNumber(String[] targetPhoneNumbers){
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < targetPhoneNumbers.length;i++){
            builder.append(targetPhoneNumbers[i]);
            if(i == targetPhoneNumbers.length - 1){
                break;
            }
            builder.append(",");
        }
        return builder.toString();
    }
    
    /**
     * 获取md5加密字符串，不足32位在前面补0
     * 
     * @param source
     * @return
     * @throws UnsupportedEncodingException 
     */
   /* private String getMD5String(String source) throws UnsupportedEncodingException{
        String md5 = MD5Utils.getMD5String(PWD+AUTHORIZTION_CODE_VOICE).toLowerCase();
        StringBuilder builder = new StringBuilder();
        if(md5.length() < 32){
            for(int i = 0;i<32-md5.length();i++){
                builder.append("0");
            }
        }
        builder.append(md5);
        return builder.toString().toLowerCase();
    }*/
}
