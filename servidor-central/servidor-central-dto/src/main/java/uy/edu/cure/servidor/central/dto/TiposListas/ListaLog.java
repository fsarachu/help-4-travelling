package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Log;

import java.util.ArrayList;

/**
 * Created by victor on 03/12/16.
 */
public class ListaLog {
    private ArrayList<Log> logArrayList;

    public ListaLog() {
    }

    public ArrayList<Log> getLogArrayList() {
        return logArrayList;
    }

    public void setLogArrayList(ArrayList<Log> logArrayList) {
        this.logArrayList = logArrayList;
    }
}
