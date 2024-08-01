package com.unc.spring.parametros.s004parametros.excepciones;

public class UsuarioNoExisteExcepcion extends Exception {

    public UsuarioNoExisteExcepcion(String mensaje) {
        super("ESTE ERROR SALE POR QUE ESTAN INTENTANDO USAR COSAS QUE NO ...." + mensaje);
    }

}
