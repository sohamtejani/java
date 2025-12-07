package com.example.demo.model.entity.laptop;

import com.example.demo.model.entity.base.BaseCoreEntity;
import com.example.demo.model.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop extends BaseCoreEntity {
    @Column
    @NotNull
    private String laptopName;

    @Column
    private String description;

    @Column
    private double price;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @ToString.Exclude // To prevent infinite loop for employee.toString()
    private Employee employee;
}
