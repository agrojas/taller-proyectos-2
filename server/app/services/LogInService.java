package services;

import model.Hello;
import model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInService {

    public Hello helloWorld() {
        return new Hello("Hola mundo!!! :D");
    }

    public List<Usuario> traerTodosLosUsuarios() {
        return Usuario.traerTodos();
    }

    public void agregarUsuario(Usuario usuario) {
        Usuario.crear(usuario);
    }

}
