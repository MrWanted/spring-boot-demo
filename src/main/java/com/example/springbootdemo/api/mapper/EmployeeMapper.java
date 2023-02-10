package com.example.springbootdemo.api.mapper;

import com.example.springbootdemo.api.dto.EmployeeDTO;
import com.example.springbootdemo.api.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    EmployeeDTO mapToEmployeeDto(Employee employee);
    Employee mapToEmployee(EmployeeDTO employeeDTO);
}
