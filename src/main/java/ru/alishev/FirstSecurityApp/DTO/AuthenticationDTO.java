package ru.alishev.FirstSecurityApp.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationDTO {
    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 30, message = "Name should be have between 2 and 30 characters")
    private String username;
    @NotEmpty(message = "Name should be not empty")

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
