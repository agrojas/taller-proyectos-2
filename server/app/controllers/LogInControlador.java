package controllers;

import model.Usuario;
import model.externo.UsuarioLogIn;
import model.externo.UsuarioRegistroCuenta;
import model.externo.UsuarioRegistroFacebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.LogInServicio;

@Controller
public class LogInControlador {

  @Autowired
  private LogInServicio logInServicio;

  public Result logInCuenta() {
    Form<UsuarioLogIn> form = Form.form(UsuarioLogIn.class).bindFromRequest();
    UsuarioLogIn usuarioLogIn = form.get();
    Usuario usuario = logInServicio.logIn(usuarioLogIn);
    if (usuario == null)
      return play.mvc.Controller.badRequest();
    return play.mvc.Controller.ok(Json.toJson(usuario));
  }

  public Result logInFacebook(String facebookId) {
    Usuario usuario = logInServicio.logInFacebook(facebookId);
    if (usuario == null)
      return play.mvc.Controller.badRequest();
    return play.mvc.Controller.ok(Json.toJson(usuario));
  }

  public Result registrarUsuarioCuenta() {
    Form<UsuarioRegistroCuenta> form = Form.form(UsuarioRegistroCuenta.class).bindFromRequest();
    UsuarioRegistroCuenta usuario = form.get();
    if (logInServicio.registrarUsuarioCuenta(usuario) == null)
      return play.mvc.Controller.badRequest();
    else return play.mvc.Controller.ok();
  }

  public Result registrarUsuarioFacebook() {
    Form<UsuarioRegistroFacebook> form = Form.form(UsuarioRegistroFacebook.class).bindFromRequest();
    UsuarioRegistroFacebook usuario = form.get();
    logInServicio.registrarUsuarioFacebook(usuario);
    return play.mvc.Controller.ok();
  }

}
