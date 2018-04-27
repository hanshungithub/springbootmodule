package cn.hassan.javamail;

import cn.hassan.javamail.enums.MailContentTypeEnum;
import cn.hassan.javamail.mailUtils.MailSender;

import java.util.ArrayList;

public class TestMail {
    public static void main(String[] args) throws Exception
    {
        new MailSender()
                .title("测试SpringBoot发送邮件")
                .content("简单文本内容发送")
                .contentType(MailContentTypeEnum.TEXT.getValue())
                .targets(new ArrayList<String>(){{
                    add("hshanshun@163.com");
                }})
                .send();
    }
}
