package controllers;

import model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import play.libs.Json;
import play.mvc.Result;
import services.LogInService;

@Controller
public class LogInController {

  @Autowired
  private LogInService logInService;

  public Result index() {
    Hello helloWorld = logInService.helloWorld();
    return play.mvc.Controller.ok(Json.toJson(helloWorld));
  }

}
