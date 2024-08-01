package com.unc.spring.parametros.s004parametros.dto;

public class UsuarioDto {

    private int id;
    private String nombre;
    private String nick;
    private String password;

    public UsuarioDto(){
        
    }
    
    public UsuarioDto(int id, String nombre, String nick, String password) {
        this.id = id;
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
