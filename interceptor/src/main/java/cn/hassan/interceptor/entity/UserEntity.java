package cn.hassan.interceptor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/23 22:29
 * Description:
 */
@Entity
@Table(name = "user")
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String passward;

    private Date birthday;

    private String sex;

    private String address;
}
