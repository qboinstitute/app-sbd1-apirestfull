package com.qbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qbo.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}
