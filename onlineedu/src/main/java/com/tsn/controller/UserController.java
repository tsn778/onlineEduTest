package com.tsn.controller;



import com.tsn.pojo.*;
import com.tsn.pojo.Class;
import com.tsn.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    ClassService classService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    WorkService workService;
    @Autowired
    TeacherService teacherService;
   @Autowired
   ArticleService articleService;
   @Autowired
   EnrollService enrollService;
    @RequestMapping("/index")
    public String adminindex(){

        return "admin/admin";
    }

    @RequestMapping("/getuser")
    public String getUsers(){


         return "admin/user";

    }

    @RequestMapping("/article")
    public String article(){


        return "admin/article";

    }
    @RequestMapping("/reply")
    public String reply(){


        return "admin/reply";

    }
    @RequestMapping("/subject")
    public String subjects(){

        return "admin/subject";
    }
    @RequestMapping("/class")
    public String classes(){

        return "admin/class";
    }
    @RequestMapping("/teacher")
    public String teachers(){

        return "admin/teacher";
    }
    @RequestMapping("/enroll")
    public String enrolls(){

        return "admin/enroll";
    }
    @RequestMapping("/editSubject")
    public String getsubject(@RequestParam(required = false) Integer subid, Model model){
        if (subid != null) {
            Subject subject = subjectService.getSubjectById(subid);
            model.addAttribute("subject", subject);

        }

        return "admin/subjectedit";

    }
    @RequestMapping("/editclass")
    public String getclass(@RequestParam(required = false) Integer cid, Model model){
        if (cid != null) {
            Class classes=classService.getClassById(cid);
                     model.addAttribute("classes", classes);

        }

        return "admin/classedit";

    }
    @RequestMapping("/editarticle")
    public String getarticle(@RequestParam(required = false) Integer id, Model model){
        if (id != null) {
            Article article=articleService.getArticleById(id);
            model.addAttribute("article", article);

        }

        return "admin/articleedit";

    }
    @RequestMapping("/work")
    public String getworkveiw(Model model){

            List<Work> works=workService.getWorks();


            model.addAttribute("works", works);


        return "admin/work";

    }
    @RequestMapping("/editwork")
    public String getwork(@RequestParam(required = false) Integer wid, Model model){
        if (wid != null) {
            Work work=workService.getWorkById(wid);

            model.addAttribute("work", work);

        }

        return "admin/workedit";

    }
    @RequestMapping("/editteacher")
    public String getteacher(@RequestParam(required = false) Integer id, Model model){
        if (id != null) {
            Teacher teacher=teacherService.getTeacherById(id);


            model.addAttribute("teacher", teacher);

        }

        return "admin/teacheredit";

    }
    @RequestMapping("/lookenroll")
    public String lookenroll(@RequestParam Integer id, Model model){
             Enroll enroll=enrollService.getEnrollById(id);



            model.addAttribute("enroll", enroll);


        return "admin/enrolllook";

    }
    @RequestMapping("/lookarticle")
    public String lookarticle(@RequestParam Integer id, Model model){
       Article article=articleService.getArticleById(id);



        model.addAttribute("article", article);


        return "admin/articlelook";

    }

}
