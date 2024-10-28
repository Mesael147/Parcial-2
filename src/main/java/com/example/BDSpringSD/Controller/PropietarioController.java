package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.InterfaceService.IPropietarioService;
import com.example.BDSpringSD.Model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {
    @Autowired
    private IPropietarioService propietarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("propietarios", propietarioService.listar());
        return "propietarios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "formPropietario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Propietario propietario) {
        propietarioService.guardar(propietario);
        return "redirect:/propietarios/listar";
    }
}
