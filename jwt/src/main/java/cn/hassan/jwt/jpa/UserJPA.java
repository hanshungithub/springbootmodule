package cn.hassan.jwt.jpa;

import cn.hassan.jwt.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/28 21:39
 * Description:
 */
public interface UserJPA extends JpaRepository<UserInfoEntity,String>,JpaSpecificationExecutor<UserInfoEntity> {
}
