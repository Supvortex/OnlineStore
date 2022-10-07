package org.UOC.Modelo;

public class Articulo {
    private String  codigo;
    private String  descripcion;
    private Double  pvp;
    private Double  gastoEnvio;
    private Integer tiempoEnvio;
    public Articulo(String codigo, String descripcion, Double pvp, Double gastoEnvio, Integer tiempoEnvio) {
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
    public Double getPvp() {
        return pvp;
    }
    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }
    public Double getGastoEnvio() {
        return gastoEnvio;
    }
    public void setGastoEnvio(Double gastoEnvio) {
        this.gastoEnvio = gastoEnvio;
    }
    public Integer getTiempoEnvio() {
        return tiempoEnvio;
    }
    public void setTiempoEnvio(Integer tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
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
