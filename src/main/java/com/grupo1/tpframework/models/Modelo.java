package com.grupo1.tpframework.models;
import java.util.ArrayList;


public class Modelo {
    private static ArrayList<User> usuarios = null;

    private Modelo(){}

    public static ArrayList<User> getInstaceModelo(){
        if(usuarios == null){
            usuarios = new ArrayList<>();
            return usuarios;
        }else{
            return usuarios;
        }
    }

    public static void agregarUsuario(User usuario){
        getInstaceModelo().add(usuario);
    }
}
