package com.itm.Intercambios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Esta clase maneja las peticiones del usuario
@RestController
public class ObjetoController {

    // Este método ahora devuelve una lista de objetos (no solo texto)
    @GetMapping("/objetos")
    public List<Objeto> listarObjetos() {

        // Creamos una lista de prueba
        List<Objeto> lista = new ArrayList<>();

        lista.add(new Objeto(1, "Libro de matemáticas", "Libro usado de cálculo"));
        lista.add(new Objeto(2, "Calculadora", "Calculadora científica"));

        return lista;
    }
}