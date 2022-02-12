package com.modefair.portal.dao;


import com.modefair.portal.domain.LecturerCourses;
import com.modefair.portal.domain.Schedule;
import com.modefair.portal.domain.StudentSchedule;

import java.util.List;


public interface ScheduleDao {
    List<Schedule> findAllByLecturerId(int id);

    List<LecturerCourses> findAllMapWithLecturerAndCourses();

    List<Schedule> findAvailableSchedulesByStudentId(int id);

    void saveOrUpdate(StudentSchedule form) throws Exception;
}
