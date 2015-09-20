package controllers;

import model.Hello;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.LogInService;

import java.util.List;

@Controller
public class LogInController {

  @Autowired
  private LogInService logInService;

  public Result index() {
    Hello helloWorld = logInService.helloWorld();
    return play.mvc.Controller.ok(Json.toJson(helloWorld));
  }

  public Result traerTodosLosUsuarios() {
    List<Usuario> usuarios = logInService.traerTodosLosUsuarios();
    return play.mvc.Controller.ok(Json.toJson(usuarios));
  }

  public Result agregarUsuario() {
    Form<Usuario> form = Form.form(Usuario.class).bindFromRequest();
    Usuario usuario = form.get();
    logInService.agregarUsuario(usuario);
    return play.mvc.Controller.created(Json.toJson(usuario));
  }

}
