package com.veterinaria.veterinaria_be.service.impl;

import com.veterinaria.veterinaria_be.model.Mascota;
import com.veterinaria.veterinaria_be.repository.MascotaRepository;
import com.veterinaria.veterinaria_be.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota findById(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));
    }

    @Override
    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota update(long id, Mascota mascota) {
        Mascota existingMascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));
        existingMascota.setNombre(mascota.getNombre());
        existingMascota.setEspecie(mascota.getEspecie());
        existingMascota.setRaza(mascota.getRaza());
        existingMascota.setEdad(mascota.getEdad());
        return mascotaRepository.save(existingMascota);
    }

    @Override
    public void deleteById(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada con ID: " + id);
        }
        mascotaRepository.deleteById(id);
    }
}
