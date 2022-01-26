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

public class AddClient extends JFrame implements ActionListener{
    JTextField T1,T2,T3,T4;
    JButton B1,B2;
    JComboBox C1;
    JRadioButton R1,R2,R3,R4;
    Choice CC;
    
    AddClient(){
        JLabel L1 = new JLabel("New Reservation");
        L1.setBounds(100,20,200,30);
        L1.setForeground(Color.GREEN);
        L1.setBackground(Color.WHITE);
        L1.setFont(new Font("serif",Font.PLAIN,24));
        add(L1);
        
        JLabel L2 = new JLabel("ID");
        L2.setBounds(35,80,100,20);
        L2.setFont(new Font("serif",Font.PLAIN,19));
        add(L2);
        String strCombo[] = {"Driving License","Passport","Identity Card"};
        C1 = new JComboBox(strCombo);
        C1.setBounds(200,80,150,25);
        add(C1);
        
        JLabel L3 = new JLabel("Reservation Code");
        L3.setBounds(35,130,140,25);
        L3.setFont(new Font("serif",Font.PLAIN,17));
        add(L3);
        T1 = new JTextField("6_letter_code");
        T1.setBounds(200,130,150,25);
        add(T1);
        
        JLabel L4 = new JLabel("Name and Surname");
        L4.setBounds(35,180,140,25);
        L4.setFont(new Font("serif",Font.PLAIN,17));
        add(L4);
        T2 = new JTextField();
        T2.setBounds(200,180,150,30);
        add(T2);
        
        JLabel L5 = new JLabel("Gender");
        L5.setBounds(35,230,100,25);
        L5.setFont(new Font("serif",Font.PLAIN,19));
        add(L5);
        R1 = new JRadioButton("Male");
        R1.setBounds(200,230,90,30);
        R1.setFont(new Font("serif",Font.PLAIN,18));
        R1.setBackground(Color.WHITE);
        add(R1);
        R2 = new JRadioButton("Female");
        R2.setBounds(300,230,90,30);
        R2.setFont(new Font("serif",Font.PLAIN,18));
        R2.setBackground(Color.WHITE);
        add(R2);
        
        JLabel L6 = new JLabel("Country");
        L6.setBounds(35,280,100,30);
        L6.setFont(new Font("serif",Font.PLAIN,19));
        add(L6);
        T3 = new JTextField();
        T3.setBounds(200,280,150,30);
        add(T3);
        
        JLabel L7 = new JLabel("Room nr.");
        L7.setBounds(35,330,100,20);
        L7.setFont(new Font("serif",Font.PLAIN,19));
        add(L7);
        CC = new Choice();
        try{
            conn c = new conn();
            String str = "select * from rooms where available = 'Available'";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                CC.add(rs.getString("room"));
            }
        }catch (Exception ae){}
        CC.setBounds(200,330,150,30);
        add(CC);
        
        JLabel L8 = new JLabel("Checked IN");
        L8.setBounds(35,380,100,20);
        L8.setFont(new Font("serif",Font.PLAIN,19));
        add(L8);
        R3 = new JRadioButton("Yes");
        R3.setBounds(200,380,90,30);
        R3.setBackground(Color.WHITE);
        R3.setFont(new Font("serif",Font.PLAIN,18));
        add(R3);
        R4 = new JRadioButton("No");
        R4.setBounds(300,380,90,30);
        R4.setBackground(Color.WHITE);
        R4.setFont(new Font("serif",Font.PLAIN,18));
        add(R4);
        
        B1 = new JButton("Add Client");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(35,430,120,35);
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("Go Back");
        B2.setBackground(Color.BLACK);
        B2.setForeground(Color.WHITE);
        B2.setBounds(170,430,120,35);
        B2.addActionListener(this);
        add(B2);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/Reservation.jpg"));
        Image I2 = I1.getImage().getScaledInstance(520,520,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel L9 = new JLabel(I3);
        L9.setBounds(400,0,520,520);
        add(L9);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,900,550);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        if(e.getSource() == B1){
            String id = (String) C1.getSelectedItem();
            String code = T1.getText();
            String name = T2.getText();
            String gender = null;
            if (R1.isSelected()){
                gender = "Male";
            }else if(R2.isSelected()){
                gender = "Female";
            }
            String country = T3.getText();
            String room = CC.getSelectedItem();
            String check = null;
            if (R3.isSelected()){
                check = "Yes";
            }else if(R4.isSelected()){
                check = "No";
            }
            conn c = new conn();
            try{
                String str = "insert into clients values('"+name+"','"+id+"','"+code+"','"+gender+"','"+country+"','"+room+"','"+check+"')";
                String string = "update rooms set available = 'Occupied' where room = '"+room+"'";
                c.s.executeUpdate(str);
                c.s.executeUpdate(string);
                JOptionPane.showMessageDialog(null, "Reservation Made");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(HeadlessException | SQLException ae){
            System.out.println(ae.getMessage());
            }
        }else if (e.getSource() == B2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddClient().setVisible(true);
    }
}
