package com.example.ComidasRapidas.Service;

import com.example.ComidasRapidas.InterfaceService.IPedidoService;
import com.example.ComidasRapidas.Model.Pedido;
import com.example.ComidasRapidas.Model.Producto;
import com.example.ComidasRapidas.Model.Usuario;
import com.example.ComidasRapidas.Repository.REpedido;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private REpedido pedidoRepository;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;


    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAllWithUsuarioAndProducto();
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(int id) {
        pedidoRepository.deleteById(id);
    }

}