package ma.usf.examples.projectmanagement.controllers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ma.usf.examples.projectmanagement.entities.Employee;
import ma.usf.examples.projectmanagement.services.EmployeeService;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

	@Autowired
	EmployeeService EmployeeService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Entered validation method..");
		Employee employee = EmployeeService.findByEmail(value);

		return employee == null;
	}

}