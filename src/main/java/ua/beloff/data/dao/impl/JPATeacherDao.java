package ua.beloff.data.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.beloff.data.Teacher;
import ua.beloff.data.dao.TeacherDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class JPATeacherDao implements TeacherDao {
    @PersistenceContext
    private EntityManager em;

    public Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    public Teacher getTeacher(int id) {
        return em.find(Teacher.class,id);
    }

    public void saveTeacher(Teacher teacher) {
        em.merge(teacher);
    }
}