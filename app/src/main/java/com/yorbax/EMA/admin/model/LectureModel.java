package com.yorbax.EMA.admin.model;import java.io.Serializable;public class LectureModel implements Serializable {    public String id;    public String name;    public String course;    public String courseId;    public String username;    public String email;    public String password;    public int loginType;    public LectureModel() {    }    public LectureModel(String id, String name, String course, String courseId, String username, String email, String password, int loginType) {        this.id = id;        this.name = name;        this.course = course;        this.courseId = courseId;        this.username = username;        this.email = email;        this.password = password;        this.loginType=loginType;    }}