package com.unc.s012configserver.seguridad;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BuscadorUsuarios implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if(!"root".equals(username)){
            throw new UsernameNotFoundException("EL USUARIO NO EXISTE");
        }

        return User.builder().username(username).password(cifrar("root")).roles().build();

    }

    public String cifrar(String texto){
        var encriptador = new  BCryptPasswordEncoder();

        return encriptador.encode(texto);
    }

}
