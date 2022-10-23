package HelloWorld.modelo;

import HelloWorld.constants.CostConstants;

public class ClientePremium extends Cliente{

    @Override
    public String tipoCliente() {
        return CostConstants.CLIENTE_PREMIUM;
    }
    @Override
    public float calcAnual() {
        return CostConstants.COSTE_ANUAL_PREM;
    }
    @Override
    public float descuentoEnv() {
        return CostConstants.DTO_ENVIO_PREM;
    }
    public ClientePremium(String email, String nombre, String domicilio, String nif) {
        super(email, nombre, domicilio, nif);
    }

    @Override
    public String toString() {

        return "Cliente Premium{" +
                "email='" + this.getEmail() + '\'' +
                ", nombre='" + this.getNombre() + '\'' +
                ", domicilio='" + this.getDomicilio() + '\'' +
                ", nif='" + this.getNif() + '\'' +
                '}';
    }
}
