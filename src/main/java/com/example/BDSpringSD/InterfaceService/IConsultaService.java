package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Consulta;

import java.util.List;

public interface IConsultaService {
    List<Consulta> listar();
    Consulta guardar(Consulta consulta);
    void eliminar(Integer id);
    Consulta buscarPorId(Integer id);
}
