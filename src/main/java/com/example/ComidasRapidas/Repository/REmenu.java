package com.example.ComidasRapidas.Repository;

import com.example.ComidasRapidas.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REmenu extends JpaRepository<Menu, Integer> {

}

