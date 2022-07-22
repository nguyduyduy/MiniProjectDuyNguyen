package com.models;

public class HoroscopeUser {

    private Integer userid;

    private String username;

    private String user_password;

    private String firstname;

    private String lastname;

    private String email;

    private String zodiac;

    private String mood;

    public HoroscopeUser() {
    }

    public HoroscopeUser(String username, String user_password, String firstname, String lastname, String email, String zodiac) {
        this.username = username;
        this.user_password = user_password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.zodiac = zodiac;
    }

    public HoroscopeUser(Integer userid, String mood) {
        this.userid = userid;
        this.mood = mood;
    }

    public HoroscopeUser(String username, String user_password, String firstname, String lastname, String email, String zodiac, String mood) {
        this.username = username;
        this.user_password = user_password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.zodiac = zodiac;
        this.mood = mood;
    }

    public HoroscopeUser(Integer userid, String username, String user_password, String firstname, String lastname, String email, String zodiac, String mood) {
        this.userid = userid;
        this.username = username;
        this.user_password = user_password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.zodiac = zodiac;
        this.mood = mood;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
