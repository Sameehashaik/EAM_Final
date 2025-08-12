package com.ss.spring.finalex.controller;


import com.ss.spring.finalex.model.Customer;
import com.ss.spring.finalex.model.Payment;
import com.ss.spring.finalex.model.Reservation;
import com.ss.spring.finalex.Service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class RestReservationController {

    private final ReservationService service;

    public RestReservationController(ReservationService service) { this.service = service; }

    @GetMapping
    public List<Reservation> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> byId(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

@GetMapping("/import/sample")
public ResponseEntity<Reservation> importFromSample() throws IOException {
    // 1) Fetch JSON from your own sample endpoint
    String uri = "http://localhost:8080/api/reservations/sample";

    // 2) Jackson: deserialize JSON from the URI
    Reservation parsed = service.fromUriJson(uri);

    // 3) Save to MongoDB
    Reservation saved = service.create(parsed);

    // 4) Return 201 Created with Location header
    URI location = URI.create("/api/reservations/" + saved.getId());
    return ResponseEntity.created(location).body(saved);
}

    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody Reservation r) {
        Reservation saved = service.create(r);
        URI uri = URI.create("/api/reservations/" + saved.getId());
        return ResponseEntity.created(uri).body(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable String id, @Valid @RequestBody Reservation r) {
        return service.update(id, r)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // A sample endpoint that returns a Reservation JSON (handy for the dynamic-URI Jackson demo)
    @GetMapping("/sample")
    public Reservation sample() {
        Reservation r = new Reservation();
        r.setReservationCode("HA1234");
        r.setFlightNo("HA-789");
        r.setTravelDate(LocalDate.now().plusDays(10));
        r.setTotalAmount(new BigDecimal("350.00"));
        Customer c = new Customer();
        c.setName("Ava Lee"); c.setEmail("ava@example.com"); c.setPhone("555-0101");
        r.setCustomer(c);
        Payment p = new Payment();
        p.setMethod("VISA"); p.setAmount(new BigDecimal("350.00")); p.setStatus("PENDING");
        r.setPayment(p);
        return r;
    }
}