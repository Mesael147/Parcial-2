package com.example.ComidasRapidas.InterfaceService;

import com.example.ComidasRapidas.Model.Producto;
import java.util.List;

public interface IProductoService {
    Producto crearProducto(Producto producto);
    Producto obtenerProductoPorId(int id);
    List<Producto> obtenerTodosLosProductos();
    Producto actualizarProducto(Producto producto);
    void eliminarProducto(int id);
}