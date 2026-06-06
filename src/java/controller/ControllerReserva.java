package controller;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerReserva {

    // ── PUT /reserva/confirmar/{idReservacion} ─────────────────────
    public boolean confirmar(int idReservacion) throws SQLException {
        return cambiarEstado(idReservacion, "confirmada");
    }

    // ── PUT /reserva/cancelar/{idReservacion} ──────────────────────
    public boolean cancelar(int idReservacion) throws SQLException {
        return cambiarEstado(idReservacion, "cancelada");
    }

    // ── cambiarEstado: reutilizado por confirmar y cancelar ─────────
    private boolean cambiarEstado(int idReservacion, String estado) throws SQLException {
        String sql = "UPDATE reservacion SET estado = ? WHERE id_reservacion = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, estado);
            pstm.setInt(2, idReservacion);
            return pstm.executeUpdate() > 0;
        }
    }
}