package com.modefair.portal.service.impl;

import com.modefair.portal.dao.ScheduleDao;
import com.modefair.portal.domain.Schedule;
import com.modefair.portal.domain.StudentSchedule;
import com.modefair.portal.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> findAllByLecturerId(int id) {
        return scheduleDao.findAllByLecturerId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> findAvailableSchedulesByStudentId(int id) {
        return scheduleDao.findAvailableSchedulesByStudentId(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(StudentSchedule form) throws Exception {
        scheduleDao.saveOrUpdate(form);
    }
}
