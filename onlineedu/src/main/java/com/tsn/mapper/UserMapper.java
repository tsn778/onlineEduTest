package com.tsn.mapper;

import com.tsn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface UserMapper {

    List<User> getUsers();//得到所有用户

    User getUserById(Integer uid);//通过uid查询用户
    User getUserByAccount(String account);
    int addUser(User user);
    int deleteUser(Integer uid);
    int updateUser(User user);
}
