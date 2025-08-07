package com.veterinaria.veterinaria_be.repository;

import com.veterinaria.veterinaria_be.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
