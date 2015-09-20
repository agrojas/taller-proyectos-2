package model;

import java.util.*;
import play.modules.mongodb.jackson.MongoDB;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;

public class Usuario {

    @Id
    @ObjectId
    public String id;

    public String nombre;

    private static JacksonDBCollection<Usuario, String> coleccion = MongoDB.getCollection("usuarios", Usuario.class, String.class);

    public Usuario() { }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public static List<Usuario> traerTodos() {
        return Usuario.coleccion.find().toArray();
    }

    public static void crear(Usuario usuario) {
        Usuario.coleccion.save(usuario);
    }

    public static void eliminar(String id) {
        Usuario usuario = Usuario.coleccion.findOneById(id);
        if (usuario != null)
            Usuario.coleccion.remove(usuario);
    }

    public static void eliminarTodos() {
        Usuario.coleccion.drop();
    }

}
