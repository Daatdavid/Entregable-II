package com.itm.Intercambios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Esta clase maneja las peticiones del usuario
@RestController
public class ObjetoController {

    // Lista que guarda los objetos (simulación de base de datos)
    private List<Objeto> lista = new ArrayList<>();

    // GET → ver objetos
    @GetMapping("/objetos")
    public List<Objeto> listarObjetos() {
        return lista;
    }

    // POST → agregar un nuevo objeto
    @PostMapping("/objetos")
    public Objeto agregarObjeto(@RequestBody Objeto objeto) {
        lista.add(objeto);
        return objeto;
    }
}