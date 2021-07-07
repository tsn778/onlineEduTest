package com.tsn.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tsn.pojo.*;
import com.tsn.pojo.Class;
import com.tsn.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FrontController {
    @Autowired
    private UserService userService;
     @Autowired
    SubjectService subjectService;
    @Autowired
    WorkService workService;
    @Autowired
    ClassService classService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ArticleService articleService;
    @Autowired
    EnrollService enrollService;
    @Autowired
    ReplyService replyService;
    @Autowired
    MaterialService materialService;
    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        List<Class> classes=classService.getClasses();
        model.addAttribute("indexclasses", classes);
        List<Subject> subjects=subjectService.getSubjects();
        model.addAttribute("indexworks", subjects);
        List<Work> works=workService.getWorks();


        model.addAttribute("viewworks", works);
        return "front/index";
    }
    @RequestMapping("/classes")
    public String classes(Model model){
        List<Class> classes=classService.getClasses();
        model.addAttribute("viewclasses", classes);
        return "front/classes";
    }
    @RequestMapping("/test")
    public String list(Model model){

        List<User> users=userService.getUsers();
        User user=userService.getUserByAccount("1001");
        model.addAttribute("users",users);
        model.addAttribute("a",user);
        return "front/test";

    }

    @RequestMapping("/work")
    public String getwork(){

        return "admin/work";
    }
    @RequestMapping("/viewwork")
    public String getwork(Model model){

        List<Work> works=workService.getWorks();


        model.addAttribute("viewworks", works);


        return "front/works";

    }
    @RequestMapping("/viewclass")
    public String viewclass(@RequestParam(required = false) Integer cid, Model model){
        if(cid==null)
        {
           Class classes= classService.getClassById(1);
            model.addAttribute("vclasses", classes);
           Teacher teacher=teacherService.getTeacherByName(classes.getTeacher());

            model.addAttribute("vteacher", teacher);
           List<SubinClass> subinClasses= classService.getSubjectById(1);
           List<Subject> subjects = new ArrayList<>();
           for(SubinClass subinClass : subinClasses){
               subjects.add(subjectService.getSubjectById(subinClass.getSubid()));
           }
            model.addAttribute("subinclass",subjects);
        }
        else {
            Class classes= classService.getClassById(cid);
            model.addAttribute("vclasses", classes);
            Teacher teacher=teacherService.getTeacherByName(classes.getTeacher());

            model.addAttribute("vteacher", teacher);
            List<SubinClass> subinClasses= classService.getSubjectById(cid);
            List<Subject> subjects = new ArrayList<>();
            for(SubinClass subinClass : subinClasses){
                subjects.add(subjectService.getSubjectById(subinClass.getSubid()));
            }
            model.addAttribute("subinclass",subjects);
        }
        return "front/class";
    }
    @RequestMapping("/viewsubject")
    public String viewsubject(@RequestParam(required = false) Integer subid, Model model){
        if(subid==null)
        {   Subject subject=subjectService.getSubjectById(1);

            model.addAttribute("vsubject", subject);
            Teacher teacher=teacherService.getTeacherByName(subject.getTeacher());

            model.addAttribute("vteacher", teacher);

        }
        else {
            Subject subject=subjectService.getSubjectById(subid);

            model.addAttribute("vsubject", subject);
            Teacher teacher=teacherService.getTeacherByName(subject.getTeacher());

            model.addAttribute("vteacher", teacher);
        }
        return "front/subject";
    }
    @RequestMapping("/login")
    public String login(){
        return "front/login";
    }
    @RequestMapping("/register")
    public String register(){
        return "front/register";
    }
    @RequestMapping("/subjects")
    public String subjects(Model model,@RequestParam(required = false) Integer subtype){
        List<Subject> subjects = subjectService.getSubjects();

        List<Subject> subject1 = new ArrayList<>();
        List<Subject> subject2 = new ArrayList<>();
        List<Subject> subject3 = new ArrayList<>();
        List<Subject> subject4 = new ArrayList<>();
        for(Subject subject:subjects){
            if(subject.getSubtype().equals("默认"))
            subject1.add(subject);
            if(subject.getSubtype().equals("班级课程"))
                subject2.add(subject);
            if(subject.getSubtype().equals("自学课"))
                subject3.add(subject);
        }
        if(subtype==null) {
                     subject4=subjects;
        }
        else if(subtype==1) {
                subject4=subject1;
        }else if(subtype==2){
            subject4=subject2;
        }else if(subtype==3){
            subject4=subject3;
        }else
        {}
        model.addAttribute("vsubjects", subject4);
        return "front/subjects";
    }
    @RequiresPermissions("look")
    @RequestMapping("/personal")
    public String personal(Model model, HttpSession session){
        User user=(User)session.getAttribute("admin");
         List<Enroll> enrolls=enrollService.getEnrolls();
          List<Enroll> enrolls1=new ArrayList<>();
        for(Enroll enroll : enrolls){
            if(enroll.getAccount().equals(user.getAccount()))
                enrolls1.add(enroll);

        }
        model.addAttribute("enrolls",enrolls1);
        List<Reply> replies=replyService.getReplys();
        List<Reply> replies1=new ArrayList<>();
        for(Reply reply : replies){
            if(reply.getAccount().equals(user.getAccount()))
                replies1.add(reply);

        }
        model.addAttribute("replies",replies1);
        return "front/personal";
    }

    @RequiresPermissions("look")
    @RequestMapping("/enroll")
    public String enroll(@RequestParam Integer cid,Model model,HttpSession session){
        if(session.getAttribute("admin")==null)
            return "/front/login";
        else {
            Class classes = classService.getClassById(cid);
            model.addAttribute("eclasses", classes);
        }
        return "front/enroll";
    }
    @RequestMapping("/reply")
    public String reply(Model model){
       List<Reply> replies=replyService.getReplys();
        model.addAttribute("replies",replies);

        return "front/reply";
    }
    @RequestMapping("/article")
    public String article(Model model){
        List<Article> articles=articleService.getArticles();
        List<Article> articles1 = new ArrayList<>();
        List<Article> articles2 = new ArrayList<>();
        List<Article> articles3 = new ArrayList<>();
        for(Article article : articles){
            if(article.getState()==1) {
                if (article.getArticletype().equals("素材")) {
                    articles1.add(article);

                }
                if (article.getArticletype().equals("资讯")) {
                    articles2.add(article);
                }
                if (article.getArticletype().equals("文章")) {
                    articles3.add(article);
                }
            }
        }

        model.addAttribute("sucai",articles1);
        model.addAttribute("zixun",articles2);
        model.addAttribute("wenzhang",articles3);
        return "front/article";
    }
    @RequestMapping("/viewarticle")
    public String viewarticle(@RequestParam Integer id, Model model){
        if(id==null)
        {
            Article article=articleService.getArticleById(1);

            model.addAttribute("varticle", article);


        }
        else {
            Article article=articleService.getArticleById(id);

            model.addAttribute("varticle", article);

        }
        return "front/lookarticle";
    }

    @RequestMapping("/searchPage")
    public String searchPage(String word,Model model){
        System.out.println(word);
        List<Subject> subjectsByWord = subjectService.getSubjectsByWord(word);
        List<Article> articles = articleService.selectArticlesByWord(word);
        model.addAttribute("subjects",subjectsByWord);
        model.addAttribute("articles",articles);
        return "front/searchPage";

    }
    @GetMapping("/video")
    public String videoPlay(Integer subjectId,Model model){
        List<Material> materials = materialService.queryMaterialByStuId(subjectId);
        model.addAttribute("videos",materials);
        Subject subjectById = subjectService.getSubjectById(subjectId);
        model.addAttribute("subject",subjectById);
        return "front/video";
    }


}
