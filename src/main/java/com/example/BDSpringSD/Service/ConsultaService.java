package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IConsultaService;
import com.example.BDSpringSD.Model.Consulta;
import com.example.BDSpringSD.Repository.REConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private REConsulta reConsulta;

    @Override
    public List<Consulta> listar() {
        return reConsulta.findAll();
    }

    @Override
    public Consulta guardar(Consulta consulta) {
        return reConsulta.save(consulta);
    }

    @Override
    public void eliminar(Integer id) {
        reConsulta.deleteById(id);
    }

    @Override
    public Consulta buscarPorId(Integer id) {return reConsulta.findById(id).orElse(null);
    }
}