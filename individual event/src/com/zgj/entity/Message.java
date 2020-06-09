package com.zgj.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private int id;
    private int sendUserId;//发送人编号
    private int recieveUserId;//接收人编号
    private Date sendDate;
    private String title;
    private String content;
    private  int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }

    public int getRecieveUserId() {
        return recieveUserId;
    }

    public void setRecieveUserId(int recieveUserId) {
        this.recieveUserId = recieveUserId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
