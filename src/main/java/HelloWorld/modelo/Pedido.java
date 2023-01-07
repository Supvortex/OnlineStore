package HelloWorld.modelo;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.time.LocalDateTime;

public class Pedido {
    private String  numPedido;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente  cliente;
    @ManyToOne(fetch = FetchType.LAZY)
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


    public Boolean pedidoEnviado(){
        if (Duration.between(this.getFechaHora(), LocalDateTime.now()).getSeconds() > (this.getArticulo().getTiempoEnvio() * 60)) {
            return true;
        } else {
            return false;
        }
    }
    public float precioEnvio(){
        return this.articulo.getGastoEnvio();
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "numPedido='" + numPedido + '\'' +
                ", fechaHora=" + fechaHora +
                ", nif cliente='" + cliente.getNif() + '\'' +
                ", nombre cliente='" + cliente.getNombre() + '\'' +
                ", código articulo='" + articulo.getCodigo() + '\'' +
                ", descripción articulo='" + articulo.getDescripcion() + '\'' +
                ", cantidad=" + cantidad +
                ", precio articulo='" + articulo.getPvp() + '\'' +
                ", gastos envio='" + articulo.getGastoEnvio() + '\'' +
                ", gasto total='" + articulo.precioTotal() + '\'' +
                ", pedido enviado='" + pedidoEnviado().toString() + '\'' +
                '}';
    }
}
