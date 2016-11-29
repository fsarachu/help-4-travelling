package uy.edu.cure.servidor.central.lib.servicios.memoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		String url = "jdbc:postgresql://localhost/cure-pa";
		Properties props = new Properties();
		props.setProperty("user", "fred");
		props.setProperty("password", "secret");
		try {
			Connection con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer nextId() {
		return null;
	}
}