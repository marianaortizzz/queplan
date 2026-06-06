package rest;

import controller.ControllerReserva;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reserva")
public class RestReserva {

    // ── PUT /reserva/confirmar/{idReservacion} ─────────────────────
    @PUT
    @Path("/confirmar/{idReservacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmar(@PathParam("idReservacion") int idReservacion) {
        try {
            ControllerReserva cr = new ControllerReserva();
            boolean ok = cr.confirmar(idReservacion);
            String out = ok
                ? "{\"response\": \"Reserva confirmada\"}"
                : "{\"response\": \"Error al confirmar la reserva\"}";
            return Response.ok(out).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }

    // ── PUT /reserva/cancelar/{idReservacion} ──────────────────────
    @PUT
    @Path("/cancelar/{idReservacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelar(@PathParam("idReservacion") int idReservacion) {
        try {
            ControllerReserva cr = new ControllerReserva();
            boolean ok = cr.cancelar(idReservacion);
            String out = ok
                ? "{\"response\": \"Reserva cancelada\"}"
                : "{\"response\": \"Error al cancelar la reserva\"}";
            return Response.ok(out).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }
}