package com.itm.Intercambios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Esta clase maneja las peticiones del usuario
@RestController
public class ObjetoController {

    // Lista que guarda los objetos (simulación de base de datos)
    private List<Objeto> lista = new ArrayList<>();

    // GET → ver todos los objetos
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

    // PUT → actualizar un objeto existente
    @PutMapping("/objetos/{id}")
    public Objeto actualizarObjeto(@PathVariable int id, @RequestBody Objeto objetoActualizado) {

        for (Objeto obj : lista) {
            if (obj.getId() == id) {
                obj.setNombre(objetoActualizado.getNombre());
                obj.setDescripcion(objetoActualizado.getDescripcion());
                return obj;
            }
        }

        return null; // si no se encuentra el objeto
    }

    // DELETE → eliminar un objeto por id
    @DeleteMapping("/objetos/{id}")
    public String eliminarObjeto(@PathVariable int id) {

        for (Objeto obj : lista) {
            if (obj.getId() == id) {
                lista.remove(obj);
                return "Objeto eliminado correctamente";
            }
        }

        return "Objeto no encontrado";
    }
}