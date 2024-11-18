package com.example.ComidasRapidas.Repository;

import com.example.ComidasRapidas.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REproducto extends JpaRepository<Producto, Integer> {

}
