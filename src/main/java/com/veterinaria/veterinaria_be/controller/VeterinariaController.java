package com.veterinaria.veterinaria_be.controller;

import com.veterinaria.veterinaria_be.model.Cliente;
import com.veterinaria.veterinaria_be.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinaria")
public class VeterinariaController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @PostMapping("/clientes")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        System.out.println("Creando cliente: " + cliente);
        return clienteService.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteById(Long id) {
        return clienteService.findById(id);
    }

    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

}
