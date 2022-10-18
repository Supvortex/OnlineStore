package HelloWorld.Modelo;

public class Cliente {
    private String  email;
    private String  nombre;
    private String  domicilio;
    private String  nif;
    private Boolean isPrem;

    public Cliente(String email, String nombre, String domicilio, String nif, Boolean isPrem) {
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.isPrem = isPrem;
    }
    public Cliente() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public Boolean getPrem() {
        return isPrem;
    }
    public void setPrem(Boolean prem) {
        isPrem = prem;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                ", isPrem=" + isPrem +
                '}';
    }
}
