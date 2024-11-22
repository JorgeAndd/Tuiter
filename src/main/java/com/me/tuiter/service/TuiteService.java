package com.me.tuiter.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.me.tuiter.model.Tuite;
import com.me.tuiter.model.User;
import com.me.tuiter.repository.TuiteRepository;

@Service
public class TuiteService {
    private final TuiteRepository tuiteRepository;

    public TuiteService(TuiteRepository tuiteRepository) {
        this.tuiteRepository = tuiteRepository;
    }

    public Tuite createTuite(String content, User user) {
        Tuite tuite = new Tuite(content, user, Instant.now());
        return tuiteRepository.save(tuite);
    }

    public List<Tuite> getTuitesByUser(Long userId) {
        return tuiteRepository.findByUser_Id(userId);
    }
}
