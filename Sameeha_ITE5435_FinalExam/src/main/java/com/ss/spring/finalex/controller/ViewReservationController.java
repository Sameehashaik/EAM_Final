package com.ss.spring.finalex.controller;


import com.ss.spring.finalex.model.Customer;
import com.ss.spring.finalex.model.Payment;
import com.ss.spring.finalex.model.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ss.spring.finalex.Service.ReservationService;

import jakarta.validation.Valid;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/reservations")
public class ViewReservationController {

    private static final Logger log = LoggerFactory.getLogger(ViewReservationController.class);
    private final ReservationService service;

    public ViewReservationController(ReservationService service) { this.service = service; }

    @GetMapping("/new")
    public String newForm(Model model) {
        var r = new Reservation();
        r.setCustomer(new Customer());
        r.setPayment(new Payment());
        model.addAttribute("reservation", r);
        return "reservation-form";
    }
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("reservations", service.findAll());
        return "reservations-list";
    }


    // The "Next" button posts here; we convert to JSON (Jackson) and persist
    @PostMapping("/next")
    public String next(@Valid @ModelAttribute("reservation") Reservation reservation,
                       BindingResult br, Model model) throws JsonProcessingException {
        if (br.hasErrors()) return "reservation-form";

        Reservation saved = service.create(reservation);
        String json = service.toPrettyJson(saved);   // <-- pretty JSON of SAVED object

        model.addAttribute("saved", saved);
        model.addAttribute("json", json);
        return "reservation-success";
    }

}
