package com.myproject.property;

import java.util.Map;
import java.util.HashMap;

import com.myproject.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Property>> list() {
        Iterable<Property> property = propertyService.list();
        return createHashPlural(property);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Property> read(@PathVariable Long id) {
        Property property = propertyService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(property);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Property> create(@Validated @RequestBody Property property) {
        Property createdProperty = propertyService.create(property);
        return createHashSingular(createdProperty);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Property> update(@RequestBody Property property, @PathVariable Long id) {
        Property updatedProperty = propertyService
                .update(property)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedProperty);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        propertyService.deleteById(id);
    }

    private Map<String, Property> createHashSingular(Property property) {
        Map<String, Property> response = new HashMap<String, Property>();
        response.put("property", property);

        return response;
    }

    private Map<String, Iterable<Property>> createHashPlural(Iterable<Property> properties) {
        Map<String, Iterable<Property>> response = new HashMap<String, Iterable<Property>>();
        response.put("properties", properties);

        return response;
    }
}