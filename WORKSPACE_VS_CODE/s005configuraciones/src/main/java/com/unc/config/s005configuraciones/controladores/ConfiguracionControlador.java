package com.unc.config.s005configuraciones.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/configuraciones")
public class ConfiguracionControlador {



    @Value("${miproyecto.maximovalor}")
    private int MAXIMO_VALOR;

    @Value("${miproyecto.version}")
    private String VERSION_CODIGO;

    @Value("${miproyecto.lista.dias}")
    private List<String> LISTA_DIAS;

    @Value("${miproyecto.lista.dias}")
    private String DIAS;

    @Value("#{${miproyecto.estructura}}")
    private Map<String,Object> VALORES_MAPA;

    @GetMapping()
    public Map<String,Object> getTodosLosParametros(@Value("${miproyecto.mensaje.bienvenida}") String elMensaje) {

        Map<String,Object> mapa = new HashMap<String,Object>(); 
        mapa.put("LosParametros", "Aqui van todos los parametros");
        mapa.put("valorMaximo",this.MAXIMO_VALOR);
        mapa.put("version",this.VERSION_CODIGO);
        mapa.put("dias",this.LISTA_DIAS);
        mapa.put("dias_texto",this.DIAS);
        mapa.put("Mensaje",elMensaje);
        mapa.put("LaEstructura", this.VALORES_MAPA);
        return mapa;
    }


    @Autowired
    private Environment ambiente;


    @GetMapping("lvl2")
    public Map<String,Object> getTodosLosParametrosPorEnvironment() {

        Map<String,Object> mapa = new HashMap<String,Object>(); 
        mapa.put("ambiente.version", ambiente.getProperty("miproyecto.version"));
        mapa.put("miproyecto.lista.dias", ambiente.getProperty("miproyecto.lista.dias",ArrayList.class));
        mapa.put("miproyecto.estructura", ambiente.getProperty("miproyecto.estructura"));

        return mapa;
    }

    
    
}
