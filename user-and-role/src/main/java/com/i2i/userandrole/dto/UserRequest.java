package com.i2i.userandrole.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserRequest {

    @NonNull
    private String username;

    @NonNull
    private String name;

    @NonNull
    private String password;
}
