package com.tsn.service;

import com.tsn.mapper.UserMapper;
import com.tsn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User getUserById(Integer uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
