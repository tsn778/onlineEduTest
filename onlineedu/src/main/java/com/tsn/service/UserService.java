package com.tsn.service;

import com.tsn.pojo.User;

import java.util.List;

public interface UserService {

    public  List<User> getUsers();//得到所有用户

   public User getUserById(Integer uid);//通过uid查询用户
    public User getUserByAccount(String account);
    public int addUser(User user);
    public int deleteUser(Integer uid);
    public int updateUser(User user);

}
