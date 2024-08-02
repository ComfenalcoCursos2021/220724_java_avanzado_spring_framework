package com.unc.inyeccion.s006inyeccion.dtos;


public class UsuarioDto {
    private int id;
    private String nick;
    private String password;

    
    public UsuarioDto() {
    }

    public UsuarioDto(int id, String nick, String password) {
        this.id = id;
        this.nick = nick;
        this.password = password;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
