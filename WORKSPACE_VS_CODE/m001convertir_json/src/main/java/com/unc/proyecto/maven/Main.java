package com.unc.proyecto.maven;

import com.google.gson.Gson;

public class Main {
    
    public static int suma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(suma(1, 2));
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Alvaro");
        nuevoUsuario.setTitulo("Ing Sistemas");
        nuevoUsuario.setPos("Msc Administracion");
        nuevoUsuario.setNacionalidad("CO");
        Gson g = new Gson();
        System.out.println(g.toJson(nuevoUsuario));

    }
}