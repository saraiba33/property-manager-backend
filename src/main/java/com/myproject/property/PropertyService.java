package com.myproject.property;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Iterable<Property> list() {
        return propertyRepository.findAll();
    }

    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }

    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    public Optional<Property> update(Property property) {
        Optional<Property> foundProperty = propertyRepository.findById(property.getId());

        if (foundProperty.isPresent()) {
            Property updatedProperty = foundProperty.get();
            updatedProperty.setImage(property.getImage());
            updatedProperty.setAddress(property.getAddress());
            updatedProperty.setStatus(property.getStatus());
            updatedProperty.setEndDate(property.getEndDate());

            propertyRepository.save(updatedProperty);
            return Optional.of(updatedProperty);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }
}