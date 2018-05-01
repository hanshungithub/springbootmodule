package cn.hassan.jwt.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/28 21:35
 * Description:
 */
@Entity
@Table(name = "api_token_infos",schema = "jwt")
@Data
public class TokenInfoEntity {

    @Id
    @GeneratedValue
    @Column(name = "ati_id")
    private long id;

    @Column(name = "ati_app_id")
    private String appId;

    @Column(name = "ati_token")
    private byte[] token;

    @Column(name = "ati_build_time")
    private String buildTime;
}
