package model;

public class Negocio {

    private int    idNegocio;
    private String usuario;
    private String nombreNegocio;
    private String nombreDueno;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String logoUrl;
    private String passwordHash;
    private String instagram;
    private String facebook;
    private String tiktok;
    private String paginaWeb;

    public int getIdNegocio()                           { return idNegocio; }
    public void setIdNegocio(int idNegocio)             { this.idNegocio = idNegocio; }

    public String getUsuario()                          { return usuario; }
    public void setUsuario(String usuario)              { this.usuario = usuario; }

    public String getNombreNegocio()                    { return nombreNegocio; }
    public void setNombreNegocio(String nombreNegocio)  { this.nombreNegocio = nombreNegocio; }

    public String getNombreDueno()                      { return nombreDueno; }
    public void setNombreDueno(String nombreDueno)      { this.nombreDueno = nombreDueno; }

    public String getDireccion()                        { return direccion; }
    public void setDireccion(String direccion)          { this.direccion = direccion; }

    public String getTelefono()                         { return telefono; }
    public void setTelefono(String telefono)            { this.telefono = telefono; }

    public String getDescripcion()                      { return descripcion; }
    public void setDescripcion(String descripcion)      { this.descripcion = descripcion; }

    public String getLogoUrl()                          { return logoUrl; }
    public void setLogoUrl(String logoUrl)              { this.logoUrl = logoUrl; }

    public String getPasswordHash()                     { return passwordHash; }
    public void setPasswordHash(String passwordHash)    { this.passwordHash = passwordHash; }

    public String getInstagram()                        { return instagram; }
    public void setInstagram(String instagram)          { this.instagram = instagram; }

    public String getFacebook()                         { return facebook; }
    public void setFacebook(String facebook)            { this.facebook = facebook; }

    public String getTiktok()                           { return tiktok; }
    public void setTiktok(String tiktok)                { this.tiktok = tiktok; }

    public String getPaginaWeb()                        { return paginaWeb; }
    public void setPaginaWeb(String paginaWeb)          { this.paginaWeb = paginaWeb; }
}