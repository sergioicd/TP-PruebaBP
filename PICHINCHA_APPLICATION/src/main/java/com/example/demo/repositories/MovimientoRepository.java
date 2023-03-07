package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

}
