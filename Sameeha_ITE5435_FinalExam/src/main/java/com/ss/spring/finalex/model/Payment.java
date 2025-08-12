package com.ss.spring.finalex.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Payment {
    @NotBlank(message = "Payment method is required")
    private String method;

    @NotNull(message = "Payment amount is required")
    private BigDecimal amount;

    @NotBlank(message = "Payment status is required")
    private String status; 

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}