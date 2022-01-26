/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */

public class Login extends JFrame implements ActionListener {
    JLabel L1,L2;
    JTextField T1;
    JPasswordField T2;
    JButton B1,B2;
    Login(){
        
        L1 = new JLabel ("Username:");
        L1.setForeground(Color.WHITE);
        L1.setBounds(40,20,100,30);
        add(L1);
        L2 = new JLabel ("Password:");
        L2.setForeground(Color.WHITE);
        L2.setBounds(40,70,100,30);
        add(L2);
        
        T1 = new JTextField();
        T1.setBounds(150,20,150,30);
        add(T1);
        T2 = new JPasswordField();
        T2.setBounds(150,70,150,30);
        add(T2);
        
        B1 = new JButton("Login");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(40,150,120,30);
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("Reset");
        B2.setBounds(180,150,120,30);
        B2.setBackground(Color.RED);
        B2.setForeground(Color.WHITE);
        B2.addActionListener(this);
        add(B2);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/LoginLogo.jpg"));
        Image I2 = I1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel L3 = new JLabel(I3);
        L3.setBounds(350,10,200,200);
        add(L3);
        
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setBounds(500,300,600,400);
        setVisible(true);
    }
    @Override  
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == B1){
            String username = T1.getText();
            String password = T2.getText();
            /*String pass=String.valueof(passwordField.getPassword()) 
            
            */
            conn c = new conn();
            String str = "select * from login where username =  '" +username+ "' and password = '" +password+ "'";
            try{
               ResultSet rs = c.s.executeQuery(str); 
               if(rs.next()){
                   new DashBoard().setVisible(true);
                   this.setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(null, "User and/or password are incorrect");
                   this.setVisible(false);
               }
            }catch(HeadlessException | SQLException ae) {}
        }else if (e.getSource() == B2){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
