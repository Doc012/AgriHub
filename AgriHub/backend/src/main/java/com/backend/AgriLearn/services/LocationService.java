package com.backend.AgriLearn.services;


import com.backend.AgriLearn.dtos.LocationDTO;
import com.backend.AgriLearn.entities.Location;
import com.backend.AgriLearn.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Create a new location
    public Location createLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setProvince(locationDTO.getProvince());
        location.setDistrict(locationDTO.getDistrict());
        location.setPicUrl(locationDTO.getPicUrl());
        return locationRepository.save(location);
    }

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Retrieve a location by ID
    public Optional<Location> getLocationById(int locationID) {
        return locationRepository.findById(locationID);
    }

    // Update an existing location
    public Location updateLocation(int locationID, LocationDTO locationDTO) {
        Optional<Location> existingLocation = locationRepository.findById(locationID);
        if (existingLocation.isPresent()) {
            Location location = existingLocation.get();
            location.setProvince(locationDTO.getProvince());
            location.setDistrict(locationDTO.getDistrict());
            location.setPicUrl(locationDTO.getPicUrl());
            return locationRepository.save(location);
        } else {
            throw new RuntimeException("Location not found with ID " + locationID);
        }
    }

    // Delete a location
    public void deleteLocation(int locationID) {
        if (locationRepository.existsById(locationID)) {
            locationRepository.deleteById(locationID);
        } else {
            throw new RuntimeException("Location not found with ID " + locationID);
        }

    }
}
