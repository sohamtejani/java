package com.example.demo.model.dto.employee;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class BaseEmployeeDetailsDto {
    @NotNull
    private String email;

    @NotNull
    private String firstName;

    private String lastName;
}
