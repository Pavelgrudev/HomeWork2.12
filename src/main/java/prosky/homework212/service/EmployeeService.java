package prosky.homework212.service;

import prosky.homework212.model.Employee;

import java.util.Collection;

public interface EmployeeService  {
    Employee add(String firstName, String lastName, int salary, int departmentId);
    Employee add(String firstName,String lastName);
    Employee remove (String firstName,String lastName);
    Employee find (String firstName,String lastName);

    Collection<Employee> findAll();
}
