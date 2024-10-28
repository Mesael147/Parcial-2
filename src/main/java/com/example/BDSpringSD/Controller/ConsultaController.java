package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.InterfaceService.IConsultaService;
import com.example.BDSpringSD.InterfaceService.IMascotaService;
import com.example.BDSpringSD.InterfaceService.IVeterinarioService;
import com.example.BDSpringSD.Model.Consulta;
import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService consultaService;

    @Autowired
    private IMascotaService mascotaService;

    @Autowired
    private IVeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Consulta> consultas = consultaService.listar();
        List<Mascota> mascotas = mascotaService.listar();  // Supone que tienes un método listar() en IMascotaService
        List<Veterinario> veterinarios = veterinarioService.listar();  // Supone que tienes un método listar() en IVeterinarioService

        model.addAttribute("consultas", consultas);
        model.addAttribute("mascotas", mascotas);
        model.addAttribute("veterinarios", veterinarios);
        return "consultas";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "formConsulta";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Consulta consulta) {
        consultaService.guardar(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Consulta consulta = consultaService.buscarPorId(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "formConsulta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        consultaService.eliminar(id);
        return "redirect:/consultas/listar";
    }
}
