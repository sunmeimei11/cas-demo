package com.qep.ssoclient.demo.service.impl;

import com.qep.ssoclient.demo.dao.UserDao;
import com.qep.ssoclient.demo.entity.User;
import com.qep.ssoclient.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: sunyl-b
 * @time: 2021/2/1 14:55
 * @summary: ""
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
