package com.example.ComidasRapidas.Service;

import com.example.ComidasRapidas.InterfaceService.IProductoService;
import com.example.ComidasRapidas.Model.Producto;
import com.example.ComidasRapidas.Repository.REproducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private REproducto productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        productoRepository.deleteById(id);
    }
}