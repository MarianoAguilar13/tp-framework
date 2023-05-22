package com.grupo1.tpframework.controllers;
import com.grupo1.tpframework.models.Modelo;
import com.grupo1.tpframework.models.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Controlador{
    public static boolean comprobarRegistro(String email){
        ArrayList<User> temp = Modelo.getInstaceModelo();
        //Comprobar si el usuario ya está registrado
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getEmail().equals(email)){
               // System.out.println("Error, el usuario ya está registrado"); //capaz que va en la vista
                return false;
            }
        }
        return true;
    }

    public static boolean comprobarEdad(int edad){
        return edad > 0;
    }

    public static boolean comprobarEmail(String email){
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }


    public static boolean comprobarContrasenia(String contrasenia){
    // Contraseña de 8-16 caracteres con al menos un dígito, al menos uno
    // letra minúscula, al menos una letra mayúscula, al menos una
    // caracter especial sin espacios en blanco
        String caracteres = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
        Pattern pattern = Pattern.compile(caracteres);

        // Validar una contraseña
        return pattern.matcher(contrasenia).matches();
    }
}
