package com.techblog.entities;

public class Categories {
    private int cId;
    private String cName;
    private String cDiscription;

    public Categories(int cId, String cName, String cDiscription) {
        this.cId = cId;
        this.cName = cName;
        this.cDiscription = cDiscription;
    }

    public Categories() {
    }

    public Categories(String cName, String cDiscription) {
        this.cName = cName;
        this.cDiscription = cDiscription;
    }

//    getters and setters
    
    public int getcId() {
        return cId;
    }

    public void setcId(int  cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDiscription() {
        return cDiscription;
    }

    public void setcDiscription(String cDiscription) {
        this.cDiscription = cDiscription;
    }

    
}
