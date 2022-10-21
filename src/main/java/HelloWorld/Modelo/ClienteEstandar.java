package HelloWorld.Modelo;

import HelloWorld.Constants.CostConstants;

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
}
