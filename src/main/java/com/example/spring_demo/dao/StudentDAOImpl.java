package com.example.spring_demo.dao;

import com.example.spring_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Student save(Student student) {

        // entityManager.persist(student);

        return entityManager.merge(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student order by lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student where lastName =: theData ", Student.class);

        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    /*
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
        /*
        updates last names for all students
        int numRowsUpdated = entityManager.createQuery(
                "UPDATE Student SET lastName = 'Tester'")
                .executeUpdate();


    }
    */

    @Override
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);

        /*
        int numRowsDeleted = entityManager.createQuery(
                "DELETE FROM Student WHERE lastName = 'Smith'").executeUpdate();

         */
    }

    @Override
    public int deleteAll() {
        int numRowsDeleted = entityManager
                .createQuery("DELETE FROM Student")
                .executeUpdate();
        return numRowsDeleted;
    }

}
