package com.modefair.portal.dao.impl;

import com.modefair.portal.dao.ScheduleDao;
import com.modefair.portal.domain.LecturerCourses;
import com.modefair.portal.domain.Schedule;
import com.modefair.portal.domain.StudentSchedule;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Schedule> findAllByLecturerId(int id) {
        String hql = "FROM Schedule s WHERE s.lecturer.id = :lecturer_id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("lecturer_id", id);
        return query.list();
    }

    @Override
    public List<LecturerCourses> findAllMapWithLecturerAndCourses() {
        String hql = "SELECT DISTINCT NEW " + LecturerCourses.class.getName() +"(s.lecturer.id, s.lecturer.lecturerName, c.courseName) FROM Schedule s, Course c WHERE s.course.id = c.id ORDER BY s.lecturer.id";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Schedule> findAvailableSchedulesByStudentId(int id) {
        String hql = "FROM Schedule ms WHERE ms.id NOT IN (SELECT ss.schedule.id FROM StudentSchedule ss, Schedule s WHERE ss.schedule.id = s.id AND ss.student.id = :studentId)" +
                "AND ms.course.id NOT IN (SELECT s.course.id FROM StudentSchedule ss, Schedule s WHERE ss.schedule.id = s.id AND ss.student.id = :studentId)";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("studentId", id);
        return query.list();
    }

    @Override
    public void saveOrUpdate(StudentSchedule form) throws Exception{
        try {
            getCurrentSession().saveOrUpdate(form);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new Exception("failed to insert");
        }
    }

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
