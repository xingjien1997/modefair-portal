package com.modefair.portal.service.impl;

import com.modefair.portal.dao.AdminDao;
import com.modefair.portal.dao.ScheduleDao;
import com.modefair.portal.domain.Admin;
import com.modefair.portal.domain.LecturerCourses;
import com.modefair.portal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AdminDao adminDao;

    @Override
    @Transactional(readOnly = true)
    public Map<String, List<String>> findAllMapWithLecturerAndCourses() {
        List<LecturerCourses> result = scheduleDao.findAllMapWithLecturerAndCourses();
        Map<String, List<String>> groupedResult = result.stream().collect(Collectors.groupingBy(LecturerCourses::getLecturerName, Collectors.mapping(LecturerCourses::getCourseName, Collectors.toList())));
        System.out.println(groupedResult);

        return groupedResult;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean authenticate(String adminName, String password) throws Exception {
        Admin admin = adminDao.getByAdminName(adminName).orElse(null);
        if (null != admin) {
            return bCryptPasswordEncoder.matches(password, admin.getAdminSecret());
        }
        return false;
    }
}
