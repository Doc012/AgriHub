package com.backend.AgriLearn.controllers;

import com.backend.AgriLearn.dtos.LocationDTO;
import com.backend.AgriLearn.entities.Location;
import com.backend.AgriLearn.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Create a new location
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody LocationDTO locationDTO) {
        Location createdLocation = locationService.createLocation(locationDTO);
        return ResponseEntity.ok(createdLocation);
    }

    // Get all locations
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    // Get a location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") int id) {
        return locationService.getLocationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a location
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable("id") int id, @RequestBody LocationDTO locationDTO) {
        try {
            Location updatedLocation = locationService.updateLocation(id, locationDTO);
            return ResponseEntity.ok(updatedLocation);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a location
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") int id) {
        try {
            locationService.deleteLocation(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
