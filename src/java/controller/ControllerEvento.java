package controller;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Evento;

public class ControllerEvento {

    // ── POST /evento/save ──────────────────────────────────────────
    public Evento save(Evento e) throws SQLException {
        String sql = "INSERT INTO evento " +
                     "(id_negocio, nombre, fecha_hora, ubicacion, precio, descripcion, " +
                     "categoria, cupo, tiene_estacionamiento, requiere_anticipo, monto_anticipo, autoconfirmacion) " +
                     "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setInt(1,     e.getIdNegocio());
            pstm.setString(2,  e.getNombre());
            pstm.setString(3,  e.getFechaHora());
            pstm.setString(4,  e.getUbicacion());
            pstm.setDouble(5,  e.getPrecio());
            pstm.setString(6,  e.getDescripcion());
            pstm.setString(7,  e.getCategoria());
            pstm.setInt(8,     e.getCupo());
            pstm.setInt(9,     e.getTieneEstacionamiento());
            pstm.setInt(10,    e.getRequiereAnticipo());
            pstm.setDouble(11, e.getMontoAnticipo());
            pstm.setInt(12,    e.getAutoconfirmacion());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                e.setIdEvento(rs.getInt(1));
            }
            rs.close();
        }
        return e;
    }

    // ── GET /evento/getAll/{idNegocio} ─────────────────────────────
    public List<Evento> getAllByNegocio(int idNegocio) throws SQLException {
        String sql = "SELECT * FROM evento WHERE id_negocio = ? AND estado = 'activo' ORDER BY fecha_hora ASC";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, idNegocio);
            ResultSet rs = pstm.executeQuery();

            List<Evento> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(fill(rs));
            }
            rs.close();
            return lista;
        }
    }

    // ── DELETE /evento/delete/{idEvento} ───────────────────────────
    public boolean delete(int idEvento) throws SQLException {
        String sql = "UPDATE evento SET estado = 'cancelado' WHERE id_evento = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, idEvento);
            return pstm.executeUpdate() > 0;
        }
    }

    // ── fill: convierte ResultSet en objeto Evento ─────────────────
    private Evento fill(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setIdEvento(rs.getInt("id_evento"));
        e.setIdNegocio(rs.getInt("id_negocio"));
        e.setNombre(rs.getString("nombre"));
        e.setFechaHora(rs.getString("fecha_hora"));
        e.setUbicacion(rs.getString("ubicacion"));
        e.setPrecio(rs.getDouble("precio"));
        e.setDescripcion(rs.getString("descripcion"));
        e.setCategoria(rs.getString("categoria"));
        e.setCupo(rs.getInt("cupo"));
        e.setTieneEstacionamiento(rs.getInt("tiene_estacionamiento"));
        e.setRequiereAnticipo(rs.getInt("requiere_anticipo"));
        e.setMontoAnticipo(rs.getDouble("monto_anticipo"));
        e.setAutoconfirmacion(rs.getInt("autoconfirmacion"));
        e.setEstado(rs.getString("estado"));
        return e;
    }
}