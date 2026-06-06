package rest;

import com.google.gson.Gson;
import controller.ControllerNegocio;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Negocio;

@Path("/negocio")
public class RestNegocio {

    // ── POST /negocio/registro ─────────────────────────────────────
    // Body: { "usuario":"minego", "nombreNegocio":"Mi Rest",
    //         "nombreDueno":"Gus", "passwordHash":"123456" }
    @POST
    @Path("/registro")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registro(Negocio n) {
        try {
            ControllerNegocio cn = new ControllerNegocio();
            n = cn.save(n);
            if (n.getIdNegocio() != 0) {
                return Response.ok(new Gson().toJson(n)).build();
            } else {
                return Response.ok("{\"response\": \"Error al registrar el negocio\"}").build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }

    // ── POST /negocio/login ────────────────────────────────────────
    // Body: { "usuario":"minego", "passwordHash":"123456" }
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Negocio n) {
        try {
            ControllerNegocio cn = new ControllerNegocio();
            Negocio resultado = cn.login(n.getUsuario(), n.getPasswordHash());
            if (resultado != null) {
                return Response.ok(new Gson().toJson(resultado)).build();
            } else {
                return Response.ok("{\"response\": \"Usuario o password incorrectos\"}").build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }

    // ── PUT /negocio/actualizar ────────────────────────────────────
    // Body: { "idNegocio":1, "descripcion":"...", "logoUrl":"...",
    //         "telefono":"...", "direccion":"...", "instagram":"...",
    //         "facebook":"...", "tiktok":"...", "paginaWeb":"..." }
    @PUT
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Negocio n) {
        try {
            ControllerNegocio cn = new ControllerNegocio();
            n = cn.update(n);
            return Response.ok(new Gson().toJson(n)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.ok("{\"response\": \"Error: " + ex.getMessage() + "\"}").build();
        }
    }
}