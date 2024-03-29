package org.example.demo4;

import java.util.List;

public interface EmployeeDao {
    void saveEmployee(Employe employee);
    void updateEmployee(Employe employee);
    void deleteEmployee(long employeeId);
    Employe getEmployeeById(long employeeId);
    List<Employe> getAllEmployees();
}
