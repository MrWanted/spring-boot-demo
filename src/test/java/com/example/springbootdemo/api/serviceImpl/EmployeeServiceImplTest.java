package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.BankingDetails;
import com.example.springbootdemo.api.entity.Department;
import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.entity.Project;
import com.example.springbootdemo.api.exception.PersonNotFoundExeption;
import com.example.springbootdemo.api.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository mockRepository;

    private EmployeeServiceImpl employeeServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        employeeServiceImplUnderTest = new EmployeeServiceImpl(mockRepository);
    }

    @Test
    void testSave() {
        // Setup
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("name");
        final BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setId(0);
        bankingDetails.setAccountNumber("accountNumber");
        bankingDetails.setBankName("bankName");
        bankingDetails.setBranchCode("branchCode");
        bankingDetails.setAccountType("accountType");
        employee.setBankingDetails(bankingDetails);
        final Department department = new Department();
        department.setId(0);
        department.setName("name");
        department.setCode("code");
        department.setEmployees(Set.of(new Employee()));
        employee.setDepartment(department);
        final Project project = new Project();
        employee.setProjects(Set.of(project));

        final Employee expectedResult = new Employee();
        expectedResult.setId(0);
        expectedResult.setName("name");
        expectedResult.setSurname("name");
        final BankingDetails bankingDetails1 = new BankingDetails();
        bankingDetails1.setId(0);
        bankingDetails1.setAccountNumber("accountNumber");
        bankingDetails1.setBankName("bankName");
        bankingDetails1.setBranchCode("branchCode");
        bankingDetails1.setAccountType("accountType");
        expectedResult.setBankingDetails(bankingDetails1);
        final Department department1 = new Department();
        department1.setId(0);
        department1.setName("name");
        department1.setCode("code");
        department1.setEmployees(Set.of(new Employee()));
        expectedResult.setDepartment(department1);
        final Project project1 = new Project();
        expectedResult.setProjects(Set.of(project1));

        // Configure EmployeeRepository.save(...).
        final Employee employee1 = new Employee();
        employee1.setId(0);
        employee1.setName("name");
        employee1.setSurname("name");
        final BankingDetails bankingDetails2 = new BankingDetails();
        bankingDetails2.setId(0);
        bankingDetails2.setAccountNumber("accountNumber");
        bankingDetails2.setBankName("bankName");
        bankingDetails2.setBranchCode("branchCode");
        bankingDetails2.setAccountType("accountType");
        employee1.setBankingDetails(bankingDetails2);
        final Department department2 = new Department();
        department2.setId(0);
        department2.setName("name");
        department2.setCode("code");
        department2.setEmployees(Set.of(new Employee()));
        employee1.setDepartment(department2);
        final Project project2 = new Project();
        employee1.setProjects(Set.of(project2));
        when(mockRepository.save(new Employee())).thenReturn(employee1);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.save(employee);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdate() {
        // Setup
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("name");
        final BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setId(0);
        bankingDetails.setAccountNumber("accountNumber");
        bankingDetails.setBankName("bankName");
        bankingDetails.setBranchCode("branchCode");
        bankingDetails.setAccountType("accountType");
        employee.setBankingDetails(bankingDetails);
        final Department department = new Department();
        department.setId(0);
        department.setName("name");
        department.setCode("code");
        //department.setEmployees(Set.of(new Employee()));
        employee.setDepartment(department);
        final Project project = new Project();
        employee.setProjects(Set.of(project));

        final Employee expectedResult = new Employee();
        expectedResult.setId(0);
        expectedResult.setName("name");
        expectedResult.setSurname("name");
        final BankingDetails bankingDetails1 = new BankingDetails();
        bankingDetails1.setId(0);
        bankingDetails1.setAccountNumber("accountNumber");
        bankingDetails1.setBankName("bankName");
        bankingDetails1.setBranchCode("branchCode");
        bankingDetails1.setAccountType("accountType");
        expectedResult.setBankingDetails(bankingDetails1);
        final Department department1 = new Department();
        department1.setId(0);
        department1.setName("name");
        department1.setCode("code");
        department1.setEmployees(Set.of(new Employee()));
        expectedResult.setDepartment(department1);
        final Project project1 = new Project();
        expectedResult.setProjects(Set.of(project1));

        // Configure EmployeeRepository.findById(...).
        final Employee employee2 = new Employee();
        employee2.setId(0);
        employee2.setName("name");
        employee2.setSurname("name");
        final BankingDetails bankingDetails2 = new BankingDetails();
        bankingDetails2.setId(0);
        bankingDetails2.setAccountNumber("accountNumber");
        bankingDetails2.setBankName("bankName");
        bankingDetails2.setBranchCode("branchCode");
        bankingDetails2.setAccountType("accountType");
        employee2.setBankingDetails(bankingDetails2);
        final Department department2 = new Department();
        department2.setId(0);
        department2.setName("name");
        department2.setCode("code");
        //department2.setEmployees(Set.of(new Employee()));
        employee2.setDepartment(department2);
        final Project project2 = new Project();
        employee2.setProjects(Set.of(project2));
        final Optional<Employee> employee1 = Optional.of(employee2);
        when(mockRepository.findById(0)).thenReturn(employee1);

        // Configure EmployeeRepository.save(...).
        final Employee employee3 = new Employee();
        employee3.setId(0);
        employee3.setName("name");
        employee3.setSurname("name");
        final BankingDetails bankingDetails3 = new BankingDetails();
        bankingDetails3.setId(0);
        bankingDetails3.setAccountNumber("accountNumber");
        bankingDetails3.setBankName("bankName");
        bankingDetails3.setBranchCode("branchCode");
        bankingDetails3.setAccountType("accountType");
        employee3.setBankingDetails(bankingDetails3);
        final Department department3 = new Department();
        department3.setId(0);
        department3.setName("name");
        department3.setCode("code");
        //department3.setEmployees(Set.of(new Employee()));
        employee3.setDepartment(department3);
        final Project project3 = new Project();
        employee3.setProjects(Set.of(project3));
        when(mockRepository.save(new Employee())).thenReturn(employee3);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.update(employee, 0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdate_EmployeeRepositoryFindByIdReturnsAbsent() {
        // Setup
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("name");
        final BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setId(0);
        bankingDetails.setAccountNumber("accountNumber");
        bankingDetails.setBankName("bankName");
        bankingDetails.setBranchCode("branchCode");
        bankingDetails.setAccountType("accountType");
        employee.setBankingDetails(bankingDetails);
        final Department department = new Department();
        department.setId(0);
        department.setName("name");
        department.setCode("code");
        department.setEmployees(Set.of(new Employee()));
        employee.setDepartment(department);
        final Project project = new Project();
        employee.setProjects(Set.of(project));

        final Employee expectedResult = new Employee();
        expectedResult.setId(0);
        expectedResult.setName("name");
        expectedResult.setSurname("name");
        final BankingDetails bankingDetails1 = new BankingDetails();
        bankingDetails1.setId(0);
        bankingDetails1.setAccountNumber("accountNumber");
        bankingDetails1.setBankName("bankName");
        bankingDetails1.setBranchCode("branchCode");
        bankingDetails1.setAccountType("accountType");
        expectedResult.setBankingDetails(bankingDetails1);
        final Department department1 = new Department();
        department1.setId(0);
        department1.setName("name");
        department1.setCode("code");
        department1.setEmployees(Set.of(new Employee()));
        expectedResult.setDepartment(department1);
        final Project project1 = new Project();
        expectedResult.setProjects(Set.of(project1));

        when(mockRepository.findById(0)).thenReturn(Optional.empty());

        // Configure EmployeeRepository.save(...).
        final Employee employee1 = new Employee();
        employee1.setId(0);
        employee1.setName("name");
        employee1.setSurname("name");
        final BankingDetails bankingDetails2 = new BankingDetails();
        bankingDetails2.setId(0);
        bankingDetails2.setAccountNumber("accountNumber");
        bankingDetails2.setBankName("bankName");
        bankingDetails2.setBranchCode("branchCode");
        bankingDetails2.setAccountType("accountType");
        employee1.setBankingDetails(bankingDetails2);
        final Department department2 = new Department();
        department2.setId(0);
        department2.setName("name");
        department2.setCode("code");
        department2.setEmployees(Set.of(new Employee()));
        employee1.setDepartment(department2);
        final Project project2 = new Project();
        employee1.setProjects(Set.of(project2));
        when(mockRepository.save(new Employee())).thenReturn(employee1);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.update(employee, 0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testFindAll() {
        final Employee employee = new Employee();
        employee.setId(1);
        employee.setName("wanted");
        employee.setSurname("lepota");

        final BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setId(1);
        bankingDetails.setAccountNumber("62123");
        bankingDetails.setBankName("fnb");
        bankingDetails.setBranchCode("25065");
        bankingDetails.setAccountType("cheque");
        employee.setBankingDetails(bankingDetails);

        final Department department = new Department();
        department.setId(1);
        department.setName("fgz");
        department.setCode("64");
        employee.setDepartment(department);

        final Project project = new Project();
        project.setId(1);
        project.setName("new project");
        project.setCode("p-001");
        employee.setProjects(Set.of(project));

        final List<Employee> expectedResult = List.of(employee);

        // Configure EmployeeRepository.findAll(...).
        final Employee employee1 = createNewEmployee();
        final List<Employee> employees = List.of(employee1);
        when(mockRepository.findAll()).thenReturn(employees);

        // Run the test
        final List<Employee> result = employeeServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testFindAll_EmployeeRepositoryReturnsNoItems() {
        // Setup
        when(mockRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Employee> result = employeeServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFindByID() {
        // Setup
        final Employee expectedResult = new Employee();
        expectedResult.setId(1);
        expectedResult.setName("wanted");
        expectedResult.setSurname("lepota");
        final BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setId(1);
        bankingDetails.setAccountNumber("62123");
        bankingDetails.setBankName("fnb");
        bankingDetails.setBranchCode("25065");
        bankingDetails.setAccountType("cheque");
        expectedResult.setBankingDetails(bankingDetails);
        final Department department = new Department();
        department.setId(1);
        department.setName("fgz");
        department.setCode("64");
        //department.setEmployees(Set.of(new Employee()));
        expectedResult.setDepartment(department);
        final Project project = new Project();
        project.setId(1);
        project.setCode("p-001");
        project.setName("new project");
        expectedResult.setProjects(Set.of(project));

        // Configure EmployeeRepository.findById(...).
        final Employee employee1 = createNewEmployee();
        final Optional<Employee> employee = Optional.of(employee1);
        when(mockRepository.findById(1)).thenReturn(employee);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.findByID(1);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
        assertThat(result.getName()).isEqualTo("wanted");
        verify(mockRepository, times(1)).findById(1);
    }

    private static Employee createNewEmployee() {

        final BankingDetails bankingDetails1 = new BankingDetails();
        bankingDetails1.setId(1);
        bankingDetails1.setAccountNumber("62123");
        bankingDetails1.setBankName("fnb");
        bankingDetails1.setBranchCode("25065");
        bankingDetails1.setAccountType("cheque");

        final Department department1 = new Department();
        department1.setId(1);
        department1.setName("fgz");
        department1.setCode("64");

        final Project project = new Project();
        project.setId(1);
        project.setCode("p-001");
        project.setName("new project");

        final Employee employee = Employee.builder()
                .id(1)
                .name("wanted")
                .surname("lepota")
                .department(department1)
                .projects(Set.of(project))
                .bankingDetails(bankingDetails1)
                .build();

        return employee;
    }

    @Test
    void testFindByID_EmployeeRepositoryReturnsAbsent() {
        // Setup
        when(mockRepository.findById(0)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> employeeServiceImplUnderTest.findByID(0)).isInstanceOf(PersonNotFoundExeption.class);
    }

    @Test
    void testDeleteById() {
        // Setup
        Employee newEmployee = createNewEmployee();
        final Optional<Employee> employee = Optional.of(newEmployee);
        when(mockRepository.findById(1)).thenReturn(employee);

        // Run the test
        employeeServiceImplUnderTest.deleteById(1);

        // Verify the results
        verify(mockRepository).deleteById(1);
    }
    @Test
    void testDeleteById_EmployeeRepositoryFindByIdReturnsAbsent() {
        // Setup
        when(mockRepository.findById(0)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> employeeServiceImplUnderTest.deleteById(0)).isInstanceOf(PersonNotFoundExeption.class);
    }
}
