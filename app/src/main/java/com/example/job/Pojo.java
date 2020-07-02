package com.example.job;
public class Pojo{
    public String un,phno, mail;

    public Pojo(){

    }
    public Pojo(String n, String p2, String email) {
        this.un = n;

        this.phno = p2;
        this.mail = email;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}