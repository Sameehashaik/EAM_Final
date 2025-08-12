package com.ss.spring.finalex.Service;


import com.ss.spring.finalex.model.Reservation;
import com.ss.spring.finalex.repository.ReservationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository repo;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public ReservationService(ReservationRepository repo, ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.repo = repo;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }
    

    // Basic CRUD
    public Reservation create(Reservation r) { return repo.save(r); }
    public List<Reservation> findAll() { return repo.findAll(); }
    public Optional<Reservation> findById(String id) { return repo.findById(id); }
    public Optional<Reservation> update(String id, Reservation incoming) {
        return repo.findById(id).map(existing -> {
            existing.setReservationCode(incoming.getReservationCode());
            existing.setFlightNo(incoming.getFlightNo());
            existing.setTravelDate(incoming.getTravelDate());
            existing.setTotalAmount(incoming.getTotalAmount());
            existing.setCustomer(incoming.getCustomer());
            existing.setPayment(incoming.getPayment());
            return repo.save(existing);
        });
    }

    // ===== Jackson demonstrations =====
    // 1) Serialize to JSON (for UI "Next" button proof)
    public String toPrettyJson(Object o) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }


    // 2) Deserialize from a STATIC JSON sample (exam requirement option)
    public Reservation fromStaticJson(String json) throws IOException {
        return objectMapper.readValue(json, Reservation.class);
    }

    // 3) Deserialize from a DYNAMIC URI returning JSON (exam requirement option)
    public Reservation fromUriJson(String uri) throws IOException {
        String json = restTemplate.getForObject(uri, String.class);
        return objectMapper.readValue(json, Reservation.class);
    }
}