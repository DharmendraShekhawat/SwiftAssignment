package com.example.swift.service;

import com.example.swift.model.Visitor;
import com.example.swift.repo.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public int getVisitorCount() {
        return visitorRepository.findById(1L).orElse(new Visitor()).getCount();
    }

    public void incrementVisitorCount(boolean isInIncognitoMode) {
        if (isInIncognitoMode) {
            Visitor visitor = visitorRepository.findById(1L).orElse(new Visitor());
            visitor.setCount(visitor.getCount() + 1);
            visitorRepository.save(visitor);

        }
    }
    public void incrementVisitorCount() {

            Visitor visitor = visitorRepository.findById(1L).orElse(new Visitor());
            visitor.setCount(visitor.getCount() + 1);
            visitorRepository.save(visitor);
    }
}
