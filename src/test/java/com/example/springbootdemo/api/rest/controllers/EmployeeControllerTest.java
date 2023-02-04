package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.BankingDetails;
import com.example.springbootdemo.api.entity.Department;
import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.entity.Project;
import com.example.springbootdemo.api.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService mockService;

    @Test
    void testFindAll() throws Exception {
        // Setup
        // Configure EmployeeService.findAll(...).
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("surname");
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
        final List<Employee> employees = List.of(employee);
        when(mockService.findAll()).thenReturn(employees);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/rest/api/employee/path")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testFindAll_EmployeeServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockService.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/rest/api/employee/path")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    @WithMockUser(username="admin")
    void testSave() throws Exception {
        // Setup
        // Configure EmployeeService.save(...).
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("surname");
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
        when(mockService.save(employee)).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/rest/api/employee/path")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testUpdate() throws Exception {
        // Setup
        // Configure EmployeeService.update(...).
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("surname");
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
        when(mockService.update(new Employee(), 0)).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/rest/api/employee/{id}", 0)
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testFindById() throws Exception {
        // Setup
        // Configure EmployeeService.findByID(...).
        final Employee employee = new Employee();
        employee.setId(0);
        employee.setName("name");
        employee.setSurname("surname");
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
        when(mockService.findByID(0)).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/rest/api/employee/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testFindById_EmployeeServiceThrowsException() throws Exception {
        // Setup
        when(mockService.findByID(0)).thenThrow(Exception.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/rest/api/employee/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeletePersonByID() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/rest/api/employee/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockService).deleteById(0);
    }

    @Test
    void testDeletePersonByID_ThrowsException() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/rest/api/employee/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockService).deleteById(0);
    }

    private static List<Employee> createNewEmployee() {
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
        department.setCode("67");
        // department.setEmployees(Set.of(new Employee()));
        employee.setDepartment(department);
        final Project project = new Project();
        project.setId(1);
        project.setName("Project1");
        project.setCode("p-001");
        employee.setProjects(Set.of(project));
        final List<Employee> employees = List.of(employee);
        return employees;
    }
}
