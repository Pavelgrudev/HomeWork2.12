package prosky.homework212.service.Impl;

import prosky.homework212.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstans  {
    public static final String FIRST_NAME ="Ivan";
    public static final String LAST_NAME ="Ivanov";
    public static final String FIRST_NAME2 ="Sergey";
    public static final String LAST_NAME2 ="Sergeev";
    public static final int SALARY=100;
    public static final int MAX_SALARY=100000;
    public static final int DEPARTMENT_ID=1;
    public static final int DEPARTMENT_ID2=2;
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE=new Employee(FIRST_NAME2,LAST_NAME2,SALARY,DEPARTMENT_ID2);
    public static final Employee  MAX_SALARY_EMPLOYEE  = new Employee(FIRST_NAME, LAST_NAME,MAX_SALARY,DEPARTMENT_ID);
    public static final Employee  MIN_SALARY_EMPLOYEE  = new Employee(FIRST_NAME2, LAST_NAME2,SALARY,DEPARTMENT_ID);
public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES= List.of(MAX_SALARY_EMPLOYEE,DIFFERENT_DEPARTMENT_EMPLOYEE);
public static final Map<Integer,List<Employee>> EMPLOYEES_BY_DEPARTMENTS_MAP=DIFFERENT_DEPARTMENT_EMPLOYEES.stream().
        collect(groupingBy(Employee::getDepartmentId));
}
