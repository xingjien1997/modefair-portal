package com.modefair.portal.domain;

import java.io.Serializable;

public class LecturerCourses implements Serializable {
    public Integer id;
    public String lecturerName;
    public String courseName;

    public LecturerCourses() {

    }

    public LecturerCourses(Integer id, String lecturerName, String courseName) {
        this.id = id;
        this.lecturerName = lecturerName;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
