package com.grupo1.tpframework.models;

public class User {
    private String nombre;
    private int edad;
    private String email;
    private String contrasenia;
    
    public User(String nombre, String edad, String email, String contrasenia) {
        this.nombre = nombre;
        this.edad = Integer.parseInt(edad);
        this.email = email;
        this.contrasenia = contrasenia;
    }

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
