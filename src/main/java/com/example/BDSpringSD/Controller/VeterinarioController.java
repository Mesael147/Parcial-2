package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.InterfaceService.IVeterinarioService;
import com.example.BDSpringSD.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private IVeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "veterinarios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("veterinario", new Veterinario());
        return "formVeterinario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Veterinario veterinario) {
        veterinarioService.guardar(veterinario);
        return "redirect:/veterinarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Veterinario veterinario = veterinarioService.buscarPorId(id);
        model.addAttribute("veterinario", veterinario);
        return "formVeterinario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        veterinarioService.eliminar(id);
        return "redirect:/veterinarios/listar";
    }
}