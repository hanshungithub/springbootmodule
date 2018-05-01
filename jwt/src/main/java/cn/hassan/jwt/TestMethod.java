package cn.hassan.jwt;

import cn.hassan.jwt.entity.TokenInfoEntity;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/1 16:32
 * Description:
 */
public class TestMethod {

    @Test
    public void testClass() throws Exception {
        Class clazz = Class.forName("cn.hassan.jwt.entity.TokenInfoEntity");
        System.out.println(clazz);
        System.out.println(TokenInfoEntity.class);
    }
}
