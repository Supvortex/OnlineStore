package HelloWorld.Modelo;

import HelloWorld.Constants.CostConstants;

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
}
