/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Asus
 */

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.cj.log.Slf4JLogger");
            c = DriverManager.getConnection("jdbc:mysql:///HMS","root","crumpeius");
            s = c.createStatement();
        }catch(ClassNotFoundException | SQLException e){}
    }
}
