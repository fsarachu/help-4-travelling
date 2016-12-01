package uy.edu.cure.servidor.central.lib.servicios.memoria;

import java.sql.*;
import java.util.Properties;

import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.lib.servicios.FacturaService;

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

	@Override
	public void agregar(Integer id, Factura factura) {
		//String url = "jdbc:postgresql://localhost/cure-pa";
        String url = "jdbc:postgresql://127.0.0.1:5432/curepa";

		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "1234");

        Statement stmt = null;
        String query = "INSERT INTO facturas VALUES (2, 'soy un string')";

		try {
            Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, props);

            stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery(query);
            Boolean rs = stmt.execute(query);




		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public Integer nextId() {
		return null;
	}
}