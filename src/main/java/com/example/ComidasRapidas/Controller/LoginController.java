package com.example.ComidasRapidas.Controller;



import com.example.ComidasRapidas.InterfaceService.IUsuarioService;
import com.example.ComidasRapidas.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("usuario") Usuario usuario, Model model, HttpSession session) {
        Usuario user = usuarioService.obtenerUsuarioPorEmailYPassword(usuario.getEmail(), usuario.getPassword());
        if (user != null) {
            session.setAttribute("usuario", user);
            if ("ADMIN".equals(user.getRol())) {
                return "redirect:/admin/menu";
            } else {
                return "redirect:/user/menu";
            }
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String registrar(@ModelAttribute("usuario") Usuario usuario, Model model) {
        if (usuarioService.obtenerUsuarioPorEmail(usuario.getEmail()) != null) {
            model.addAttribute("error", "El correo ya está registrado");
            return "register";
        }
        usuario.setRol("USER");
        usuarioService.crearUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

