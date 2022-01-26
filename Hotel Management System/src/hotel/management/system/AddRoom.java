/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */

public class AddRoom extends JFrame implements ActionListener{
    JTextField T1,T2;
    JComboBox C1,C2,C3;  
    JButton B1,B2;
            
    AddRoom(){
        JLabel L1 = new JLabel("Add Room");
        L1.setFont(new Font("serif",Font.ITALIC,18));
        L1.setBounds(180,40,100,20);
        add(L1);
        
        JLabel room = new JLabel("Room Nr.");
        room.setFont(new Font("serif",Font.PLAIN,16));
        room.setBounds(60,80,120,30);
        add(room);
        T1 = new JTextField("3_digit_nr");
        T1.setBounds(170,80,120,30);
        add(T1);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("serif",Font.PLAIN,16));
        available.setBounds(60,130,120,30);
        add(available);
        String str1[] = {"Available","Occupied"};
        C1 = new JComboBox(str1);
        C1.setBackground(Color.WHITE);
        C1.setBounds(170,130,120,30);
        add(C1);
        
        JLabel status = new JLabel("Cleaned");
        status.setFont(new Font("serif",Font.PLAIN,16));
        status.setBounds(60,190,120,30);
        add(status);
        String str2[] = {"Cleaned","Dirty"};
        C2 = new JComboBox(str2);
        C2.setBackground(Color.WHITE);
        C2.setBounds(170,190,120,30);
        add(C2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("serif",Font.PLAIN,16));
        price.setBounds(60,250,120,30);
        add(price);
        T2 = new JTextField("5_digit_nr");
        T2.setBounds(170,250,120,30);
        add(T2);
        
        JLabel type = new JLabel("Bed Size");
        type.setFont(new Font("serif",Font.PLAIN,16));
        type.setBounds(60,300,120,30);
        add(type);
        String str3[] = {"Single Bed","Double Bed","Queen Size"};
        C3 = new JComboBox(str3);
        C3.setBackground(Color.WHITE);
        C3.setBounds(170,300,120,30);
        add(C3);
        
        B1 = new JButton("Add Room");
        B1.setBounds(60,350,130,30);
        B1.addActionListener(this);
        B1.setForeground(Color.WHITE);
        B1.setBackground(Color.BLACK);
        add(B1);
        B2 = new JButton("Cancel");
        B2.setBounds(220,350,130,30);
        B2.addActionListener(this);
        B2.setForeground(Color.WHITE);
        B2.setBackground(Color.BLACK);
        add(B2);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/RoomDemo.jpg"));
        JLabel L2 = new JLabel (I1);
        L2.setBounds(400,30,470,350);
        add(L2);
        getContentPane().setBackground(Color.WHITE);
        setBounds(525,250,900,500);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            String room = T1.getText();
            String available = (String)C1.getSelectedItem();
            String status = (String)C2.getSelectedItem();
            String price = T2.getText();
            String type = (String)C3.getSelectedItem();
            
            conn c = new conn();
            try{
                String str = "insert into rooms values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added");
                this.setVisible(false);
            }catch (HeadlessException | SQLException ae){ 
                System.out.println(ae);
            }
        }else if (e.getSource() == B2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddRoom().setVisible(true);
    }
}
