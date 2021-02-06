package com.qep.ssoclient.demo.dao;

import com.qep.ssoclient.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: sunyl-b
 * @time: 2021/2/1 14:49
 * @summary: ""
 */

@Mapper
public interface UserDao {
    User login(User user);


}
