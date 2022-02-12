package com.modefair.portal.service.impl;

import com.modefair.portal.dao.StudentDao;
import com.modefair.portal.domain.Student;
import com.modefair.portal.domain.StudentSchedule;
import com.modefair.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void saveOrUpdate(Student s) throws Exception {
        if (null == s.getStudentSecret()) {
            //initialize student password by student name
            s.setStudentSecret(bCryptPasswordEncoder.encode(s.getStudentName()));
            studentDao.saveOrUpdate(s);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentSchedule> findStudentSchedulesByStudentId(int id) {
        return studentDao.findStudentSchedulesByStudentId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer authenticate(String username, String password) throws Exception {
        Student student = studentDao.getByStudentName(username).orElse(null);
        if (null != student && bCryptPasswordEncoder.matches(password, student.getStudentSecret())) {
            return student.getId();
        }
        return null;
    }
}
