package com.yidu.controller;


import com.yidu.dao.UserDao;
import com.yidu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-11-19 15:20:12
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserDao userDao;


    /**
     * 登录
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("login")
    public boolean selectOne(HttpServletRequest request, User user) {
        System.out.println("user = " + user);
        User users = this.userDao.login(user);
        System.out.println(users);
        request.getSession().setAttribute("user",users);
        if(users!=null){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("getSession")
    public User getSession(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, User user){
        //得到当前项目地址
        String path=request.getServletContext().getRealPath("/");
        File filePath = new File(path + "/myFile");
        //判断指定地址是否存在
        if(!filePath.exists()){
            filePath.mkdir();
            System.out.println("创建文件夹地址:"+filePath.getAbsolutePath());
        }
        //将文件移动到指定的页面
        String name = file.getOriginalFilename();
        System.out.println("filename = " + name);
        File file1 = new File(filePath, name);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setHeadimg(name);
        userDao.insert(user);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        return map;
    }
}