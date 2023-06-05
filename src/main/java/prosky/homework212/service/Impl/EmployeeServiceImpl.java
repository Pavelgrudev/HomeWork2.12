package prosky.homework212.service.Impl;
import org.springframework.stereotype.Service;
import prosky.homework212.exception.EmployeeAlreadyAddedException;
import prosky.homework212.exception.EmployeeNotFoundException;
import prosky.homework212.model.Employee;
import prosky.homework212.service.EmployeeService;
import prosky.homework212.service.EmployeeValidationService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeValidationService validationService;
    private final Map <String, Employee> employees;
    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;
        this.employees = new HashMap<>();
       /* add("Ivan","Ivanov");
        add("Semen","Semenov");
        add("Andrey","Andreev");
        add("Ilaa","Ilin");
        add("Aleksey","Alekseev");
        add("Sergey","Sergeev");
        add("Petr","Petrov");
        add("Egor","Egorov");*/
    }
    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        validationService.validate(firstName, lastName);
        return addEmployee(new Employee(capitalize(firstName),capitalize(lastName),salary, departmentId));}


    @Override
    public Employee add(String firstName, String lastName) {
        validationService.validate(firstName,lastName);
        Employee employee = new Employee(capitalize(firstName),capitalize(lastName));
        if (employees.containsKey(employee.getFullName()))
            throw new EmployeeAlreadyAddedException(employee);
        employees.put(employee.getFullName() ,employee);
        return employee;}
    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName()))
            throw new EmployeeNotFoundException(employee);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException(employee);}
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
    private Employee addEmployee(Employee employee){
        if(employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException(employee);
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }



}
