package org.example.demo4;

import jakarta.faces.view.ViewScoped;

import java.io.Serializable;
import java.util.List;


@ViewScoped
public class EmployeeBean implements Serializable {

    private List<Employe> employeeList;
    private Employe selectedEmployee;
    private String selectedProject;
    private String selectedPercentage;

    // Injectez votre EmployeeDao et ProjectDao ici

    private EmployeeDao employeeDao;


    private ProjectDao projectDao;


    private ProjectEmployeeDaoAssignenement projectEmployeeDao;

    // Getters et setters pour les DAOs


    public void init() {
        loadEmployees();
    }

    public List<Employe> loadEmployees() {
        employeeList = employeeDao.getAllEmployees();
        return null;
    }

    public List<Project> getAvailableProjects() {
        return projectDao.getAllProjects();
    }

    // Méthode pour assigner un projet à un employé
    public void assignProject() {
        if (selectedEmployee != null && selectedProject != null && !selectedProject.isEmpty() && selectedPercentage != null && !selectedPercentage.isEmpty()) {
            ProjectEmployeeAssignment projectEmployee = new ProjectEmployeeAssignment();
            projectEmployee.setEmployee(selectedEmployee);
            projectEmployee.setProject(selectedProject);
            projectEmployee.setImplication(Float.parseFloat(selectedPercentage));

            ProjectEmployeeDaoAssignenement projectEmployeeDaoAssignement= new ProjectEmployeeDaoAssignenement();
            projectEmployeeDaoAssignement.saveProjectEmployee(projectEmployee);
        } else {
            // Gérer les erreurs ou afficher un message d'erreur si nécessaire
        }
    }

    public List<Employe> getEmployeeList() {
       return loadEmployees();
    }

    // Autres méthodes de gestion des employés et des projets
}
