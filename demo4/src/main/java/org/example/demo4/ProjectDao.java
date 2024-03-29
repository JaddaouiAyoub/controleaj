package org.example.demo4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Project> getAllProjects() {
        TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
        return query.getResultList();
    }

    // Vous pouvez ajouter d'autres méthodes CRUD au besoin
}

