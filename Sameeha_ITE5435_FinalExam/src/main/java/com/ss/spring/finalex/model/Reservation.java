package com.ss.spring.finalex.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;

    @NotBlank(message = "Reservation code is required")
    private String reservationCode;

    @NotBlank(message = "Flight number is required")
    private String flightNo;

    @NotNull(message = "Travel date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate travelDate;


    @NotNull(message = "Total amount is required")
    private BigDecimal totalAmount;

    @Valid
    @NotNull(message = "Customer details are required")
    private Customer customer;

    @Valid
    @NotNull(message = "Payment details are required")
    private Payment payment;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getReservationCode() { return reservationCode; }
    public void setReservationCode(String reservationCode) { this.reservationCode = reservationCode; }
    public String getFlightNo() { return flightNo; }
    public void setFlightNo(String flightNo) { this.flightNo = flightNo; }
    public LocalDate getTravelDate() { return travelDate; }
    public void setTravelDate(LocalDate travelDate) { this.travelDate = travelDate; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}