package com.example.spring_demo.dao;

import com.example.spring_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // fields
    private EntityManager entityManager;

    // constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // interface methods implementation
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName =: theData ", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
        /*
        updates last names for all students
        int numRowsUpdated = entityManager.createQuery(
                "UPDATE Student SET lastName = 'Tester'")
                .executeUpdate();

         */
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);

        /*
        int numRowsDeleted = entityManager.createQuery(
                "DELETE FROM Student WHERE lastName = 'Smith'").executeUpdate();

         */
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery(
                "DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }

}
