package com.example.demo.model.entity.department;

import com.example.demo.model.entity.base.BaseCoreEntity;
import com.example.demo.model.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Department extends BaseCoreEntity {
    private String departmentName;
    private String block;

    @ManyToMany
    @JoinTable(
            name = "department_employee",  // Name of the join table
            joinColumns = @JoinColumn(name = "employee_id") // Name of the employee foreign_key
    )
    @ToString.Exclude
    private List<Employee> employeeList;

}
