package com.example.ComidasRapidas.InterfaceService;


import com.example.ComidasRapidas.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(int id);
    Usuario obtenerUsuarioPorEmail(String email);
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int id);
    Usuario obtenerUsuarioPorEmailYPassword(String email, String password);
}
