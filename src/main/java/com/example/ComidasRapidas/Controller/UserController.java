package com.example.ComidasRapidas.Controller;

import com.example.ComidasRapidas.InterfaceService.IPedidoService;
import com.example.ComidasRapidas.InterfaceService.IProductoService;
import com.example.ComidasRapidas.Model.Pedido;
import com.example.ComidasRapidas.Model.Producto;
import com.example.ComidasRapidas.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IPedidoService pedidoService;


    @GetMapping("/menu")
    public String menuUsuario(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || (!"USER".equals(usuario.getRol()) && !"ADMIN".equals(usuario.getRol()))) {
            return "redirect:/login";
        }

        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("usuario", usuario);

        return "userMenu";
    }


    @GetMapping("/pedido/nuevo")
    public String nuevoPedido(@RequestParam("productoId") int productoId, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || (!"USER".equals(usuario.getRol()) && !"ADMIN".equals(usuario.getRol()))) {
            return "redirect:/login";
        }

        Producto producto = productoService.obtenerProductoPorId(productoId);
        if (producto == null) {
            model.addAttribute("error", "El producto no existe.");
            return "redirect:/user/menu";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("usuario", usuario);

        return "confirmarProducto";
    }


    @PostMapping("/pedido/confirmar")
    public String confirmarPedido(
            @RequestParam("productoId") int productoId,
            @RequestParam("cantidad") int cantidad,
            HttpSession session,
            Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || (!"USER".equals(usuario.getRol()) && !"ADMIN".equals(usuario.getRol()))) {
            return "redirect:/login";
        }


        Producto producto = productoService.obtenerProductoPorId(productoId);
        if (producto == null) {
            model.addAttribute("error", "El producto no existe.");
            return "redirect:/user/menu";
        }


        if (producto.getCantidad() < cantidad) {
            model.addAttribute("error", "No hay suficiente cantidad del producto.");
            return "redirect:/user/menu";
        }


        producto.setCantidad(producto.getCantidad() - cantidad);
        productoService.actualizarProducto(producto);


        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setProducto(producto);
        pedido.setCantidad(cantidad);
        pedido.setEstado("Pendiente");
        pedido.setFecha(LocalDateTime.now());

        pedidoService.crearPedido(pedido);

        model.addAttribute("mensaje", "Pedido realizado con éxito.");
        return "pedidoConfirmado";
    }
}
