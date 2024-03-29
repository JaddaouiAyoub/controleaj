package org.example.demo4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProjectEmployeeDaoAssignenement {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveProjectEmployee(ProjectEmployeeAssignment projectEmployee) {
        entityManager.persist(projectEmployee);
    }
}
