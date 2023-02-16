package com.example.springbootdemo.api.jpa;

import com.example.springbootdemo.api.entity.BankingDetails;
import com.example.springbootdemo.api.entity.Department;
import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.entity.Project;
import com.example.springbootdemo.api.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    private EmployeeRepository repository;

    public EmployeeRepositoryTest(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Test
    public void testFindById() {
        Employee employee = createNewEmployee();
        repository.save(employee);

        Optional<Employee> foundEmployee = repository.findById(1);
        assertThat(foundEmployee).isNotNull();
        assertThat("lepota").isEqualTo(foundEmployee.get().getSurname());
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
}
