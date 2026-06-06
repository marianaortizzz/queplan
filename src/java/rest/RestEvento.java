package rest;

import com.google.gson.Gson;
import controller.ControllerEvento;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Evento;

@Path("/evento")
public class RestEvento {

    // ── POST /evento/save ──────────────────────────────────────────
    // Body: { "idNegocio":1, "nombre":"...", "fechaHora":"2026-07-01 20:00",
    //         "ubicacion":"...", "precio":250.0, "descripcion":"...",
    //         "categoria":"...", "cupo":30, "tieneEstacionamiento":1,
    //         "requiereAnticipo":0, "montoAnticipo":0, "autoconfirmacion":0 }
    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Evento e) {
        try {
            ControllerEvento ce = new ControllerEvento();
            e = ce.save(e);
            if (e.getIdEvento() != 0) {
                return Response.ok(new Gson().toJson(e)).build();
            } else {
                return Response.ok("{\"response\": \"Error al crear el evento\"}").build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }

    // ── GET /evento/getAll/{idNegocio} ─────────────────────────────
    @GET
    @Path("/getAll/{idNegocio}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("idNegocio") int idNegocio) {
        try {
            ControllerEvento ce = new ControllerEvento();
            return Response.ok(new Gson().toJson(ce.getAllByNegocio(idNegocio))).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }

    // ── DELETE /evento/delete/{idEvento} ───────────────────────────
    @DELETE
    @Path("/delete/{idEvento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("idEvento") int idEvento) {
        try {
            ControllerEvento ce = new ControllerEvento();
            boolean ok = ce.delete(idEvento);
            String out = ok
                ? "{\"response\": \"Evento eliminado correctamente\"}"
                : "{\"response\": \"Error al eliminar el evento\"}";
            return Response.ok(out).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }
}