package com.example.TrainBooking.service;

import com.example.TrainBooking.model.Train;
import com.example.TrainBooking.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public List<Train> searchTrains(String source, String destination) {
        return trainRepository.findBySourceContainingIgnoreCaseAndDestinationContainingIgnoreCase(source, destination);
    }
}
