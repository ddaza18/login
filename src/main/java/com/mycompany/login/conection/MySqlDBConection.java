/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.conection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class MySqlDBConection implements Closeable {

    //Declaramos la instancia
    private static MySqlDBConection instance;

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/db_api?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection connection; 
    private PreparedStatement preparedStatement;
    
    //CONSTRUCCTOR  //REALIZAMOS TAMBIEN LA DOBLE EXCEPCION
    private MySqlDBConection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection( URL,USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException exeption) {
            Logger.getLogger(MySqlDBConection.class.getName()).log(Level.SEVERE, null, exeption);
        }
    }

    //RETORNAMOS LA INSTANCIA
    public static MySqlDBConection getInstance() {
        //retornamos si la instancia es nula 
        return instance == null ? new MySqlDBConection() : instance;
    }
    //CREAMOS UN METODO PREPARESTATEMENT Y GENERAMOS LA EXEPCION
    public ResultSet executeQuery(final String query) throws SQLException{
        this.preparedStatement = connection.prepareStatement(query);
        return this.preparedStatement.executeQuery();
    }

    //CREAMOS LA CONEXION A LA BD Y AGREGAMOS LA EXEPCION
    @Override
    public void close() throws IOException {
        try {
            if (connection.isClosed()){
                this.connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlDBConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
