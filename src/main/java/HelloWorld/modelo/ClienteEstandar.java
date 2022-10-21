package HelloWorld.modelo;

import HelloWorld.constants.CostConstants;

public class ClienteEstandar extends Cliente{

    @Override
    public String tipoCliente() {
        return CostConstants.CLIENTE_ESTANDAR;
    }

    @Override
    public float calcAnual() {
        return CostConstants.COSTE_ANUAL_ESTANDAR;
    }

    @Override
    public float descuentoEnv() {
        return CostConstants.DTO_ENVIO_ESTANDAR;
    }

    public ClienteEstandar(String email, String nombre, String domicilio, String nif) {
        super(email, nombre, domicilio, nif);
    }
}
