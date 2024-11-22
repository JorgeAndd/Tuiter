package com.me.tuiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.tuiter.model.Tuite;

public interface TuiteRepository extends JpaRepository<Tuite, Long> {
    List<Tuite> findByUser_Id(Long userId);
}
