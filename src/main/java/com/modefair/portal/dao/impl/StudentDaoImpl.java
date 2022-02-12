package com.modefair.portal.dao.impl;

import com.modefair.portal.dao.StudentDao;
import com.modefair.portal.domain.Student;
import com.modefair.portal.domain.StudentSchedule;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Student> getByStudentName(String name) {
        String hql = "FROM Student s WHERE s.studentName = :studentName";
        return getCurrentSession().createQuery(hql, Student.class)
                .setParameter("studentName", name)
                .setMaxResults(1)
                .getResultList().stream().findFirst();
    }

    @Override
    public void saveOrUpdate(Student s) throws Exception{
        try {
            getCurrentSession().saveOrUpdate(s);
        } catch (HibernateException e) {
            throw new Exception("failed to create");
        }
    }

    @Override
    public List<Student> findAllStudents() {
        String hql = "FROM Student s";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<StudentSchedule> findStudentSchedulesByStudentId(int id) {
        String hql = "FROM StudentSchedule s WHERE s.student.id = :studentId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("studentId", id);
        return query.list();
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

}
