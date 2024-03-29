package org.example.demo4;

import jakarta.persistence.*;

import java.util.List;

public class EmployeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    public EmployeDaoImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveEmployee(Employe employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employe employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(employee);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Employe employee = entityManager.find(Employe.class, employeeId);
            if (employee != null) {
                entityManager.remove(employee);
            }
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public Employe getEmployeeById(long employeeId) {
        return entityManager.find(Employe.class, employeeId);
    }

    @Override
    public List<Employe> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }
}
