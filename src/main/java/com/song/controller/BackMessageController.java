package com.song.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.song.bean.Wxuserinfo;
import com.song.service.WxUserInfoService;

import freemarker.template.Template;
import freemarker.template.TemplateException;



/**
 * 反馈信息
 * @author Administrator
 *
 */
@RestController
@RequestMapping("back")
public class BackMessageController {
	Logger log = LoggerFactory.getLogger(BackMessageController.class);
	@Autowired
	private WxUserInfoService wxUserInfoService;
	
	@Autowired
    private JavaMailSender mailSender;
	
	//配置邮件发送方 
	@Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数
	
	//配置邮件接收方法
	@Value("${backmessage.mail.accept}")
	private String mailAccept; 

	//发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;
    
	/**
	 * 发送邮件
	 * @param req
	 * @return
	 */
	@RequestMapping("/backmessage")	
	public String backMessage(String openid,String message){
		log.info("发送反馈信息到邮箱");
		//获取提交过来的参数
		//查询当前用户的名称
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
		/*SimpleMailMessage simmessage = new SimpleMailMessage();
		
		simmessage.setFrom(Sender);
		simmessage.setTo(mailAccept);
		//设置邮件的标题
		simmessage.setSubject("来自校园点歌台的用户   ："+wxuserinfo.getNickname()+"  的问题反馈 ：");
		//设置邮件内容
		simmessage.setText(context);
		//发送邮件
        mailSender.send(simmessage);*/
		
		try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(Sender);
            helper.setTo(mailAccept);//发送给谁
            helper.setSubject("来自校园点歌台的用户   ："+wxuserinfo.getNickname()+"  的问题反馈 ：");//邮件标题

            Map<String, Object> model = new HashMap<>();
            model.put("context", message);
            model.put("avatarurl", wxuserinfo.getAvatarurl());
            model.put("wxusername", wxuserinfo.getNickname());
            
            try {
                Template template = configurer.getConfiguration().getTemplate("backmail.ftl");
                try {
                    String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

                    helper.setText(text, true);
                    mailSender.send(mimeMessage);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        return "{\"result\":true,\"message\":\"反馈成功\"}";
	}

}
