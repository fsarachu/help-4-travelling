package uy.edu.cure.servidor.web;

import com.codebox.bean.JavaBeanTester;
import junit.framework.TestCase;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import org.apache.commons.lang3.SerializationUtils;
import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.*;

import javax.faces.bean.ManagedProperty;

import java.beans.IntrospectionException;
import java.util.Date;

import static nl.jqno.equalsverifier.EqualsVerifier.forClass;


public class CarritoBeanTest extends TestCase{

    private CarritoBean myBean;
    private Carrito carrito;
    @ManagedProperty("#{servicioBean}")
    private ServicioBean servicioBean;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    @ManagedProperty("#{reservaBean}")
    private ReservaBean reservaBean;
    private Integer cantidad;
    private Date fechaInicio;
    private Date fechaFin;
    private String mensaje;
    private Double itemCantidad;
    private Double itemPrecio;

    @Before
    public void setUp() throws Exception {
        Hardcodeo jarcodeo = new Hardcodeo();

        myBean = new CarritoBean();


        CarritoController carritoController = new CarritoController();
        myBean.setCarrito(carritoController.obtenerCarrito(1) );

        ReservaController reservaController = new ReservaController();

        ReservaBean reservaBean = new ReservaBean();
        myBean.setReservaBean( reservaBean );
        this.reservaBean = reservaBean;

        myBean.getReservaBean().setReserva( reservaController.obtener(1) );

        this.loginBean = new LoginBean();
        myBean.setLoginBean( loginBean );

        ClienteController clienteController = new ClienteController();
        loginBean.setCliente( clienteController.obtener(1) );
        myBean.setCantidad(1);

        ProductoController productoController = new ProductoController();
        ServicioBean servicioBean = new ServicioBean();
        servicioBean.setServicio( (Servicio)productoController.obtener( 1 ) );
        myBean.setServicioBean( servicioBean );
    }

    @Test
    public void testAgregar() {
        reservaBean.cantReservas(loginBean.getCliente().getId());
        int cant1 = reservaBean.getCantidadReservas();
        myBean.agregar();
        int cant2 = reservaBean.getCantidadReservas();
        assertEquals(cant1 +1 , cant2 ); // FAIL

    }
    @Test
    public void testGetCarrito(){
        myBean.setCarrito(null);
        assertTrue( null != myBean.getCarrito() );

        Carrito carrito = new Carrito();
        myBean.setCarrito(null);
        myBean.setCarrito(carrito);
        assertEquals(carrito, myBean.getCarrito() );
    }

    @Test
    public void testBeanProperties() throws IllegalAccessException, IntrospectionException, InstantiationException {
        //JavaBeanTester.test(CarritoBean.class);
        JavaBeanTester.test(CarritoBean.class, Carrito.class, false, false, "msj");
    }
    @Test
    public void testBeanIsSerializable() {
        final byte[] serializedMyBean = SerializationUtils.serialize(myBean);
        final CarritoBean deserializedMyBean = (CarritoBean) SerializationUtils.deserialize(serializedMyBean);
        assertEquals(myBean, deserializedMyBean);
    }
    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(CarritoBean.class).suppress( Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
}
