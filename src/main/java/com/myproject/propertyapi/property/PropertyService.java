package com.myproject.propertyapi.property;

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
            updatedProperty.setRentAmount(property.getRentAmount());
            updatedProperty.setTenant1(property.getTenant1());
            updatedProperty.setTenant1Contact(property.getTenant1Contact());
            updatedProperty.setTenant2(property.getTenant2());
            updatedProperty.setTenant2Contact(property.getTenant2Contact());
            updatedProperty.setEmergencyContact1(property.getEmergencyContact1());
            updatedProperty.setEmergencyNumber1(property.getEmergencyNumber1());
            updatedProperty.setEmergencyContact2(property.getEmergencyContact2());
            updatedProperty.setEmergencyNumber2(property.getEmergencyNumber2());

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