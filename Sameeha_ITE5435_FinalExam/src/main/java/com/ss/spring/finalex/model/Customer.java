package com.ss.spring.finalex.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {
    @NotBlank(message = "Customer name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}