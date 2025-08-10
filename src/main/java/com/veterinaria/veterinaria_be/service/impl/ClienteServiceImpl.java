package com.veterinaria.veterinaria_be.service.impl;

import com.veterinaria.veterinaria_be.model.Cliente;
import com.veterinaria.veterinaria_be.repository.ClienteRepository;
import com.veterinaria.veterinaria_be.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public Cliente save(Cliente cliente) {
        Optional<Cliente> existingClienteByEmail = clienteRepository.findByEmail(cliente.getEmail());
        if (existingClienteByEmail.isPresent()) {
            throw new RuntimeException("Ya existe un cliente con el email: " + cliente.getEmail());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(long id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setEmail(cliente.getEmail());
        existingCliente.setTelefono(cliente.getTelefono());
        existingCliente.setDireccion(cliente.getDireccion());
        return clienteRepository.save(existingCliente);
    }


    @Override
    public void deleteById(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
