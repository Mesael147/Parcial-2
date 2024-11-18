package com.example.ComidasRapidas.Controller;

import com.example.ComidasRapidas.InterfaceService.IPedidoService;
import com.example.ComidasRapidas.InterfaceService.IProductoService;
import com.example.ComidasRapidas.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/menu")
    public String menuAdmin(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
            return "redirect:/login";
        }
        return "adminMenu";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

    @GetMapping("/productos")
    public String gestionarProductos(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
            return "redirect:/login";
        }
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioNuevoProducto(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
            return "redirect:/login";
        }
        model.addAttribute("producto", new Producto());
        return "nuevoProducto";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
            return "redirect:/login";
        }
        productoService.crearProducto(producto);
        return "redirect:/admin/productos";
    }

    @GetMapping("/pedidos")
    public String verPedidos(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || !"ADMIN".equals(usuario.getRol())) {
            return "redirect:/login";
        }
        List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }
}
