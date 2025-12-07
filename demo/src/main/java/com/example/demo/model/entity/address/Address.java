package com.example.demo.model.entity.address;

import com.example.demo.model.entity.base.BaseCoreEntity;
import com.example.demo.model.entity.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseCoreEntity {
    private String street;
    private String city;
    private String country;

    @ManyToOne // This will create employee_id foreign key in Address table.
    @JoinColumn(name = "employee_id")
    @ToString.Exclude // To prevent infinite loop for employee.toString()
    private Employee employee;
}
