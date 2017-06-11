package com.zsq.repository;

import com.zsq.domain.Student;
import com.zsq.exception.EntityException;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Pure JPA
 * Created by renjunzhou on 2017/6/10.
 */

public class StudentRepository{
    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public Student findOne(String studentId) throws EntityException {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        if(student == null){
            throw new EntityException();
        }

        entityManager.persist(student);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return student;
    }

    public List<Student> findAll(){
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootEntry = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(rootEntry);
        TypedQuery<Student> allQuery = entityManager.createQuery(all);
        entityManager.getTransaction().commit();
        return allQuery.getResultList();
    }

    public Student save(Student paramStudent){
        Student student = null;
        entityManager.getTransaction().begin();
        if(paramStudent.getId()!=null){
            student = entityManager.find(Student.class, paramStudent.getId());
        }
        if(student == null){
            entityManager.persist(paramStudent);
            entityManager.flush();
        }

        entityManager.merge(paramStudent);
        entityManager.flush();

        entityManager.getTransaction().commit();

        return paramStudent;
    }

    public Student delete(String paramStudentId) throws EntityException {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, paramStudentId);
        if(student == null){
            throw new EntityException();
        }
        entityManager.remove(student);
        entityManager.flush();

        entityManager.getTransaction().commit();

        return student;
    }
}
