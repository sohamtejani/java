package com.example.demo.repo.user;

import com.example.demo.model.entity.employee.Employee;
import com.example.demo.repo.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, UUID> {
    @Query("SELECT e from Employee e WHERE e.email = :email OR e.phoneNo = :phoneNo")
    List<Employee> findAllEmployeeByEmailOrPassword(@Param("email") String email, @Param("phoneNo") String phoneNo);

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
}
