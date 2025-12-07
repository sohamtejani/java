package com.example.demo;

import com.example.demo.model.entity.address.Address;
import com.example.demo.model.entity.department.Department;
import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.laptop.Laptop;
import com.example.demo.model.type.AccountStatus;
import com.example.demo.repo.dapartment.DepartmentRepository;
import com.example.demo.repo.user.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public  void run(String ...args){
		
		/* One to One */
		/*
		Employee employee = new Employee();
		employee.setEmail("abc@gmail.com");
		employee.setStatus(AccountStatus.ACTIVE);
		employee.setFirstName("abc");
		employee.setLastName("tejani");
		employee.setPhoneNo("123456789101");

		Laptop laptop = new Laptop();
		laptop.setLaptopName("HP Zbook");
		laptop.setDescription("32 gb ram, 512 gb ssd, still slow laptop");
		laptop.setPrice(70000);
		laptop.setEmployee(employee);

		employee.setLaptop(laptop); // important

		Employee employee1 = employeeRepository.save(employee);
		log.info("Save Employee: {}", employee1.toString());

		List<Employee> employee2 = employeeRepository.findByFirstName("abc");

		log.info("Find Employee by firstName 'Veer': {}", employee2.toString());
		*/

		/*One to Many*/

		/*

		Employee employee = new Employee();
		employee.setEmail("def@gmail.com");
		employee.setStatus(AccountStatus.ACTIVE);
		employee.setFirstName("def");
		employee.setLastName("def");
		employee.setPhoneNo("2332323");

		Laptop laptop = new Laptop();
		laptop.setLaptopName("HP Zbook");
		laptop.setDescription("32 gb ram, 512 gb ssd, still slow laptop");
		laptop.setPrice(70000);
		laptop.setEmployee(employee);// need to set it, otherwise employee_id will be null in Laptop.

		employee.setLaptop(laptop); // important


		Address addrees1 = new Address();
		addrees1.setCity("Surat");
		addrees1.setStreet("area1");
		addrees1.setEmployee(employee); // need to set it, otherwise employee_id will be null in Address.

		Address address2 = new Address();
		address2.setCity("Bhavnagar");
		address2.setStreet("area2");
		address2.setEmployee(employee); // need to set it, otherwise employee_id will be null in Address.

		employee.setAddressList(List.of(addrees1, address2)); // Important

		Employee employee1 = employeeRepository.save(employee);
		log.info("Save Employee: {}", employee1.toString());


		*/

		/*Many to Many*/



		Employee employee = new Employee();
		employee.setEmail("abc@gmail.com");
		employee.setStatus(AccountStatus.ACTIVE);
		employee.setFirstName("abc");
		employee.setLastName("abc");
		employee.setPhoneNo("12345");

		Employee employee2 = new Employee();
		employee2.setEmail("def@gmail.com");
		employee2.setStatus(AccountStatus.ACTIVE);
		employee2.setFirstName("def");
		employee2.setLastName("def");
		employee2.setPhoneNo("67891");

		Laptop laptop = new Laptop();
		laptop.setLaptopName("HP Zbook");
		laptop.setDescription("32 gb ram, 512 gb ssd");
		laptop.setPrice(100000);
		laptop.setEmployee(employee);// need to set it, otherwise employee_id will be null in Laptop.

		employee.setLaptop(laptop); // Important

		Laptop laptop2 = new Laptop();
		laptop2.setLaptopName("Dell inspiron 5510");
		laptop2.setDescription("16 gb ram, 512 gb ssd");
		laptop2.setPrice(80000);
		laptop2.setEmployee(employee2);// need to set it, otherwise employee_id will be null in Laptop.

		employee2.setLaptop(laptop2); // important


		Address addrees1 = new Address();
		addrees1.setCity("Surat");
		addrees1.setStreet("area1");
		addrees1.setEmployee(employee); // need to set it, otherwise employee_id will be null in Address.

		Address address2 = new Address();
		address2.setCity("Bhavnagar");
		address2.setStreet("area2");
		address2.setEmployee(employee); // need to set it, otherwise employee_id will be null in Address.

		Address address3 = new Address();
		address3.setCity("Ahmedabad");
		address3.setStreet("area3");
		address3.setEmployee(employee2); // need to set it, otherwise employee_id will be null in Address.


		Department department1 = new Department();
		department1.setBlock("A");
		department1.setDepartmentName("Information Technology");
//		department1.setEmployeeList(List.of(employee));

//		employee.setDepartmentList(List.of(department1));

		Department department2 = new Department();
		department2.setBlock("B");
		department2.setDepartmentName("Research");
		department2.setEmployeeList(List.of(employee2));

//		employee2.setDepartmentList(List.of(department2));

		employee.setAddressList(List.of(addrees1, address2)); // Important
		employee2.setAddressList(List.of(address3)); // Important

		Employee employeeSaved1 = employeeRepository.save(employee);
		log.info("Save Employee 1: {}", employeeSaved1);

		Employee employeeSaved2 = employeeRepository.save(employee2);
		log.info("Save Employee 2: {}", employeeSaved2);

		Department department1Saved = departmentRepository.save(department1);
		log.info("Save Department 1: {}", department1Saved);

		Department department2Saved = departmentRepository.save(department2);
		log.info("Save Department 2: {}", department2Saved);
	}
}
