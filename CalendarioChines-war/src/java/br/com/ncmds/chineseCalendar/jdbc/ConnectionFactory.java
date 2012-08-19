/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ncmds.chineseCalendar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juliano
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/"
                    + "chinese_calendar_bd","root","");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}