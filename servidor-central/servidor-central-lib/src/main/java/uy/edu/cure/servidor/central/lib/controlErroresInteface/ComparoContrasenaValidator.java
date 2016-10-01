package uy.edu.cure.servidor.central.lib.controlErroresInteface;

public class ComparoContrasenaValidator {


    public boolean passwordCorrecto(char[] j1,char[] j2) {
        boolean valor = false;
        int puntero = 0;
        if (j1.length != j2.length){
            valor = false;
        }
        else{
            while((!valor)&&(puntero < j1.length)){
                if (j1[puntero] != j2[puntero]){
                    valor = false;
                }
                else{
                    valor = true;
                }
            }
        }
        return valor;
    }

}
