package cn.hassan.javamail.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/27 21:32
 * Description:
 */
@Data
public class MailEntity implements Serializable {

    private String smptService;
    private String smptPort;
    private String fromMailAddress;
    private String frimMailStmpPwd;
    private String title;
    private String content;
    private String contentType;
    private List<String> list = new ArrayList<>();
}
