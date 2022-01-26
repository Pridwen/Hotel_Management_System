/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 *
 * @author Asus
 */

public class Reception extends JFrame implements ActionListener{
    JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11;
    Reception(){
        
        B1 = new JButton("New Client Reservation");
        B1.setBackground(Color.BLUE);
        B1.setForeground(Color.WHITE);
        B1.addActionListener(this);
        B1.setBounds(10,30,200,30);
        add(B1);
        
        B2 = new JButton("Display Rooms");
        B2.setBackground(Color.CYAN);
        B2.setForeground(Color.WHITE);
        B2.addActionListener(this);
        B2.setBounds(10,80,200,30);
        add(B2);
        
        B3 = new JButton("Booking History");
        B3.setBackground(Color.GREEN);
        B3.setForeground(Color.WHITE);
        B3.addActionListener(this);
        B3.setBounds(10,120,200,30);
        add(B3);
        
        B4 = new JButton("Display Manager");
        B4.setBackground(Color.DARK_GRAY);
        B4.setForeground(Color.WHITE);
        B4.addActionListener(this);
        B4.setBounds(10,170,200,30);
        add(B4);
        
        B5 = new JButton("Display Employees");
        B5.setBackground(Color.GRAY);
        B5.setForeground(Color.WHITE);
        B5.addActionListener(this);
        B5.setBounds(10,210,200,30);
        add(B5);
        
        B6 = new JButton("Display Clients");
        B6.setBackground(Color.LIGHT_GRAY);
        B6.setForeground(Color.WHITE);
        B6.addActionListener(this);
        B6.setBounds(10,250,200,30);
        add(B6);
        
        B7 = new JButton("Check Out");
        B7.setBackground(Color.ORANGE);
        B7.setForeground(Color.WHITE);
        B7.addActionListener(this);
        B7.setBounds(10,300,200,30);
        add(B7);
        
        B8 = new JButton("Update Room Status");
        B8.setBackground(Color.ORANGE);
        B8.setForeground(Color.WHITE);
        B8.addActionListener(this);
        B8.setBounds(10,350,200,30);
        add(B8);
        
        B9 = new JButton("Search Room");
        B9.setBackground(Color.MAGENTA);
        B9.setForeground(Color.WHITE);
        B9.addActionListener(this);
        B9.setBounds(10,400,200,30);
        add(B9);
        
        B10 = new JButton("Logout");
        B10.setBackground(Color.RED);
        B10.setForeground(Color.WHITE);
        B10.addActionListener(this);
        B10.setBounds(10,450,200,30);
        add(B10);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/Reception.jpg"));
        JLabel L1 = new JLabel(I1);
        L1.setBounds(250,30,500,480);
        add(L1);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(525,250,800,600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            new AddClient().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B2){
            new Rooms().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B3){
            new Booking().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B4){
            new Manager().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B5){
            new Employees().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B6){
            new Clients().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B7){
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B8){
            new UpdateRoomStatus().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B9){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B10){
            JOptionPane.showMessageDialog(null, "Have a nice day!");
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Reception().setVisible(true);
    }
}
