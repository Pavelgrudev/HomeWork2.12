package prosky.homework212.service.Impl;

import org.junit.jupiter.api.Test;
import prosky.homework212.exception.EmployeeAlreadyAddedException;
import prosky.homework212.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static prosky.homework212.service.Impl.EmployeeTestConstans.*;

class EmployeeServiceImplTest  {
private final EmployeeValidationServiceImpl validationService=new EmployeeValidationServiceImpl();
private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);
    @Test
public void shouldAddEmployee(){
    Employee employee = new Employee(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
    assertFalse(employeeService.findAll().contains(employee));
    assertEquals(0, employeeService.findAll().size());

    Employee addedEmployee = employeeService.add(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
    assertEquals(employee,addedEmployee);
    assertEquals(1, employeeService.findAll().size());
    assertTrue(employeeService.findAll().contains(employee));
}
@Test
    public void shouldThrowEmployeeAlreadyAddedException(){
    Employee employee = employeeService.add(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
    assertTrue(employeeService.findAll().contains(employee));
assertThrows(EmployeeAlreadyAddedException.class,()->employeeService.add(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID));
}
@Test
    public void shouldFindExistEmployee(){
        Employee employee=employeeService.add(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
        assertEquals(employee,employeeService.find(FIRST_NAME,LAST_NAME));

}
@Test
public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployee(){
    assertEquals(0, employeeService.findAll().size());
    assertThrows(EmployeeAlreadyAddedException.class,
            ()->employeeService.add(FIRST_NAME,LAST_NAME));
}
@Test
public void shouldRemoveExistsEmployee(){
    Employee addedEmployee = employeeService.add(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
    assertEquals(1, employeeService.findAll().size());
    assertTrue(employeeService.findAll().contains(addedEmployee));

        Employee removedEmployee= employeeService.remove(FIRST_NAME,LAST_NAME);{
        assertEquals(addedEmployee,removedEmployee);
        assertEquals(0 ,employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(addedEmployee));}
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployee(){
        assertEquals(0, employeeService.findAll().size());
        assertThrows(EmployeeAlreadyAddedException.class,
                ()->employeeService.remove(FIRST_NAME,LAST_NAME));
    }
@Test
public void shouldReturnAllEmployees(){
Employee employee1 = employeeService.add(FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID);
Employee employee2 = employeeService.add(FIRST_NAME2,LAST_NAME2,SALARY,DEPARTMENT_ID);
Collection<Employee> addadEmployees = employeeService.findAll();
assertIterableEquals(List.of(employee1, employee2),addadEmployees); }



    }
