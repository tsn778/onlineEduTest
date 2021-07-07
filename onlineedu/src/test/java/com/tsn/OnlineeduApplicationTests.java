package com.tsn;

import com.tsn.mapper.TeacherMapper;
import com.tsn.mapper.UserMapper;
import com.tsn.pojo.Article;
import com.tsn.pojo.Material;
import com.tsn.pojo.Subject;
import com.tsn.pojo.User;
import com.tsn.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class OnlineeduApplicationTests {
    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();

    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads2() {
        //看一下默认数据源
        User user = new User();
        user.setAccount("1003");
        user.setPassword("123456");
        User user1 = userMapper.getUserById(3);
        user1.setPassword("654321");
        System.out.println(user1);


    }

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void contextLoads3() {
        //看一下默认数据源
//        User user=new User();
//        user.setAccount("1003");
//        user.setPassword("123456");
//        User user1=userService.getUserByAccount("1001");
////        user1.setPassword("654321");
//        System.out.println(user1);
//        userMapper.updateUser(user1);
        teacherMapper.getTeachers();

    }

    @Autowired
    private MaterialService materialService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ArticleService articleService;
    @Test
    public void test1() {
//        System.out.println(materialService.queryMaterialByStuId(5));
        List<Subject> subjectsByWord = subjectService.getSubjectsByWord("设计");
        subjectsByWord.forEach(System.out::println);

    }
    @Test
    public void test2(){
        List<Article> articles = articleService.selectArticlesByWord("设计");
        articles.forEach(System.out::println);

    }
    @Test
    public void test3(){
        List<Material> materials = materialService.queryMaterialByStuId(12);
        materials.forEach(System.out::println);

    }
}
