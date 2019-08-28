package com.interview.model;

import java.io.Serializable;

public class UserEntity implements Serializable {

    private static final long serialVersionUID = -5980266333958177104L;
    private Integer id;
    private String userName;
    private String passWord;
    private String nickName;

    public UserEntity(String userName, String passWord, String nickName) {
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
