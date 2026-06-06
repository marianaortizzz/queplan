package controller;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Negocio;

public class ControllerNegocio {

    // ── POST /negocio/registro ─────────────────────────────────────
    public Negocio save(Negocio n) throws SQLException {
        String sql = "INSERT INTO negocio (usuario, nombre_negocio, nombre_dueno, password_hash) VALUES (?,?,?,?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, n.getUsuario());
            pstm.setString(2, n.getNombreNegocio());
            pstm.setString(3, n.getNombreDueno());
            pstm.setString(4, n.getPasswordHash());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                n.setIdNegocio(rs.getInt(1));
            }
            rs.close();
        }
        return n;
    }

    // ── POST /negocio/login ────────────────────────────────────────
    public Negocio login(String usuario, String passwordHash) throws SQLException {
        String sql = "SELECT * FROM negocio WHERE usuario = ? AND password_hash = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, usuario);
            pstm.setString(2, passwordHash);

            ResultSet rs = pstm.executeQuery();
            Negocio n = null;
            if (rs.next()) {
                n = fill(rs);
            }
            rs.close();
            return n;
        }
    }

    // ── PUT /negocio/actualizar ────────────────────────────────────
    public Negocio update(Negocio n) throws SQLException {
        String sql = "UPDATE negocio SET descripcion=?, logo_url=?, telefono=?, " +
                     "direccion=?, instagram=?, facebook=?, tiktok=?, pagina_web=? " +
                     "WHERE id_negocio=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, n.getDescripcion());
            pstm.setString(2, n.getLogoUrl());
            pstm.setString(3, n.getTelefono());
            pstm.setString(4, n.getDireccion());
            pstm.setString(5, n.getInstagram());
            pstm.setString(6, n.getFacebook());
            pstm.setString(7, n.getTiktok());
            pstm.setString(8, n.getPaginaWeb());
            pstm.setInt(9, n.getIdNegocio());
            pstm.executeUpdate();
        }
        return n;
    }

    // ── fill: convierte ResultSet en objeto Negocio ────────────────
    private Negocio fill(ResultSet rs) throws SQLException {
        Negocio n = new Negocio();
        n.setIdNegocio(rs.getInt("id_negocio"));
        n.setUsuario(rs.getString("usuario"));
        n.setNombreNegocio(rs.getString("nombre_negocio"));
        n.setNombreDueno(rs.getString("nombre_dueno"));
        n.setDireccion(rs.getString("direccion"));
        n.setTelefono(rs.getString("telefono"));
        n.setDescripcion(rs.getString("descripcion"));
        n.setLogoUrl(rs.getString("logo_url"));
        n.setInstagram(rs.getString("instagram"));
        n.setFacebook(rs.getString("facebook"));
        n.setTiktok(rs.getString("tiktok"));
        n.setPaginaWeb(rs.getString("pagina_web"));
        return n;
    }
}