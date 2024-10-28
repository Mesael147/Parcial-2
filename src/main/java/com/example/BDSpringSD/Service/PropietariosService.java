package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IPropietarioService;
import com.example.BDSpringSD.Model.Propietario;
import com.example.BDSpringSD.Repository.REPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietariosService implements IPropietarioService {
    @Autowired
    private REPropietario rePropietario;

    @Override
    public List<Propietario> listar() {
        return rePropietario.findAll();
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return rePropietario.save(propietario);
    }

    @Override
    public void eliminar(Integer id) {
        rePropietario.deleteById(id);
    }

    @Override
    public Propietario buscarPorId(Integer id) {
        return rePropietario.findById(id).orElse(null);
    }
}