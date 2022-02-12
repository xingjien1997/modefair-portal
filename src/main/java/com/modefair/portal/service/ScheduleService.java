package com.modefair.portal.service;

import com.modefair.portal.domain.Schedule;
import com.modefair.portal.domain.StudentSchedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllByLecturerId(int id);
    List<Schedule> findAvailableSchedulesByStudentId(int id);
    void saveOrUpdate(StudentSchedule form) throws Exception;
}
