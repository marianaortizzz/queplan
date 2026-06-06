package model;

public class Evento {

    private int     idEvento;
    private int     idNegocio;
    private String  nombre;
    private String  fechaHora;
    private String  ubicacion;
    private double  precio;
    private String  descripcion;
    private String  categoria;
    private int     cupo;
    private int     tieneEstacionamiento;
    private int     requiereAnticipo;
    private double  montoAnticipo;
    private int     autoconfirmacion;
    private String  estado;

    public int getIdEvento()                            { return idEvento; }
    public void setIdEvento(int idEvento)               { this.idEvento = idEvento; }

    public int getIdNegocio()                           { return idNegocio; }
    public void setIdNegocio(int idNegocio)             { this.idNegocio = idNegocio; }

    public String getNombre()                           { return nombre; }
    public void setNombre(String nombre)                { this.nombre = nombre; }

    public String getFechaHora()                        { return fechaHora; }
    public void setFechaHora(String fechaHora)          { this.fechaHora = fechaHora; }

    public String getUbicacion()                        { return ubicacion; }
    public void setUbicacion(String ubicacion)          { this.ubicacion = ubicacion; }

    public double getPrecio()                           { return precio; }
    public void setPrecio(double precio)                { this.precio = precio; }

    public String getDescripcion()                      { return descripcion; }
    public void setDescripcion(String descripcion)      { this.descripcion = descripcion; }

    public String getCategoria()                        { return categoria; }
    public void setCategoria(String categoria)          { this.categoria = categoria; }

    public int getCupo()                                { return cupo; }
    public void setCupo(int cupo)                       { this.cupo = cupo; }

    public int getTieneEstacionamiento()                                { return tieneEstacionamiento; }
    public void setTieneEstacionamiento(int tieneEstacionamiento)       { this.tieneEstacionamiento = tieneEstacionamiento; }

    public int getRequiereAnticipo()                        { return requiereAnticipo; }
    public void setRequiereAnticipo(int requiereAnticipo)   { this.requiereAnticipo = requiereAnticipo; }

    public double getMontoAnticipo()                        { return montoAnticipo; }
    public void setMontoAnticipo(double montoAnticipo)      { this.montoAnticipo = montoAnticipo; }

    public int getAutoconfirmacion()                        { return autoconfirmacion; }
    public void setAutoconfirmacion(int autoconfirmacion)   { this.autoconfirmacion = autoconfirmacion; }

    public String getEstado()                           { return estado; }
    public void setEstado(String estado)                { this.estado = estado; }
}