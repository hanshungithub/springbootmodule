package cn.hassan.fastjson.jpa;

import cn.hassan.fastjson.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface  UserJpa extends JpaRepository<UserEntity,Integer>,JpaSpecificationExecutor<UserEntity>,
        Serializable {

}
