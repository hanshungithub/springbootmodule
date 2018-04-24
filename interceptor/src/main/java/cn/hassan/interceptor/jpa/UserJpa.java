package cn.hassan.interceptor.jpa;

import cn.hassan.interceptor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/23 22:33
 * Description:
 */
public interface UserJpa extends JpaRepository<UserEntity,Long> ,JpaSpecificationExecutor<UserEntity>,Serializable {
}
