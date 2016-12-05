package uy.edu.cure.servidor.central.dto;

public enum EstadoFactura {
    pendiente,
    facturada;

    public static EstadoFactura getEstado(String estado){
        EstadoFactura res = null;
        switch ( estado ){
            case "pendiente":
                    res = EstadoFactura.pendiente;
                break;
            case "facturada":
                    res = EstadoFactura.facturada;
                break;
            default:
                res = null;
                break;
        }
        return res;
    }

    public static String getEstado(EstadoFactura estadoFactura){
        String res = null;
        switch ( estadoFactura ){
            case pendiente:
                res = "pendiente";
                break;
            case facturada:
                res = "facturada";
                break;
            default:
                res = null;
                break;
        }
        return res;
    }

}

