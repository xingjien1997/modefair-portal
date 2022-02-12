package com.modefair.portal.service;

import com.modefair.portal.domain.Student;
import com.modefair.portal.domain.StudentSchedule;

import java.util.List;

public interface StudentService {
    void saveOrUpdate(Student s) throws Exception;
    List<Student> findAllStudents();
    List<StudentSchedule> findStudentSchedulesByStudentId(int id);
    Integer authenticate(String username, String password) throws Exception;
}
