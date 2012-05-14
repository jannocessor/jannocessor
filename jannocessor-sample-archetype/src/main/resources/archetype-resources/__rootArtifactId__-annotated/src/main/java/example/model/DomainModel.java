package example.model;

import java.util.Date;
import java.util.List;

import org.jannocessor.extra.annotation.GenerateBean;
import org.jannocessor.extra.annotation.GenerateBuilder;
import org.jannocessor.extra.annotation.GenerateDAO;
import org.jannocessor.extra.annotation.GenerateDTO;
import org.jannocessor.extra.annotation.GenerateMapper;

public class DomainModel {

	@GenerateBean
	@GenerateBuilder
	@GenerateDAO
	@GenerateDTO
	@GenerateMapper
	class Employee {
		String firstName;
		String lastName;
		int salary;
		Date birthdate;
		Department department;
	}

	@GenerateBean
	@GenerateBuilder
	@GenerateDAO
	@GenerateDTO
	@GenerateMapper
	class Department {
		String name;
		List<Employee> employees;
	}

}
