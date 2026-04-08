package com.itm.Intercambios;

// Esta clase representa un "Objeto" dentro de nuestra aplicación
// Es decir, define los datos que cada objeto tendrá
public class Objeto {

    // Identificador único del objeto
    private int id;

    // Nombre del objeto
    private String nombre;

    // Descripción del objeto
    private String descripcion;

    // Constructor vacío (necesario para ciertas operaciones en Spring)
    public Objeto() {}

    // Constructor con todos los campos
    public Objeto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters permiten leer y modificar los campos

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para mostrar el objeto como texto
    @Override
    public String toString() {
        return "Objeto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
}
