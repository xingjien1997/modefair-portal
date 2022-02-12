package com.modefair.portal.service.impl;

import com.modefair.portal.dao.LecturerDao;
import com.modefair.portal.dao.ScheduleDao;
import com.modefair.portal.domain.Lecturer;
import com.modefair.portal.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    LecturerDao lecturerDao;

    @Autowired
    ScheduleDao scheduleDao;

    @Transactional(readOnly = true)
    public List<Lecturer> findAll() {
        return lecturerDao.findAll();
    }

}
