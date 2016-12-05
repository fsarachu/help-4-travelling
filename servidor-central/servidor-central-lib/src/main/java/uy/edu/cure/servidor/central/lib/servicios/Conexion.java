package uy.edu.cure.servidor.central.lib.servicios;


import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/help4Travelling";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1tvictor";
    private static Statement command;
    private static ResultSet data;
    private static Connection cnx;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/help4Travelling", "root", "1tvictor");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Imposible realizar Conexion con la BD");
        }
    }

    public static Connection obtener() throws SQLException, ClassNotFoundException {
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
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

    public void agregar(ArrayList<Reserva> reservas) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < reservas.size(); i++) {
            PreparedStatement comunicacion = obtener().prepareStatement("INSERT INTO Clientes (id, nickname, nombre, apellido, correo, fechaNacimiento, imagen)VALUES (?,?,?,?,?,?,?);");
            comunicacion.setInt(1, reservas.get(i).getId());
            comunicacion.setString(2, reservas.get(i).getCliente().getNickname());
            comunicacion.setString(3, reservas.get(i).getCliente().getNombre());
            comunicacion.setString(4, reservas.get(i).getCliente().getApellido());
            comunicacion.setString(5, reservas.get(i).getCliente().getCorreo());
            comunicacion.setDate(6, null);
            comunicacion.setString(7, reservas.get(i).getCliente().getImagen());
            comunicacion.executeUpdate();
        }
    }


    public Cliente buscarCliente(int idCliente) throws SQLException {
        PreparedStatement comunicacion = cnx.prepareStatement("SELECT id, nickname, nombre, apellido, correo FROM usuarios WHERE id=?");
        comunicacion.setString(1, String.valueOf(idCliente));
        ResultSet resultado = comunicacion.executeQuery();
        Cliente cliente = new Cliente();
        while (resultado.next()) {
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

    public static String getURL() {
        return URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static Statement getCommand() {
        return command;
    }

    public static void setCommand(Statement command) {
        Conexion.command = command;
    }

    public static ResultSet getData() {
        return data;
    }

    public static void setData(ResultSet data) {
        Conexion.data = data;
    }

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection cnx) {
        Conexion.cnx = cnx;
    }
}