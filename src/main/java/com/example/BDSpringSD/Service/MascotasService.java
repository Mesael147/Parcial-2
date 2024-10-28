package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IMascotaService;
import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Repository.REMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotasService implements IMascotaService {

    @Autowired
    private REMascota reMascota;

    @Override
    public List<Mascota> listar() {return reMascota.findAll();}

    @Override
    public Mascota guardar(Mascota mascota) {return reMascota.save(mascota);}

    @Override
    public void eliminar(Integer id) {reMascota.deleteById(id);
    }

    @Override
    public Mascota buscarPorId(Integer id) {
        return reMascota.findById(id).orElse(null);
    }
}