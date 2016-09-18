package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ItemReservaServiceImpl;

import java.util.ArrayList;

public class ItemReservaServiceTest extends TestCase {

    private ItemReservaService itemReservaService;

    @BeforeClass
    public void setUp() {
        this.itemReservaService = ItemReservaServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        ItemReserva itemReserva = new ItemReserva();
        itemReserva.setId(1);
        itemReserva.setCantidad(2);

        this.itemReservaService.agregar(itemReserva.getId(), itemReserva);

        assertEquals(itemReserva, this.itemReservaService.obtener(1));

    }


    public void testEliminar() throws Exception {
        ItemReserva itemReserva = new ItemReserva();
        itemReserva.setId(101);
        itemReserva.setCantidad(2);

        this.itemReservaService.eliminar(101);

        assertNull(this.itemReservaService.obtener(101));
    }

    public void testModificar() throws Exception {
        ItemReserva itemReserva = new ItemReserva();
        itemReserva.setId(101);
        itemReserva.setCantidad(2);

        ItemReserva itemReserva1 = new ItemReserva();
        itemReserva1.setId(101);
        itemReserva1.setCantidad(4);

        this.itemReservaService.agregar(itemReserva.getId(), itemReserva);
        this.itemReservaService.modificar(itemReserva1.getId(), itemReserva1);

        assertEquals(itemReserva1, itemReservaService.obtener(101));
    }

    public void testObtener() throws Exception {
        ItemReserva itemReserva = new ItemReserva();
        itemReserva.setId(101);
        itemReserva.setCantidad(2);

        this.itemReservaService.agregar(101, itemReserva);

        assertEquals(itemReserva, itemReservaService.obtener(101));

    }

    public void testListar() throws Exception {
        ArrayList<ItemReserva> expected = new ArrayList<>();

        ItemReserva itemReserva1 = new ItemReserva();
        itemReserva1.setId(1);
        itemReserva1.setCantidad(2);

        ItemReserva itemReserva2 = new ItemReserva();
        itemReserva2.setId(2);
        itemReserva2.setCantidad(4);

        expected.add(itemReserva1);
        expected.add(itemReserva2);

        for (ItemReserva itemReserva : expected) {
            this.itemReservaService.agregar(itemReserva.getId(), itemReserva);
        }

        ArrayList<ItemReserva> actual = itemReservaService.listar();

        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

    @Test
    public void testNextId() throws Exception {
        int num1 = itemReservaService.nextId();
        ItemReserva itemReserva1 = new ItemReserva();
        itemReserva1.setId( num1 );
        itemReservaService.agregar(itemReserva1.getId(), itemReserva1);

        int num2 = itemReservaService.nextId();
        ItemReserva itemReserva2 = new ItemReserva();
        itemReserva2.setId( num2 );
        itemReservaService.agregar(itemReserva2.getId(), itemReserva2);


        assertNotSame(num1, num2);

    }

}