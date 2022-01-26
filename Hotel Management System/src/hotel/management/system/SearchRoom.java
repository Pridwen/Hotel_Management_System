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

public class SearchRoom extends JFrame implements ActionListener{
    JComboBox C1;
    JCheckBox C2;
    JButton B1,B2;
    JTable T1;
    SearchRoom(){
        
        JLabel L1 = new JLabel("Search for a Room");
        L1.setForeground(Color.GREEN);
        L1.setBounds(400,20,250,30);
        L1.setFont(new Font("serif",Font.PLAIN,28));
        add(L1);
        
        JLabel L2 = new JLabel("Bed Type");
        L2.setForeground(Color.WHITE);
        L2.setFont(new Font("serif",Font.PLAIN,19));
        L2.setBounds(80,100,100,20);
        add(L2);
        
        String str[] = {"Single Bed","Double Bed","Queen Size"};
        C1 = new JComboBox(str);
        C1.setBounds(180,100,150,25);
        C1.setBackground(Color.WHITE);
        add(C1);
        
        C2 = new JCheckBox("Display Occupied");
        C2.setBackground(Color.BLACK);
        C2.setForeground(Color.WHITE);
        C2.setFont(new Font("serif",Font.PLAIN,19));
        C2.setBounds(600,100,180,25);
        add(C2);
        
        JLabel L3 = new JLabel("Room nr.");
        L3.setFont(new Font("serif",Font.ITALIC,20));
        L3.setForeground(Color.WHITE);
        L3.setBounds(10,160,100,20);
        add(L3);
        JLabel L4 = new JLabel("Availability");
        L4.setFont(new Font("serif",Font.ITALIC,20));
        L4.setForeground(Color.WHITE);
        L4.setBounds(250,160,150,20);
        add(L4);
        JLabel L5 = new JLabel("Status");
        L5.setBounds(480,160,80,20);
        L5.setFont(new Font("serif",Font.ITALIC,20));
        L5.setForeground(Color.WHITE);
        add(L5);
        JLabel L6 = new JLabel("Price for 3 nights");
        L6.setBounds(620,160,160,20);
        L6.setFont(new Font("serif",Font.ITALIC,20));
        L6.setForeground(Color.WHITE);
        add(L6);
        JLabel L7 = new JLabel("Bed type");
        L7.setBounds(910,160,100,20);
        L7.setFont(new Font("serif",Font.ITALIC,20));
        L7.setForeground(Color.WHITE);
        add(L7);
        
        B1 = new JButton("Search");
        B1.setBackground(Color.WHITE);
        B1.setForeground(Color.RED);
        B1.setBounds(350,600,120,30);
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("Go back");
        B2.setBackground(Color.WHITE);
        B2.setForeground(Color.BLACK);
        B2.setBounds(550,600,120,30);
        B2.addActionListener(this);
        add(B2);
        T1 = new JTable();
        T1.setBounds(0,200,1000,380);
        add(T1);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setBounds(500,200,1000,700);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            String type = (String) C1.getSelectedItem();
            String str2 = "select * from rooms where bed = '"+type+"'";
            String str1 = "select * from rooms where available = 'Available' AND bed = '"+type+"'";
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery(str1);
                T1.setModel(DbUtils.resultSetToTableModel(rs));
            if(C2.isSelected()){
                ResultSet rs2 = c.s.executeQuery(str2);
                T1.setModel(DbUtils.resultSetToTableModel(rs2));
            }
            }catch (SQLException ae){
                System.out.println(ae.getMessage());
            }
        }else if(e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new SearchRoom().setVisible(true);
    }
}
