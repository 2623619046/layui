package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-11-19 15:18:18
 */
@Component
public class User implements Serializable {
    private static final long serialVersionUID = -70500988070202952L;
    
    private Integer uid;
    
    private String uname;
    
    private String upass;
    
    private String headimg;

    public User(Integer uid, String uname, String upass, String headimg) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.headimg = headimg;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", headimg='" + headimg + '\'' +
                '}';
    }
}