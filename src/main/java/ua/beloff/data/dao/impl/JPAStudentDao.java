package ua.beloff.data.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.beloff.data.Student;
import ua.beloff.data.dao.StudentDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JPAStudentDao implements StudentDao {
    @PersistenceContext
    private EntityManager em;

    public Student addStudent(Student student) {
        em.persist(student);
        return student;
    }

    public Student getStudent(int id) {
        return em.find(Student.class,id);
    }

    public void saveStudent(Student student) {
        em.merge(student);
    }
}
