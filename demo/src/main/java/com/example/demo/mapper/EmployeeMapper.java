package com.example.demo.mapper;

import com.example.demo.model.entity.employee.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper implements IMapper{

//    @Mapping(ignore = true, target = "id")
//    public abstract Employee toEmployee(Employee);
}
