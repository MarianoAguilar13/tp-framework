package com.grupo1.tpframework.api;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.grupo1.tpframework.controllers.Controlador;
import com.grupo1.tpframework.models.Modelo;
import com.grupo1.tpframework.models.User;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {
    @RequestMapping(value = "apicreateusuario", method = RequestMethod.POST)
    public Integer apicreateusuario(@RequestBody User usuario){
        //No dejaba retornar strings para ver qué había pasado. Lo probamos con Integer y anduvo
        if (Controlador.comprobarEdad(usuario.getEdad())){
            if (Controlador.comprobarEmail(usuario.getEmail())) {
                if (Controlador.comprobarContrasenia(usuario.getContrasenia())) {
                    if(Controlador.comprobarRegistro(usuario.getEmail())){
                        Modelo.agregarUsuario(usuario);
                        System.out.println("ayuda");
                        return 0;
                    }else{
                        return 1;
                    }
                }else{
                    return 2;
                }
            }else{
                return 3;
            }
        }else{
            return 4;
        }
    }


    @RequestMapping(value = "apiGetUsuarios", method = RequestMethod.GET)
    public ArrayList<User> apiGetUsuarios(){
        return Modelo.getInstaceModelo();
    }
}
