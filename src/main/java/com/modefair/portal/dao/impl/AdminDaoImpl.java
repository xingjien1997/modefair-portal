package com.modefair.portal.dao.impl;

import com.modefair.portal.dao.AdminDao;
import com.modefair.portal.domain.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Admin> getByAdminName(String name) {
        String hql = "FROM Admin a WHERE a.adminName = :adminName";
        return getCurrentSession().createQuery(hql, Admin.class)
                .setParameter("adminName", name)
                .setMaxResults(1)
                .getResultList().stream().findFirst();
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

}
