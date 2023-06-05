package prosky.homework212.service.Impl;

import org.springframework.stereotype.Service;
import prosky.homework212.exception.InvalidEmployeeDateException;
import prosky.homework212.service.EmployeeValidationService;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (isBlank(name) || !isAlpha(name)) {
            throw new InvalidEmployeeDateException("Некорректное значение имени " + name);
        }
    }
}
