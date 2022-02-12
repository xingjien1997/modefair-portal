package com.modefair.portal.domain;

import java.io.Serializable;

public class RegisterScheduleForm implements Serializable {
    private String studentId;
    private String scheduleId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
}
