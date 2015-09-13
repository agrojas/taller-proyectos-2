package services;

import model.Hello;
import org.springframework.stereotype.Service;

@Service
public class LogInService {

    public Hello helloWorld() {
        return new Hello("Hola mundo!!! :D");
    }

}
