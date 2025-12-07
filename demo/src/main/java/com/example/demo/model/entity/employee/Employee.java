package com.example.demo.model.entity.employee;

import com.example.demo.model.entity.address.Address;
import com.example.demo.model.entity.base.BaseCoreEntity;
import com.example.demo.model.entity.department.Department;
import com.example.demo.model.entity.laptop.Laptop;
import com.example.demo.model.type.AccountStatus;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "employee",
        schema = "public"
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee extends BaseCoreEntity {
    @Column
    @NotNull
    private String firstName;

    @Column
    private String lastName;

    @NotNull
    @Column(length = 255, unique = true)
    private String email;

    @Column(name = "phone_number", length = 20, unique = true)
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    @NotNull // at application level object filed should be not null
    @Column(nullable = false) // at database level field should be not null
    private AccountStatus status = AccountStatus.ACTIVE;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL) // Any operation on employee will affect Laptop
    // It says do not create laptop_id as foreign key in this table.
    // b/c in Laptop field employee will maintain employee_id.
    // Note: Still the mapping is bidirectional b/w Employee & Laptop.
    // In short to maintain foreign key no need to create 2 foreign key in 2 table.
    private Laptop laptop;

    // @OneToMany // This will create a new table named employee_address_list
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) // This will not create separate table to maintain the foreign key
    private List<Address> addressList;
    // cascade.all means any operation performed on Employee will affect Department

    @ManyToMany(mappedBy = "employeeList")
    private List<Department> departmentList;

}
// Note: We can skip to specify @OneToMany, @ManyToMany, @ManyToOne in the Employee table, if we want unidirectional mapping.
// If we do so then we can Save Address, Department, ... at time of adding those.
// And we will need AddressRepository, DepartmentRepository....