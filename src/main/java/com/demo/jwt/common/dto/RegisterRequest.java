package com.demo.jwt.common.dto;

import com.demo.jwt.persistence.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
