package HelloWorld.Modelo;
import java.util.Date;

public class Pedido {
    private String  numPedido;
    private String  cliente;
    private String  articulo;
    private Integer cantidad;
    private Date    fechaHora;
    public Pedido(String numPedido, String cliente, String articulo, Integer cantidad, Date fechaHora) {
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaHora = fechaHora;
    }
    public Pedido() {
    }
    public String getNumPedido() {
        return numPedido;
    }
    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getArticulo() {
        return articulo;
    }
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "numPedido='" + numPedido + '\'' +
                ", cliente='" + cliente + '\'' +
                ", articulo='" + articulo + '\'' +
                ", cantidad=" + cantidad +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
