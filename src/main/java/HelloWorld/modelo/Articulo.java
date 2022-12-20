package HelloWorld.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
//@Table(name = "Articulo")
public class Articulo implements Serializable {
    //@Id
    //@Column(name = "codigo")
    private String  codigo;
    //@Column(name = "descripcion")
    private String  descripcion;
    //@Column(name = "pvp")
    private float  pvp;
    //@Column(name = "gastoenvio")
    private float  gastoEnvio;
    //Column(name = "tiempoenvio")
    private int tiempoEnvio;

    public Articulo(String codigo, String descripcion, float pvp, float gastoEnvio, int tiempoEnvio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.gastoEnvio = gastoEnvio;
        this.tiempoEnvio = tiempoEnvio;
    }
    public Articulo() {
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPvp() {
        return pvp;
    }
    public void setPvp(float pvp) {
        this.pvp = pvp;
    }
    public float getGastoEnvio() {
        return gastoEnvio;
    }
    public void setGastoEnvio(float gastoEnvio) {
        this.gastoEnvio = gastoEnvio;
    }
    public int getTiempoEnvio() {
        return tiempoEnvio;
    }
    public void setTiempoEnvio(int tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    public float precioTotal(){
        return (this.pvp + this.gastoEnvio);
    }


    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", pvp=" + pvp +
                ", gastoEnvio=" + gastoEnvio +
                ", tiempoEnvio=" + tiempoEnvio +
                '}';
    }
}
