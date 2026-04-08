package com.itm.Intercambios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Esta clase se encarga de manejar la conexión con la base de datos
// y ejecutar las consultas SQL
public class ObjetoDAO {

    // Datos de conexión a la base de datos H2
    private final String URL = "jdbc:h2:mem:testdb";
    private final String USER = "sa";
    private final String PASSWORD = "";

    // Método para obtener conexión
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Crear tabla si no existe
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

    // INSERT → guardar objeto (POST)
    public void guardar(Objeto obj) {
        String sql = "INSERT INTO objetos (id, nombre, descripcion) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getNombre());
            stmt.setString(3, obj.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SELECT → listar objetos (GET)
    public List<Objeto> listar() {
        List<Objeto> lista = new ArrayList<>();
        String sql = "SELECT * FROM objetos";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Objeto obj = new Objeto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                lista.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE → actualizar objeto (PUT)
    public void actualizar(Objeto obj) {
        String sql = "UPDATE objetos SET nombre = ?, descripcion = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, obj.getNombre());
            stmt.setString(2, obj.getDescripcion());
            stmt.setInt(3, obj.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE → eliminar objeto
    public void eliminar(int id) {
        String sql = "DELETE FROM objetos WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}