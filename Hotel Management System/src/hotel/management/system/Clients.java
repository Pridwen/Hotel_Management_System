/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.*;

/**
 *
 * @author Asus
 */

public class Clients extends JFrame implements ActionListener{
    JTable T1;
    JButton B1,B2;
    Clients(){
        
        T1 = new JTable();
        T1.setBounds(0,40,1000,500);
        add(T1);
        
        JLabel L1 = new JLabel("Document");
        L1.setBounds(20,10,70,20);
        add(L1);
        JLabel L2 = new JLabel("Reservation Code");
        L2.setBounds(150,10,110,20);
        add(L2);
        JLabel L3 = new JLabel("Name and Surname");
        L3.setBounds(300,10,150,20);
        add(L3);
        JLabel L4 = new JLabel("Gender");
        L4.setBounds(460,10,70,20);
        add(L4);
        JLabel L5 = new JLabel("Country");
        L5.setBounds(600,10,70,20);
        add(L5);
        JLabel L6 = new JLabel("Room number");
        L6.setBounds(730,10,90,20);
        add(L6);
        JLabel L7 = new JLabel("Checked");
        L7.setBounds(900,10,70,20);
        add(L7);
        
        B1 = new JButton("Load Data");
        B1.setBounds(350,560,120,30);
        B1.setForeground(Color.WHITE);
        B1.setBackground(Color.BLACK);
        add(B1);
        B1.addActionListener(this);
        B2 = new JButton("Go Back");
        B2.setBounds(530,560,120,30);
        B2.setForeground(Color.WHITE);
        B2.setBackground(Color.BLACK);
        add(B2);
        B2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,200,1000,650);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            try{
                conn c = new conn();
                String str = "select * from cl";
                ResultSet rs = c.s.executeQuery(str);
                T1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (SQLException ae){}
        }else if(e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Clients().setVisible(true);
    }
}

