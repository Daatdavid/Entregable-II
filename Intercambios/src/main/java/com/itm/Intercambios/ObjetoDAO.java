package com.itm.Intercambios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Esta clase se encarga de hablar con la base de datos
public class ObjetoDAO {

    private final String URL = "jdbc:h2:mem:testdb";
    private final String USER = "sa";
    private final String PASSWORD = "";

    // Método para obtener conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Crear tabla (por si no existe)
    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS objetos (" +
                     "id INT PRIMARY KEY, " +
                     "nombre VARCHAR(100), " +
                     "descripcion VARCHAR(255))";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
