package model;

public class Reserva {

    private int    idReservacion;
    private int    idCliente;
    private int    idEvento;
    private int    cantidadPersonas;
    private String estado;

    public int getIdReservacion()                           { return idReservacion; }
    public void setIdReservacion(int idReservacion)         { this.idReservacion = idReservacion; }

    public int getIdCliente()                               { return idCliente; }
    public void setIdCliente(int idCliente)                 { this.idCliente = idCliente; }

    public int getIdEvento()                                { return idEvento; }
    public void setIdEvento(int idEvento)                   { this.idEvento = idEvento; }

    public int getCantidadPersonas()                        { return cantidadPersonas; }
    public void setCantidadPersonas(int cantidadPersonas)   { this.cantidadPersonas = cantidadPersonas; }

    public String getEstado()                               { return estado; }
    public void setEstado(String estado)                    { this.estado = estado; }
}