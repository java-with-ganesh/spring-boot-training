package com.i2i.userandrole.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;
}
