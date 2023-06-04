package prosky.homework212.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prosky.homework212.model.Employee;
import prosky.homework212.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }
    @GetMapping(value="/all", params={"departmentId"})
    public Collection<Employee> findEmployeesByDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return departmentService.findEmployeesByDepartment();
    }
}