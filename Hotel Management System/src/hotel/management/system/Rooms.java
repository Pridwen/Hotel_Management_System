/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Asus
 */
public class Rooms extends JFrame implements ActionListener{
    JTable T1;
    JButton B1,B2;
    Rooms(){
        
        T1 = new JTable();
        T1.setBounds(0,40,500,400);
        add(T1);
        
        JLabel L1 = new JLabel("Room nr.");
        L1.setBounds(10,10,100,20);
        add(L1);
        JLabel L2 = new JLabel("Availability");
        L2.setBounds(110,10,80,20);
        add(L2);
        JLabel L3 = new JLabel("Status");
        L3.setBounds(210,10,80,20);
        add(L3);
        JLabel L4 = new JLabel("Price for");
        L4.setBounds(310,5,60,20);
        add(L4);
        JLabel L5 = new JLabel("3 nights");
        L5.setBounds(310,15,100,20);
        add(L5);
        JLabel L6 = new JLabel("Bed type");
        L6.setBounds(410,10,100,20);
        add(L6);
        
        B1 = new JButton("Load Data");
        B1.setBounds(100,460,120,30);
        B1.setForeground(Color.WHITE);
        B1.setBackground(Color.BLACK);
        add(B1);
        B1.addActionListener(this);
        B2 = new JButton("Go Back");
        B2.setBounds(250,460,120,30);
        B2.setForeground(Color.WHITE);
        B2.setBackground(Color.BLACK);
        add(B2);
        B2.addActionListener(this);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/RoomRoom.jpg"));
        Image I2 = I1.getImage().getScaledInstance(530,600,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel icon = new JLabel(I3);
        icon.setBounds(480,0,571,600);
        add(icon);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,200,1000,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            try{
                conn c = new conn();
                String str = "select * from rm";
                ResultSet rs = c.s.executeQuery(str);
                T1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(SQLException ae){}
        }else if(e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Rooms().setVisible(true);
    }
}
