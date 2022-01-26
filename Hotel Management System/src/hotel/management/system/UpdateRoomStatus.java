/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */

public class UpdateRoomStatus extends JFrame implements ActionListener {
    JTextField T1,T2,T3,T4;
    JButton B1,B2,B3;
    Choice CC;
    
    UpdateRoomStatus(){
        JLabel L1 = new JLabel("Update Room Status");
        L1.setForeground(Color.MAGENTA);
        L1.setBounds(30,20,250,30);
        L1.setFont(new Font("serif",Font.PLAIN,28));
        add(L1);
        
        JLabel L2 = new JLabel("Room Number");
        L2.setBounds(30,80,150,50);
        L2.setFont(new Font("serif",Font.PLAIN,19));
        add(L2);
        CC = new Choice();
        try{
            conn c = new conn();
            String str = "select * from rooms order by room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                CC.add(rs.getString("room"));
            }
        }catch (Exception ae){}
        CC.setBounds(230,95,150,50);
        add(CC);
        
        JLabel L3 = new JLabel("Reservation Code");
        L3.setBounds(30,150,150,50);
        L3.setFont(new Font("serif",Font.PLAIN,19));
        add(L3);
        T1 = new JTextField();
        T1.setEditable(false);
        T1.setBounds(230,160,150,30);
        add(T1);
        
        JLabel L4 = new JLabel("Availability");
        L4.setBounds(30,190,200,50);
        L4.setFont(new Font("serif",Font.PLAIN,19));
        add(L4);
        T2 = new JTextField();
        T2.setBounds(230,200,150,30);
        add(T2);
        
        JLabel L5 = new JLabel("Clean Status");
        L5.setBounds(30,230,200,50);
        L5.setFont(new Font("serif",Font.PLAIN,19));
        add(L5);
        T3 = new JTextField();
        T3.setBounds(230,240,150,30);
        add(T3);
        
        JLabel L7 = new JLabel("Check-IN Status");
        L7.setBounds(30,270,200,50);
        L7.setFont(new Font("serif",Font.PLAIN,19));
        add(L7);
        T4 = new JTextField();
        T4.setBounds(230,280,150,30);
        add(T4);
        
        B1 = new JButton("Update");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(50,360,120,30);
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("Details");
        B2.setBackground(Color.BLACK);
        B2.setForeground(Color.WHITE);
        B2.setBounds(250,360,120,30);
        B2.addActionListener(this);
        add(B2);
        B3 = new JButton("Go back");
        B3.setBackground(Color.BLACK);
        B3.setForeground(Color.WHITE);
        B3.setBounds(150,420,120,30);
        B3.addActionListener(this);
        add(B3);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/RoomStatus.jpg"));
        Image I2 = I1.getImage().getScaledInstance(550, 400, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel L6 = new JLabel(I3);
        L6.setBounds(400,40,590,400);
        add(L6);
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,1000,600);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            conn c = new conn();
            String room = CC.getSelectedItem();
            String available = T2.getText();
            String status = T3.getText();
            try{
                String str = "update rooms set available = '"+available+"',status = '"+status+"' where room = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Updated Room Status");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(HeadlessException | SQLException ae){
                System.out.println(ae.getMessage());
            }
        }else if(e.getSource() == B2){
            String str1 = CC.getSelectedItem();
            String room = CC.getSelectedItem();
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from rooms where room = '"+str1+"'");
                while(rs.next()){
                    T1.setText("");
                    T2.setText(rs.getString("available"));
                    T3.setText(rs.getString("status"));
                    T4.setEditable(false);
                    T4.setText("");
                }
                ResultSet rs2 = c.s.executeQuery("select * from clients where roomNr = '"+room+"'");
                while(rs2.next()){
                    T4.setEditable(true);
                    T1.setText(rs2.getString("Code"));
                    T4.setText(rs2.getString("checked"));
                }
            }catch (SQLException ae){
                System.out.println(ae.getMessage());
            }
        }else if (e.getSource() == B3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateRoomStatus().setVisible(true);
    }
}
