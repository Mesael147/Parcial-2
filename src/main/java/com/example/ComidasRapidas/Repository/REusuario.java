package com.example.ComidasRapidas.Repository;

import com.example.ComidasRapidas.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REusuario extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByEmailAndPassword(String email, String password);
}
