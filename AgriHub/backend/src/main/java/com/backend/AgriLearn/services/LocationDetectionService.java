package com.backend.AgriLearn.services;

import com.backend.AgriLearn.entities.Location;
import com.backend.AgriLearn.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationDetectionService {
    private final LocationRepository locationRepository;

    public LocationDetectionService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public String detectUserLocation(){
//        ToDo
        return "Gauteng South Africa";
    }

    public Optional<Location> getLocationById(Long locationId){
        return locationRepository.findById(locationId);
    }

    public Iterable<Location> getAllLocations(){
        return locationRepository.findAll();
    }
}
