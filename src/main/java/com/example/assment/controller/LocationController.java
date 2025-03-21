
package com.example.assment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assment.model.MergedLocation;
import com.example.assment.service.LocationService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LocationController {
   
	 private final LocationService locationService;

	    public LocationController(LocationService locationService) {
	        this.locationService = locationService;
	    }

	    @GetMapping("/merged")
	    public List<MergedLocation> getMergedData() throws IOException {
	        return locationService.mergeData();
	    }

	    @GetMapping("/valid-count")
	    public Map<String, Long> getValidCount() throws IOException {
	        return locationService.countValidPoints();
	    }

	    @GetMapping("/average-rating")
	    public Map<String, Double> getAverageRating() throws IOException {
	        return locationService.calculateAverageRating();
	    }

	    @GetMapping("/most-reviews")
	    public Optional<MergedLocation> getMostReviewedLocation() throws IOException {
	        return locationService.locationWithMostReviews();
	    }

	    @GetMapping("/incomplete")
	    public List<MergedLocation> getIncompleteData() throws IOException {
	        return locationService.findIncompleteData();
	    }
}
