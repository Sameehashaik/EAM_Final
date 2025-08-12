package com.ss.spring.finalex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ss.spring.finalex.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> { }
