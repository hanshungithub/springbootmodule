package cn.hassan.javamail.enums;



/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/27 21:42
 * Description:
 */
public enum  MailContentTypeEnum {

    HTML    ("text/html;charset=UTF-8"),
    TEXT    ("text");

    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
