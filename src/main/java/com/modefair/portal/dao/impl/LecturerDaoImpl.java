package com.modefair.portal.dao.impl;

import com.modefair.portal.dao.LecturerDao;
import com.modefair.portal.domain.Lecturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LecturerDaoImpl implements LecturerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Lecturer> findAll() {
        List<Lecturer> lecturerList = getCurrentSession().createQuery("from Lecturer").list();
        return lecturerList;
    }

    @Override
    public Lecturer getLecturerByName(String name) {
        return null;
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
