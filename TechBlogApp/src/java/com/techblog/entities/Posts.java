package com.techblog.entities;

import java.sql.*;

public class Posts {

    private int pId;
    private String pTitle;
    private String pContent;
    private String pPic;
    private Timestamp pDate;
    private int catId;
    private int userId;

    public Posts(int pId, String pTitle, String pContent,String pPic, Timestamp pDate, int catId, int userId) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pPic = pPic;
        this.pDate = pDate;
        this.catId = catId;
        this.userId = userId;
    }

    public Posts() {
    }

    public Posts(String pTitle, String pContent, String pPic, Timestamp pDate, int catId ,int userId) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pPic = pPic;
        this.pDate = pDate;
        this.catId = catId;
        this.userId  = userId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public Timestamp getpDate() {
        return pDate;
    }

    public void setpDate(Timestamp pDate) {
        this.pDate = pDate;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getuserId(){
        return userId;
    }
    
    public void setuserId(){
        this.userId=userId;
    }
}
