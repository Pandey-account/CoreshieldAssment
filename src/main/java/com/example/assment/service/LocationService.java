
package com.example.assment.service;

import com.example.assment.model.Location;
import com.example.assment.model.MergedLocation;
import com.example.assment.model.Metadata;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

	private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Location> loadLocations() throws IOException {
        InputStream inputStream = new ClassPathResource("locations.json").getInputStream();
        return objectMapper.readValue(inputStream, new TypeReference<>() {});
    }

    public List<Metadata> loadMetadata() throws IOException {
        InputStream inputStream = new ClassPathResource("metadata.json").getInputStream();
        return objectMapper.readValue(inputStream, new TypeReference<>() {});
    }

    public List<MergedLocation> mergeData() throws IOException {
        List<Location> locations = loadLocations();
        List<Metadata> metadataList = loadMetadata();

        // Convert metadata list to a map for quick lookup
        Map<String, Metadata> metadataMap = metadataList.stream()
                .collect(Collectors.toMap(Metadata::getId, meta -> meta));

        // Merge the data
        return locations.stream()
                .map(loc -> {
                    Metadata meta = metadataMap.get(loc.getId());
                    MergedLocation merged = new MergedLocation();
                    merged.setId(loc.getId());
                    merged.setLatitude(loc.getLatitude());
                    merged.setLongitude(loc.getLongitude());

                    if (meta != null) {
                        merged.setType(meta.getType());
                        merged.setRating(meta.getRating());
                        merged.setReviews(meta.getReviews());
                    }
                    return merged;
                })
                .collect(Collectors.toList());
    }

    public Map<String, Long> countValidPoints() throws IOException {
        return mergeData().stream()
                .filter(loc -> loc.getType() != null)
                .collect(Collectors.groupingBy(MergedLocation::getType, Collectors.counting()));
    }

    public Map<String, Double> calculateAverageRating() throws IOException {
        return mergeData().stream()
                .filter(loc -> loc.getRating() != null)
                .collect(Collectors.groupingBy(
                        MergedLocation::getType,
                        Collectors.averagingDouble(MergedLocation::getRating)
                ));
    }

    public Optional<MergedLocation> locationWithMostReviews() throws IOException {
        return mergeData().stream()
                .filter(loc -> loc.getReviews() != null)
                .max((a, b) -> Integer.compare(a.getReviews(), b.getReviews()));
    }

    public List<MergedLocation> findIncompleteData() throws IOException {
        return mergeData().stream()
                .filter(loc -> loc.getType() == null || loc.getRating() == null || loc.getReviews() == null)
                .collect(Collectors.toList());
    }
}