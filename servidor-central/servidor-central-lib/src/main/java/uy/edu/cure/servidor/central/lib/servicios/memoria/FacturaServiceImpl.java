package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.lib.servicios.FacturaService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.OverridesAttribute;

public class FacturaServiceImpl extends GenericServiceImpl<Factura> implements FacturaService{
    private static FacturaServiceImpl ourInstance = new FacturaServiceImpl();

    public static FacturaServiceImpl getInstance() {
        return ourInstance;
    }

    private FacturaServiceImpl() {
        super();
    }

    @Override
    public void agregar(Integer id, Factura factura){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("UnidadFactura");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(factura);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

    @Override
    public Integer nextId() {
        return null;
    }
}