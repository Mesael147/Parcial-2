package com.example.ComidasRapidas.InterfaceService;

import com.example.ComidasRapidas.Model.Menu;
import java.util.List;

public interface IMenuService {
    Menu crearMenu(Menu menu);
    Menu obtenerMenuPorId(int id);
    List<Menu> obtenerTodosLosMenus();
    Menu actualizarMenu(Menu menu);
    void eliminarMenu(int id);
}