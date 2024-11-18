package com.example.ComidasRapidas.InterfaceService;

import com.example.ComidasRapidas.Model.Pedido;
import java.util.List;

public interface IPedidoService {
    Pedido crearPedido(Pedido pedido);
    Pedido obtenerPedidoPorId(int id);
    List<Pedido> obtenerTodosLosPedidos();
    Pedido actualizarPedido(Pedido pedido);
    void eliminarPedido(int id);
}