package com.example.TrainBooking.repository;

import com.example.TrainBooking.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    // Search trains by source and destination
    List<Train> findBySourceContainingIgnoreCaseAndDestinationContainingIgnoreCase(String source, String destination);
}
