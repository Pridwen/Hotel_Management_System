/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Asus
 */

public class Booking extends JFrame implements ActionListener{
    JButton B1,B2;
    JTable T1;
    
    Booking(){
        JLabel L1 = new JLabel("History of Reservations");
        L1.setBounds(310,20,250,30);
        L1.setForeground(Color.BLACK);
        L1.setBackground(Color.WHITE);
        L1.setFont(new Font("serif",Font.PLAIN,24));
        add(L1);
        
        JLabel L3 = new JLabel("Code");
        L3.setFont(new Font("serif",Font.ITALIC,18));
        L3.setForeground(Color.DARK_GRAY);
        L3.setBounds(90,70,100,20);
        add(L3);
        JLabel L4 = new JLabel("Name and Surname");
        L4.setFont(new Font("serif",Font.ITALIC,18));
        L4.setForeground(Color.DARK_GRAY);
        L4.setBounds(280,70,150,20);
        add(L4);
        JLabel L5 = new JLabel("Room nr.");
        L5.setFont(new Font("serif",Font.ITALIC,18));
        L5.setForeground(Color.DARK_GRAY);
        L5.setBounds(470,70,100,20);
        add(L5);
        JLabel L7 = new JLabel("Review");
        L7.setFont(new Font("serif",Font.ITALIC,18));
        L7.setForeground(Color.DARK_GRAY);
        L7.setBounds(660,70,100,20);
        add(L7);
        
        B1 = new JButton("Fetch Logs");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(235,450,120,35);
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("Go Back");
        B2.setBackground(Color.BLACK);
        B2.setForeground(Color.WHITE);
        B2.setBounds(470,450,120,35);
        B2.addActionListener(this);
        add(B2);
        
        T1 = new JTable();
        T1.setBounds(90,100,700,325);
        T1.setBackground(Color.WHITE);
        add(T1);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,900,550);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            conn c = new conn();
            String str = "select * from booking";
            try{
                ResultSet rs = c.s.executeQuery(str);
                T1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(SQLException ae){}
        }else if(e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Booking().setVisible(true);
    }
        
}
