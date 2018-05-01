package cn.hassan.jwt.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/28 21:43
 * Description:
 */
@Data
public class TokenResult implements Serializable {

    private boolean flag = true;

    private String msg;

    private String token;
}
