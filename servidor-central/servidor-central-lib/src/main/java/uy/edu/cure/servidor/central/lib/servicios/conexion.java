package uy.edu.cure.servidor.central.lib.servicios;


import uy.edu.cure.servidor.central.dto.Cliente;

import java.sql.*;

public class conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/help4Travelling";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1tvictor";
    private static Statement command;
    private static ResultSet data;
    private static Connection cnx;

    public conexion() {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/help4Travelling", "root", "1tvictor");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Imposible realizar conexion con la BD");
        }*/
    }

  /*  public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/help4Travelling", "root", "1tvictor");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }*/

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
  public void agregar(){

      System.out.print("Estoy aqui");
  }
    public Cliente buscarCliente(int idCliente) throws SQLException{
        PreparedStatement comunicacion=cnx.prepareStatement("SELECT id, nickname, nombre, apellido, correo FROM usuarios WHERE id=?");
        comunicacion.setString(1,String.valueOf(idCliente));
        ResultSet resultado=comunicacion.executeQuery();
        Cliente cliente= new Cliente();
        while(resultado.next()){
            String nickname = resultado.getString("nickname");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            String correo = resultado.getString("correo");
            cliente.setNickname(nickname);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCorreo(correo);
        }
        return cliente;
    }
}