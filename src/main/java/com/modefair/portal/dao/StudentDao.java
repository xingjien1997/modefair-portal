package com.modefair.portal.dao;

import com.modefair.portal.domain.Student;
import com.modefair.portal.domain.StudentSchedule;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Optional<Student> getByStudentName(String name);
    void saveOrUpdate(Student s) throws Exception;
    List<Student> findAllStudents();
    List<StudentSchedule> findStudentSchedulesByStudentId(int id);
}
