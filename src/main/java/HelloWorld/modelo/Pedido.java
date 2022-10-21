package HelloWorld.modelo;
import java.time.LocalDateTime;

public class Pedido {
    private String  numPedido;
    private Cliente  cliente;
    private Articulo  articulo;
    private Integer cantidad;
    private LocalDateTime fechaHora;
    public Pedido(String numPedido, Cliente cliente, Articulo articulo, Integer cantidad,  LocalDateTime fechaHora) {
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
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Articulo getArticulo() {
        return articulo;
    }
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public  LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora( LocalDateTime fechaHora) {
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
