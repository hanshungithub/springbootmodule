package cn.hassan.fastjson.controller;

import cn.hassan.fastjson.entity.UserEntity;
import cn.hassan.fastjson.jpa.UserJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJpa userJpa;

    /**
     * 查找所有的用户
     *
     * @return 用户列表
     */
    @RequestMapping("/list")
    public List<UserEntity> findAllUser() {
        return userJpa.findAll();
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity)
    {
        return userJpa.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Integer id)
    {
        userJpa.delete(id);
        return userJpa.findAll();
    }
}
