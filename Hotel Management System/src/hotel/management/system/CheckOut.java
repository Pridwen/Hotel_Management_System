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

public class CheckOut extends JFrame implements ActionListener{
    Choice CC;
    JTextField T1,T2;
    JComboBox C1;
    JButton B1,B2,B3;
    
    CheckOut(){
        
        JLabel L1 = new JLabel("Check Out");
        L1.setForeground(Color.BLUE);
        L1.setBounds(50,20,250,30);
        L1.setFont(new Font("serif",Font.PLAIN,28));
        add(L1);
        
        JLabel L2 = new JLabel("Reservation Code");
        L2.setFont(new Font("serif",Font.PLAIN,19));
        L2.setBounds(30,80,150,30);
        add(L2);
        CC = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from clients order by roomNr");
            while (rs.next()){
                CC.add(rs.getString("Code"));
            }
        }catch(Exception e){}
        CC.setBounds(200,85,150,50);
        add(CC);
        
        JLabel L5 = new JLabel("Review");
        L5.setFont(new Font("serif",Font.PLAIN,19));
        L5.setBounds(30,120,150,30);
        add(L5);
        String str[] = {"1 Star","2 Starts","3 Stars","4 Stars","5 Stars"};
        C1 = new JComboBox(str);
        C1.setBounds(200,120,100,25);
        C1.setBackground(Color.WHITE);
        add(C1);
        
        JLabel L6 = new JLabel("Name and Surname");
        L6.setFont(new Font("serif",Font.PLAIN,19));
        L6.setBounds(30,150,150,30);
        add(L6);
        T2 = new JTextField();
        T2.setBounds(200,150,150,25);
        add(T2);
        
        JLabel L3 = new JLabel("Room Number");
        L3.setFont(new Font("serif",Font.PLAIN,19));
        L3.setBounds(30,180,150,30);
        add(L3);
        T1 = new JTextField();
        T1.setBounds(200,185,150,25);
        add(T1);
        
        B1 = new JButton("Checkout");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(30,280,120,30);
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("Go back");
        B2.setBackground(Color.BLACK);
        B2.setForeground(Color.WHITE);
        B2.setBounds(180,280,120,30);
        B2.addActionListener(this);
        add(B2);
        B3 = new JButton("Fetch Data");
        B3.setBackground(Color.BLACK);
        B3.setForeground(Color.WHITE);
        B3.setBounds(55,230,220,30);
        B3.addActionListener(this);
        add(B3);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/CheckOut.jpg"));
        Image I2 = I1.getImage().getScaledInstance(440,450,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel L4 = new JLabel(I3);
        L4.setBounds(280,0,590,400);
        add(L4);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,800,400);
        setVisible(true);          
    }
     @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            String code = CC.getSelectedItem();
            String room = T1.getText();
            String name = T2.getText();
            String review = (String) C1.getSelectedItem();
            String book = "insert into booking values('"+code+"','"+name+"','"+room+"','"+review+"')";
            String str1 = "delete from clients where Code = '"+code+"'";
            String str2 = "update rooms set available = 'Available',status = 'Dirty' where room = '"+room+"'";
            conn c = new conn();
            try{
                c.s.executeUpdate(book);
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Client has checked out");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(HeadlessException | SQLException ae){
                System.out.println(ae.getMessage());
            }
        }else if(e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource() == B3){
            conn c = new conn();
            String code = CC.getSelectedItem();
            try{
                ResultSet rs = c.s.executeQuery("select * from clients where Code = '"+code+"'");
                while(rs.next()){
                    T1.setText(rs.getString("roomNr"));
                    T2.setText(rs.getString("name"));
                }
            }catch (SQLException ae){
                    System.out.println(ae.getMessage());
            }
        }
    }
    public static void main(String[] args){
        new CheckOut().setVisible(true);
    }
}
