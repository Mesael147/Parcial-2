package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Propietario;
import java.util.List;

public interface IPropietarioService {
    List<Propietario> listar();
    Propietario guardar(Propietario propietario);
    void eliminar(Integer id);
    Propietario buscarPorId(Integer id);
}