package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Veterinario;

import java.util.List;

public interface IVeterinarioService {
    List<Veterinario> listar();
    Veterinario guardar(Veterinario veterinario);
    void eliminar(Integer id);
    Veterinario buscarPorId(Integer id);
}
