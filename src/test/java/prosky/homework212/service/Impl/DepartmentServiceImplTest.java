package prosky.homework212.service.Impl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prosky.homework212.exception.EmployeeNotFoundException;
import prosky.homework212.service.EmployeeService;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static prosky.homework212.service.Impl.EmployeeTestConstans.*;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByDepartmentId(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                ()-> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMaxSalaryByOtherDepartmentId(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMixSalaryByDepartmentId(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                ()-> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMinSalaryByOtherDepartmentId(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }
    @Test
    public void shouldFindEmployeeByDepartmentId(){
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(singletonList(MAX_SALARY_EMPLOYEE), departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE), departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID2));
    }
    @Test
public void shouldReturnEmptyEmployeesMyByDepartments(){
        when(employeeService.findAll()).thenReturn(emptyList());
        assertEquals(emptyMap(),departmentService.findEmployeesByDepartment());
}
    @Test
    public void shouldReturnNotEmptyEmployeesMyByDepartments(){
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEES_BY_DEPARTMENTS_MAP,departmentService.findEmployeesByDepartment());
    }



}