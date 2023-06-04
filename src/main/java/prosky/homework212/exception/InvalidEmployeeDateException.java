package prosky.homework212.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDateException extends RuntimeException{

    public InvalidEmployeeDateException(String message) {
        super(message);
}
}