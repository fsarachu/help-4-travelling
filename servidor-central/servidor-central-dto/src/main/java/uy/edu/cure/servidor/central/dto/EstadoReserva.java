package uy.edu.cure.servidor.central.dto;

public enum EstadoReserva {
    registrada,
    cancelada,
    pagada,
    facturada;

    public static EstadoReserva getEnum(Integer s){
        if(s == 1){
            return registrada;
        }else if(s == 2){
            return cancelada;
        }else if(s == 3){
            return pagada;
        }else if (s == 4){
            return facturada;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
