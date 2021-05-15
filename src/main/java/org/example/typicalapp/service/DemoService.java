package org.example.typicalapp.service;

import org.example.typicalapp.dto.SampleEntity;
import org.example.typicalapp.exception.InvalidValueException;
import org.example.typicalapp.exception.NonUniqueNameException;
import org.example.typicalapp.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public String toLowerCase(String value) throws InvalidValueException, NonUniqueNameException {
        if(value == null || value.trim().isEmpty()) {
            throw new InvalidValueException(null,"toLowerCase");
        }

        String output = value.toLowerCase();

        if(demoRepository.findByName(output).isEmpty()){
            demoRepository.save(new SampleEntity(output));
        } else {
            throw new NonUniqueNameException(output);
        }

        return output;
    }
}