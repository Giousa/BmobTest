package com.giousa.bmobgiou.bean;

import cn.bmob.v3.BmobObject;

/**
 * Description:
 * Author:Giousa
 * Date:2016/12/1
 * Email:65489469@qq.com
 */
public class Student extends BmobObject {

    private String name;
    private Integer age;
    private Float height;
    private Boolean isPlayer;
    private String hobby;
    private String phoneNum;
    private String email;
    private String qqNum;
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Boolean getPlayer() {
        return isPlayer;
    }

    public void setPlayer(Boolean player) {
        isPlayer = player;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isPlayer=" + isPlayer +
                ", hobby='" + hobby + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
