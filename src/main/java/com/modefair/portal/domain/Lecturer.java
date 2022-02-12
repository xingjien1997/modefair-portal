package com.modefair.portal.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lecturer")
public class Lecturer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "lecturer_name")
    private String lecturerName;

    @Column(name = "lecturer_salary")
    private Integer lecturerSalary;

    @Column(name = "lecturer_secret")
    private String lecturerSecret;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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

    public Integer getLecturerSalary() {
        return lecturerSalary;
    }

    public void setLecturerSalary(Integer lecturerSalary) {
        this.lecturerSalary = lecturerSalary;
    }

    public String getLecturerSecret() {
        return lecturerSecret;
    }

    public void setLecturerSecret(String lecturerSecret) {
        this.lecturerSecret = lecturerSecret;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
