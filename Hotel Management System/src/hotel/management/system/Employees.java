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

public class Employees extends JFrame implements ActionListener{
    JTable T1;
    JButton B1,B2;
    Employees(){
        
        T1 = new JTable();
        T1.setBounds(0,40,1000,500);
        add(T1);
        
        JLabel L1 = new JLabel("ID");
        L1.setBounds(40,10,70,20);
        add(L1);
        JLabel L2 = new JLabel("Manager ID");
        L2.setBounds(130,10,70,20);
        add(L2);
        JLabel L3 = new JLabel("Name");
        L3.setBounds(260,10,70,20);
        add(L3);
        JLabel L4 = new JLabel("Age");
        L4.setBounds(360,10,70,20);
        add(L4);
        JLabel L5 = new JLabel("Gender");
        L5.setBounds(470,10,70,20);
        add(L5);
        JLabel L6 = new JLabel("Department");
        L6.setBounds(570,10,70,20);
        add(L6);
        JLabel L7 = new JLabel("Salary");
        L7.setBounds(680,10,70,20);
        add(L7);
        JLabel L8 = new JLabel("Phone");
        L8.setBounds(790,10,70,20);
        add(L8);
        JLabel L9 = new JLabel("E-mail");
        L9.setBounds(900,10,70,20);
        add(L9);
        
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
        setBounds(450,200,1100,650);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            try{
                conn c = new conn();
                String str = "select * from emp";
                ResultSet rs = c.s.executeQuery(str);
                T1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (SQLException ae){}
        }else if(e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Employees().setVisible(true);
    }
}
