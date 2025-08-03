package com.veterinaria.veterinaria_be.repository;

import com.veterinaria.veterinaria_be.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre, email, etc.
    public Optional<Cliente> findByEmail(String email);
    public Optional<Cliente> findByTelefono(String telefono);
}
