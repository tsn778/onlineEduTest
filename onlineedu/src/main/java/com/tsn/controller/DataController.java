package com.tsn.controller;


import com.tsn.Data.LayTableData;
import com.tsn.pojo.*;
import com.tsn.pojo.Class;
import com.tsn.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class DataController {
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ClassService classService;
    @Autowired
    private WorkService workService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private EnrollService enrollService;
    @Autowired
    private ReplyService replyService;
    private String path = "D:/myfile/onlineEdu/";

    @RequestMapping("/getdata")
    public LayTableData gets() {

        List<User> users = userService.getUsers();


        LayTableData layTableData = new LayTableData();
        layTableData.setCode(0);
        layTableData.setCount(1000);
        layTableData.setMsg("");
        layTableData.setData(users);
        return layTableData;

    }

    @RequestMapping("/getsubject")
    public LayTableData getsubject() {
        LayTableData layTableData = new LayTableData();
        layTableData.setCode(0);
        layTableData.setCount(1000);
        layTableData.setMsg("");
        layTableData.setData(subjectService.getSubjects());
        return layTableData;


    }

    @RequestMapping("/getreply")
    public LayTableData getreply() {
        LayTableData layTableData = new LayTableData();
        layTableData.setCode(0);
        layTableData.setCount(1000);
        layTableData.setMsg("");
        layTableData.setData(replyService.getReplys());
        return layTableData;


    }

    @RequestMapping("/getarticle")
    public LayTableData getarticle() {
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        List<Article> articles = articleService.getArticles();
        List<Article> articles1 = new ArrayList<>();
        User user = (User) subject.getPrincipal();
        String editor = user.getAccount();
        if (subject.isPermitted("write")) {
            for (Article article : articles) {
                if (article.getEditor().equals(editor)) {
                    articles1.add(article);

                }

            }
            LayTableData layTableData = new LayTableData();
            layTableData.setCode(0);
            layTableData.setCount(1000);
            layTableData.setMsg("");
            layTableData.setData(articles1);
            return layTableData;

        } else {
            LayTableData layTableData = new LayTableData();
            layTableData.setCode(0);
            layTableData.setCount(1000);
            layTableData.setMsg("");
            layTableData.setData(articles);
            return layTableData;
        }


    }

    @RequestMapping("/getsteacher")
    public LayTableData getteacher() {
        LayTableData layTableData = new LayTableData();
        layTableData.setCode(0);
        layTableData.setCount(1000);
        layTableData.setMsg("");
        layTableData.setData(teacherService.getTeachers());
        return layTableData;


    }

    @RequestMapping("/getenroll")
    public LayTableData getenroll() {
        LayTableData layTableData = new LayTableData();
        layTableData.setCode(0);
        layTableData.setCount(1000);
        layTableData.setMsg("");
        layTableData.setData(enrollService.getEnrolls());
        return layTableData;


    }

    @RequestMapping("/getclass")
    public LayTableData getclass() {
        LayTableData layTableData = new LayTableData();
        layTableData.setCode(0);
        layTableData.setCount(1000);
        layTableData.setMsg("");

        layTableData.setData(classService.getClasses());
        return layTableData;


    }

    @RequestMapping("/uploadimage")
    public Map<String, Object> uploadimage(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) throws FileNotFoundException {

        if (file.isEmpty()) {
            System.out.println("????????????");
        }
        String fileName = file.getOriginalFilename();  // ?????????
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // ?????????
        //1.???????????????
        String lastName = file.getOriginalFilename();
        //2.??????????????????????????????????????????
        //3.??????????????????????????????
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = sdf.format(d);
        //4.???????????????
        String filePath = path + "upload/images/"; // ??????????????????

        String newName = dirName + fileName; // ????????????
        String url = "/upload/upload/images/" + newName;
        File dest = new File(filePath + newName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("src", url);//??????url
        dataMap.put("title", newName);//?????????????????????????????????
        System.out.println(map);
        return map;


    }

    @RequestMapping("/uploadarticle")
    public Map<String, Object> uploadarticle(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) throws FileNotFoundException {

        if (file.isEmpty()) {
            System.out.println("????????????");
        }
        String fileName = file.getOriginalFilename();  // ?????????
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // ?????????
        //1.???????????????
        String lastName = file.getOriginalFilename();
        //2.??????????????????????????????????????????
        //3.??????????????????????????????
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = sdf.format(d);
        //4.???????????????
        String filePath = path + "/upload/file/"; // ??????????????????

        String newName = dirName + fileName; // ????????????
        String url = "/upload/upload/file/" + newName;
        File dest = new File(filePath + newName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("src", url);//??????url
        dataMap.put("title", newName);//?????????????????????????????????
        System.out.println(map);
        return map;


    }

    @RequestMapping("/uploadenroll")
    public Map<String, Object> uploadenroll(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) throws FileNotFoundException {

        if (file.isEmpty()) {
            System.out.println("????????????");
        }
        String fileName = file.getOriginalFilename();  // ?????????
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // ?????????
        //1.???????????????
        String lastName = file.getOriginalFilename();
        //2.??????????????????????????????????????????
        //3.??????????????????????????????
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = sdf.format(d);
        //4.???????????????
        String filePath = path + "/upload/enroll/"; // ??????????????????

        String newName = dirName + fileName; // ????????????

        File dest = new File(filePath + newName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("filename", newName);//??????url
        dataMap.put("title", newName);//?????????????????????????????????
        System.out.println(map);
        return map;


    }

    @RequestMapping("/download")
    private String downloadFile(@RequestParam String name, HttpServletResponse response) throws FileNotFoundException {
        String filePath = path; // ??????????????????

//??????????????????????????????????????????,
        String fileName = name;//????????????????????????

        File file = new File(filePath + fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// ???????????????????????????
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);


            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "????????????";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "????????????";
    }

    @RequestMapping("/downloadmaterial")
    private String downloadmaterial(@RequestParam String name, HttpServletResponse response) throws FileNotFoundException {
        String filePath = path; // ??????????????????

//??????????????????????????????????????????,
        String fileName = name;//????????????????????????

        File file = new File(filePath + fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// ???????????????????????????
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);


            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "????????????";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "????????????";
    }

    @RequestMapping("/addClass")
    public Map<String, Object> addClass(Class classes) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();

        if (classes == null) {
            map.put("code", 1);//0???????????????1??????
            map.put("msg", "???????????????????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("error", "123455");
        } else if (classes.getCid() == null) {
            System.out.println("??????class");
            System.out.println(classes);
            classes.setState("1");
            classService.addClass(classes);


            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");
        } else {
            System.out.println("??????class");
            System.out.println(classes);
            classes.setState("1");
            classService.updateClass(classes);


            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");

        }
        return map;
    }

    @RequestMapping("/addSubject")
    public Map<String, Object> addsubject(Subject subject) {
        Map<String, Object> map = new HashMap<>();
        if (subject == null) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 1);//0???????????????1??????
            map.put("msg", "???????????????????????????");//????????????
            map.put("data", dataMap);

            dataMap.put("error", "123455");
        } else if (subject.getSubid() == null) {
            System.out.println("??????subject");
            System.out.println(subject);
            subject.setState("1");
            subjectService.addSubject(subject);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");
        } else {
            System.out.println("??????subject");
            System.out.println(subject);
            subject.setState("1");
            subjectService.updateSubject(subject);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");

        }
        return map;
    }

    @RequestMapping("/delsubject")
    public Map<String, Object> delsubject(@RequestParam Integer subid) {
        System.out.println(subid);
        subjectService.deleteSubject(subid);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("success", "123455");

        return map;
    }

    @RequestMapping("/deletework")
    public Map<String, Object> delwork(@RequestParam Integer wid) {
        System.out.println(wid);
        workService.deleteWork(wid);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("success", "123455");

        return map;
    }

    @RequestMapping("/delclass")
    public Map<String, Object> delclass(@RequestParam Integer cid) {
        classService.deleteClass(cid);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("success", "123455");

        return map;
    }

    @RequestMapping("/delreply")
    public Map<String, Object> delreply(@RequestParam Integer id) {
        replyService.deleteReply(id);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????
        map.put("data", dataMap);
        dataMap.put("success", "123455");

        return map;
    }

    @RequestMapping("/deluser")
    public Map<String, Object> deluser(@RequestParam Integer uid) {

        userService.deleteUser(uid);
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????


        return map;
    }

    @RequestMapping("/delteacher")
    public Map<String, Object> delteacher(@RequestParam Integer id) {

        teacherService.deleteTeacher(id);
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????


        return map;
    }

    @RequestMapping("/delarticle")
    public Map<String, Object> delarticle(@RequestParam Integer id) {

        articleService.deleteArticle(id);
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);//0???????????????1??????
        map.put("msg", "????????????");//????????????


        return map;
    }

    @RequestMapping("/registeruser")
    public Map<String, Object> registeruser(User user) {
        System.out.println(user);
        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            map.put("code", 1);
            map.put("msg", "????????????");

        } else {
            List<User> users = userService.getUsers();
            String lastaccount = null;
            for (User user1 : users) {
                lastaccount = user1.getAccount();
            }
            user.setAccount((Integer.parseInt(lastaccount) + 1) + "");
            user.setRole("user");
            userService.addUser(user);

            map.put("code", 0);
            map.put("msg", "????????????????????????" + user.getAccount());
        }
        return map;
    }

    @RequestMapping("/addteacher")
    public Map<String, Object> addteacher(Teacher teacher) {
        Map<String, Object> map = new HashMap<>();
        if (teacher == null) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 1);//0???????????????1??????
            map.put("msg", "???????????????????????????");//????????????
            map.put("data", dataMap);

            dataMap.put("error", "123455");
        } else if (teacher.getId() == null) {
            System.out.println("??????teacher");
            System.out.println(teacher);

            teacherService.addTeacher(teacher);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");
        } else {
            System.out.println("??????teacher");
            System.out.println(teacher);
            teacherService.updateTeacher(teacher);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");

        }
        return map;
    }

    @RequestMapping("/addwork")
    public Map<String, Object> addtwork(Work work) {
        Map<String, Object> map = new HashMap<>();
        if (work == null) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 1);//0???????????????1??????
            map.put("msg", "???????????????????????????");//????????????
            map.put("data", dataMap);

            dataMap.put("error", "123455");
        } else if (work.getWid() == null) {
            System.out.println("??????work");
            System.out.println(work);

            workService.addWork(work);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");
        } else {
            System.out.println("??????work");
            System.out.println(work);
            workService.updateWork(work);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");

        }
        return map;
    }

    @RequestMapping("/addarticle")
    public Map<String, Object> addarticle(Article article) {
        Map<String, Object> map = new HashMap<>();
        if (article == null) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 1);//0???????????????1??????
            map.put("msg", "???????????????????????????");//????????????
            map.put("data", dataMap);

            dataMap.put("error", "123455");
        } else if (article.getId() == null) {
            System.out.println("??????article");
            System.out.println(article);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowtime = sdf.format(d);
            article.setFristtime(nowtime);
            article.setEndtime(nowtime);
            article.setState(3);

            articleService.addArticle(article);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");
        } else {
            System.out.println("??????article");
            System.out.println(article);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowtime = sdf.format(d);
            article.setState(3);
            article.setEndtime(nowtime);
            articleService.updateArticle(article);

            Map<String, Object> dataMap = new HashMap<String, Object>();
            map.put("code", 0);//0???????????????1??????
            map.put("msg", "????????????");//????????????
            map.put("data", dataMap);
            dataMap.put("success", "123455");

        }
        return map;
    }

    @RequestMapping("/examine")
    public Map<String, Object> examine(@RequestParam Integer id, Integer code) {
        Article article = articleService.getArticleById(id);
        article.setState(code);
        articleService.updateArticle(article);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "????????????");
        return map;


    }

    @RequestMapping("/examineenroll")
    public Map<String, Object> examineenroll(@RequestParam Integer id, Integer code) {
        Enroll enroll = enrollService.getEnrollById(id);
        enroll.setState(code);
        enrollService.updateEnroll(enroll);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "????????????");
        return map;


    }

    @RequestMapping("/addenroll")
    public Map<String, Object> addenroll(Enroll enroll, HttpSession session) {
        System.out.println(enroll);
        User user = (User) session.getAttribute("admin");
        enroll.setAccount(user.getAccount());
        enroll.setState(0);
        enrollService.addEnroll(enroll);


        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "??????????????????????????????");
        return map;


    }

    @RequestMapping("/addreply")
    public Map<String, Object> addreply(Reply reply, HttpSession session) {
        User user = (User) session.getAttribute("admin");
        reply.setAccount(user.getAccount());
        reply.setCommenter(user.getUsername());
        System.out.println(reply);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = sdf.format(d);
        reply.setTime(nowtime);
        replyService.addReply(reply);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "????????????");
        return map;
    }
}
