package org.example.demo4;

import jakarta.persistence.*;

@Entity
@Table(name = "project_employee")
public class ProjectEmployeeAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employe employee;

    private float implication;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Employe getEmployee() {
        return employee;
    }

    public void setEmployee(Employe employee) {
        this.employee = employee;
    }

    public float getImplication() {
        return implication;
    }

    public void setImplication(float implication) {
        this.implication = implication;
    }
}
