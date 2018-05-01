package cn.hassan.jwt.jpa;

import cn.hassan.jwt.entity.TokenInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/28 21:41
 * Description:
 */
public interface TokenJPA extends JpaRepository<TokenInfoEntity,Long>,JpaSpecificationExecutor<TokenInfoEntity> {
}
