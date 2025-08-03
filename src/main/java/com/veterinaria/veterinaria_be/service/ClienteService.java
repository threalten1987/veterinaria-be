package com.veterinaria.veterinaria_be.service;

import com.veterinaria.veterinaria_be.model.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public Cliente update(long id, Cliente cliente);


    public void deleteById(Long id);
}
