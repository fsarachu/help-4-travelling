package uy.edu.cure.servidor.central.lib.servicios.memoria;

public class ReservaServiceImpl {

    private static ReservaServiceImpl ourInstance = new ReservaServiceImpl();

    public static ReservaServiceImpl getInstance() {
        return ourInstance;
    }

    private ReservaServiceImpl() {
        super();
    }
}
