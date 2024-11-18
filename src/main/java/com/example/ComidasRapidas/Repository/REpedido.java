package com.example.ComidasRapidas.Repository;

import com.example.ComidasRapidas.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface REpedido extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p JOIN FETCH p.usuario JOIN FETCH p.producto")
    List<Pedido> findAllWithUsuarioAndProducto();

}
