package com.example.demo.repo.dapartment;

import com.example.demo.model.entity.department.Department;
import com.example.demo.repo.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends BaseRepository<Department, UUID> {
}
