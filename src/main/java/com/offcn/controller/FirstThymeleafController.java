package com.offcn.controller;

import com.offcn.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FirstThymeleafController {

    /**
     * 访问http://localhost:8080/first
     * 将数据message填充到templates/index.html
     * @param
     * @return
     */
    @RequestMapping("/first")
    public String first(HttpServletRequest request) {
        String message = "hello";
        request.setAttribute("message",message);
        return "index";
    }

    /**
     * 访问localhost:8080 页面
     * 将数据message填充到templates/index2.html
     * @param model
     * @return
     */
    @GetMapping("/second")
    public String indexPage(Model model) {
        User user = new User();
        user.setId("1");
        user.setAge(12);
        String message = "hello,Thymeleaf ";


        Map<String, Object> map = new HashMap<>();
        map.put("src1","1.jpg");
        map.put("src2","2.jpg");
        model.addAttribute("message",message);
        model.addAttribute("map",map);
        model.addAttribute("user",user);
        return "index2";
    }

    /**
     * 访问localhost:8080/java003 页面
     * 将数据message填充到templates/index3.html
     * @param model
     * @return
     */
    @GetMapping("/three")
    public String indexPage1(Model model) {
        ArrayList<User> list = new ArrayList<>();

        User user = new User();
        user.setId("1");
        user.setAge(12);
        list.add(user);
        User user1 = new User();
        user1.setId("2");
        user1.setAge(14);
        list.add(user1);
        User user2 = new User();
        user2.setId("3");
        user2.setAge(16);
        list.add(user2);

        model.addAttribute("list",list);
        return "index3";
    }

    /**
     * 访问localhost:8080/java003 页面
     * 将数据message填充到templates/index4.html
     * @param model
     * @return
     */
    @GetMapping("/four")
    public String indexPage2(Model model) {
        model.addAttribute("userName", "优就业");
        model.addAttribute("href", "http://www.ujiuye.com");
        return "index4";
    }

    /**
     * 访问localhost:8080/ 页面
     * 将数据message填充到templates/index4.html
     * @param model
     * @return
     */
    @GetMapping("/five")
    public String indexPage3(Model model) {

        model.addAttribute("flag", "yes");
        model.addAttribute("menu", "admin");
        model.addAttribute("manager", "manager");
        return "index5";
    }
    /**
     * 访问localhost:8080/java003 页面
     * 将数据message填充到templates/index7.html
     * @param model
     * @return
     */
    @GetMapping("/seven")
    public String indexPage5(Model model) {
        //日期时间
        Date date = new Date();
        model.addAttribute("date",date);
        //小数的金额
        double price = 2313.3123;
        model.addAttribute("price", price);

        //定义大文本数据
        String str="Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。\r\n" +
                "Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。\r\n" +
                "Thymeleaf也从一开始就设计了Web标准 - 特别是HTML5 - 允许您创建完全验证的模板，如果这是您需要的\r\n" ;
        model.addAttribute("strText", str);
        //定义字符串
        String str2="JAVA-offcn";
        model.addAttribute("str2", str2);
        return "index7";
    }

    }
