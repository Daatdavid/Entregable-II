package com.itm.Intercambios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Esta clase se encarga de recibir las peticiones del usuario
// Es decir, cuando alguien entra a una URL como /objetos
@RestController
public class ObjetoController {

    // Este método responde a peticiones GET en la ruta /objetos
    // Por ahora solo devuelve un mensaje para comprobar que todo funciona
    @GetMapping("/objetos")
    public String listarObjetos() {
        return "El backend está funcionando correctamente";
    }
}