package uy.edu.cure.servidor.central.lib.servicios.memoria;

import java.sql.*;
import java.util.Properties;

import jdk.nashorn.internal.ir.JumpToInlinedFinally;
import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.FacturaService;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.conexion;

/**
 * 
 * @author fvillegas
 * @see https://jdbc.postgresql.org/documentation/80/connect.html
 * @see https://www.mkyong.com/jdbc/jdbc-statement-example-insert-a-record/
 * 
 * Statement stmt = null;
 *   String query = "select COF_NAME, SUP_ID, PRICE, " +
 *                  "SALES, TOTAL " +
 *                  "from " + dbName + ".COFFEES";
 * try {
 *   stmt = con.createStatement();
 *   ResultSet rs = stmt.executeQuery(query);
 *   while (rs.next()) {
 *       String coffeeName = rs.getString("COF_NAME");
 *       int supplierID = rs.getInt("SUP_ID");
 *       float price = rs.getFloat("PRICE");
 *       int sales = rs.getInt("SALES");
 *       int total = rs.getInt("TOTAL");
 *       System.out.println(coffeeName + "\t" + supplierID +
 *                          "\t" + price + "\t" + sales +
 *                          "\t" + total);
 *   }
 * }
 */
public class FacturaServiceImpl extends GenericServiceImpl<Factura> implements FacturaService {

	private static FacturaServiceImpl ourInstance = new FacturaServiceImpl();

	public static FacturaServiceImpl getInstance() {
		return ourInstance;
	}

	private FacturaServiceImpl() {
		super();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
        //String url = "jdbc:postgresql://localhost/cure-pa";
		String url = "jdbc:postgresql://127.0.0.1:5432/curepa";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "1234");
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, props);
            connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ClassNotFoundException("Class.forName(\"org.postgresql.Driver\")") ;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("DriverManager.getConnection(url, props)");
		}
		return connection;
	}

	@Override
	public void agregar(Integer id, Factura factura) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            /* Identificador numérico, la fecha de generada, el identificador de la reserva correspondiente,
                    el monto total de la reserva y el nick del cliente que la hizo.
               Además, interesa conocer la cantidades, precios y nombres de los servicios/promociones involucrados en la reserva,
                    así como los nombres de los proveedores.
            */
            String statement = "INSERT INTO facturas (fecha, reserva, estado) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement( statement );
                java.sql.Date sqlDate = new java.sql.Date( factura.getFecha().getTime() );
            preparedStatement.setDate( 1, sqlDate );
            if(factura.getReserva() != null){ //ya se lo asqueroso de esto
                if(factura.getReserva().getId() != null){
                    preparedStatement.setLong( 2, factura.getReserva().getId() );
                }else{
                    //exception
                }
            }
            preparedStatement.setString( 3, factura.getEstado().toString()  );

            Boolean result = preparedStatement.execute();
            connection.commit();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
		}finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Factura getFacturaXidReserva(Reserva reserva){
        return getFacturaXidReserva( reserva.getId());

    }
    public Factura getFacturaXidReserva(Integer idReserva){
        Factura factura = null;



        Reserva reserva = null;
        reserva = ReservaServiceImpl.getInstance().obtener( idReserva );
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            /*String statement = "INSERT INTO facturas VALUES (null, ?, ?, ?)";
            preparedStatement = connection.prepareStatement( statement );
            preparedStatement.setDate(1, (Date)factura.getFecha() );
            preparedStatement.setLong( 2, factura.getReserva().getId() );
            preparedStatement.setString( 3, factura.getEstado().toString()  );


            Boolean result = preparedStatement.execute();*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return factura;
    }

	@Override
	public Integer nextId() {
		return null;
	}
}