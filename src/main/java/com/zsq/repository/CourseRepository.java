package com.zsq.repository;

import com.zsq.domain.Course;
import com.zsq.exception.EntityException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository{
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public Course findOne(String courseId) throws EntityException {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        if(course == null){
            throw new EntityException();
        }

        entityManager.persist(course);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return course;
    }

    public List<Course> findAll(){
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> rootEntry = cq.from(Course.class);
        CriteriaQuery<Course> all = cq.select(rootEntry);
        TypedQuery<Course> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public Course save(Course paramCourse){
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, paramCourse.getId());
        if(course == null){
            entityManager.persist(paramCourse);
            entityManager.flush();
        }

        entityManager.merge(paramCourse);
        entityManager.flush();

        entityManager.getTransaction().commit();

        return course;
    }

    public Course delete(String paramCourseId) throws EntityException {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, paramCourseId);
        if(course == null){
            throw new EntityException();
        }

        entityManager.remove(course);
        entityManager.flush();

        entityManager.getTransaction().commit();

        return course;
    }


    public List<String> findAllName(){
        List<String> names = new ArrayList<>();
        for (Course course: findAll()) {
            names.add(course.getName());
        }
        return names;
    }

    public String findIdByName(String name){
        return (String) entityManager.createQuery("select C.id from Course C where C.name = :name").setParameter("name",name).getSingleResult();
    }
}
