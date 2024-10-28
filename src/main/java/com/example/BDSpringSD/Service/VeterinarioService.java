package com.example.BDSpringSD.Service;


import com.example.BDSpringSD.InterfaceService.IVeterinarioService;
import com.example.BDSpringSD.Model.Veterinario;
import com.example.BDSpringSD.Repository.REVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService implements IVeterinarioService {

    @Autowired
    private REVeterinario reVeterinario;

    @Override
    public List<Veterinario> listar() {
        return reVeterinario.findAll();
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return reVeterinario.save(veterinario);
    }

    @Override
    public void eliminar(Integer id) {
        reVeterinario.deleteById(id);
    }

    @Override
    public Veterinario buscarPorId(Integer id) {
        return reVeterinario.findById(id).orElse(null);
    }
}
