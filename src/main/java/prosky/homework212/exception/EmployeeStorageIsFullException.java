package prosky.homework212.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException  {
    public EmployeeStorageIsFullException() {
        super (" Максимальное Кол-во сотрудников ");
    }
}