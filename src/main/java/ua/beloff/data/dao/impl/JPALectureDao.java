package ua.beloff.data.dao.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.beloff.data.Lecture;
import ua.beloff.data.dao.LectureDao;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class JPALectureDao implements LectureDao {
    @PersistenceContext
    private EntityManager em;

    public Lecture addLecture(Lecture lecture) {
        em.persist(lecture);
        Cache cache = em.getEntityManagerFactory().getCache();
        System.out.println(cache.contains(Lecture.class, lecture.getId()));
        cache.evict(Lecture.class);
        System.out.println(cache.contains(Lecture.class, lecture.getId()));
        return lecture;
    }

    public List<Lecture> listAll() {
        Query query = em.createNamedQuery(Lecture.FIND_ALL, Lecture.class);
        List<Lecture> ls = query.getResultList();
        return ls;
    }

   public List<Lecture> getLecture(String name) {
        Query query = em.createNamedQuery(Lecture.FIND_BY_NAME, Lecture.class);
        query.setParameter("name", name);
        List<Lecture> ls = query.getResultList();
        return ls;
    }

    @Cacheable(cacheNames = "lecturesCache")
    public Lecture getLecture(int id) {
        Query query = em.createNamedQuery(Lecture.FIND_BY_ID, Lecture.class);
        query.setParameter("id", id);
        Lecture l = (Lecture) query.getSingleResult();
        return l;
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }
}
