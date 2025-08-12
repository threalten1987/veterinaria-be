package com.veterinaria.veterinaria_be.service;

import com.veterinaria.veterinaria_be.model.Mascota;

import java.util.List;

public interface MascotaService {
    List<Mascota> findAll();

    Mascota findById(Long id);

    Mascota save(Mascota mascota);

    Mascota update(long id, Mascota mascota);

    void deleteById(Long id);
}
