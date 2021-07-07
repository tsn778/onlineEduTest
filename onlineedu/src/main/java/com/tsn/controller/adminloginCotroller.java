package com.tsn.controller;

import com.tsn.pojo.User;
import com.tsn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class adminloginCotroller {
    @Autowired
    private UserService userService;


    @RequestMapping("/adminlogin")
    public String adminUserlogin(){


        return  "admin/login";
    }
    @RequestMapping("/noauth")
    public String unauthorized(){
        return "admin/error";

    }
    @ResponseBody
    @RequestMapping("tests")
    public String test1(){

        Subject subject=SecurityUtils.getSubject();
        if(subject.isPermitted("write")){
            return "ok";


        }
        return "no";
    }
    @ResponseBody
    @RequestMapping("/validatelogin")
    public Map<String, Object> adminloginlogin(String account, String password , Model model, HttpSession session) {
        Map<String, Object> map=new HashMap<>();
        Map<String,Object> dataMap = new HashMap<String,Object>();
        System.out.println(account+":"+password);
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录信息
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);

        try {

            subject.login(token);//执行登录方法，如果无异常则执行
            User user=(User)subject.getPrincipal();
                session.setAttribute("admin",user);
                map.put("code",0);
                map.put("msg","登录成功");
            map.put("data",dataMap);
            dataMap.put("success","123455");
            System.out.println("登录成功");
                return map;

        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            map.put("code",1);
            map.put("msg","用户名错误");
            map.put("data",dataMap);
            dataMap.put("success","123455");
            return map;

        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            map.put("code",1);
            map.put("msg","密码错误");
            map.put("data",dataMap);
            dataMap.put("success","123455");
            return map;

        }
    }
    @RequestMapping("/logout")
    public String logout(){
        Subject subject =SecurityUtils.getSubject();
        subject.logout();
        return "/admin/login";
    }
    @RequestMapping("/frontlogout")
    public String frontlogout(){
        Subject subject =SecurityUtils.getSubject();
        subject.logout();
        return "/front/login";
    }

}
