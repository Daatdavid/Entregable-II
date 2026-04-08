package com.itm.Intercambios;

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

    private ObjetoDAO dao = new ObjetoDAO();

    public ObjetoController() {
        dao.crearTabla();
    }

    // GET → ver todos los objetos
    @GetMapping("/objetos")
    public List<Objeto> listarObjetos() {
        return dao.listar();
    }

    // POST → agregar un nuevo objeto
    @PostMapping("/objetos")
    public Objeto agregarObjeto(@RequestBody Objeto objeto) {
        dao.guardar(objeto);
        return objeto;
    }

    // PUT → actualizar un objeto existente
    @PutMapping("/objetos/{id}")
    public Objeto actualizarObjeto(@PathVariable int id, @RequestBody Objeto objetoActualizado) {

        objetoActualizado.setId(id);
        dao.actualizar(objetoActualizado);
        return objetoActualizado;
    }

    // DELETE → eliminar un objeto por id
    @DeleteMapping("/objetos/{id}")
    public String eliminarObjeto(@PathVariable int id) {

        dao.eliminar(id);
        return "Objeto eliminado correctamente";
    }
}