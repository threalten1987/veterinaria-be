package com.veterinaria.veterinaria_be.controller;

import com.veterinaria.veterinaria_be.model.Cliente;
import com.veterinaria.veterinaria_be.model.Mascota;
import com.veterinaria.veterinaria_be.service.ClienteService;
import com.veterinaria.veterinaria_be.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinaria")
public class VeterinariaController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
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

    @GetMapping("/mascotas")
    public List<Mascota> getAllMascotas() {
        return mascotaService.findAll();
    }

    @PostMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mascota createMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        System.out.println("Creando mascota: " + mascota);
        Cliente cliente = clienteService.findById(id);
        if(cliente == null) {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
        mascota.setCliente(cliente);
        return mascotaService.save(mascota);
    }

    @GetMapping("/mascotas/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.findById(id);
    }

    @PutMapping("/mascotas/{id}")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascotaService.update(id, mascota);
    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

}
