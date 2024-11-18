package com.example.ComidasRapidas.Service;

import com.example.ComidasRapidas.InterfaceService.IMenuService;
import com.example.ComidasRapidas.Model.Menu;
import com.example.ComidasRapidas.Repository.REmenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private REmenu menuRepository;

    @Override
    public Menu crearMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu obtenerMenuPorId(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> obtenerTodosLosMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu actualizarMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void eliminarMenu(int id) {
        menuRepository.deleteById(id);
    }
}