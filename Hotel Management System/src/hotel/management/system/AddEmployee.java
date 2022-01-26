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

public class AddEmployee extends JFrame implements ActionListener{
    JTextField T1,T2,T3,T4,T5,T6,T7;
    JRadioButton R1,R2;
    JComboBox C1;
    JButton B1;
    Choice CC;
    
    AddEmployee() {
        JLabel empno = new JLabel("Employee Number");
        empno.setFont(new Font("serif",Font.PLAIN,17));
        empno.setBounds(60,30,150,30);
        add(empno);
        T6 = new JTextField();
        T6.setBounds(200,30,150,30);
        add(T6);
        
        JLabel mgr = new JLabel("Manager ID");
        mgr.setFont(new Font("serif",Font.PLAIN,17));
        mgr.setBounds(60,80,130,30);
        add(mgr);
        CC = new Choice();
        try{
            conn c = new conn();
            String str = "select distinct mgr from employees ";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                CC.add(rs.getString("mgr"));
            }
        }catch (Exception ae){}
        CC.setBounds(200,85,150,30);
        add(CC);
        
        JLabel name  = new JLabel("Name and Surname");
        name.setFont(new Font("serif",Font.PLAIN,17));
        name.setBounds(60,130,150,30);
        add(name);
        T1 = new JTextField();
        T1.setBounds(200,130,150,30);
        add(T1);
        
        JLabel age  = new JLabel("Age");
        age.setFont(new Font("serif",Font.PLAIN,17));
        age.setBounds(60,180,120,30);
        add(age);
        T2 = new JTextField();
        T2.setBounds(200,180,150,30);
        add(T2);
        
        JLabel gender  = new JLabel("Gender");
        gender.setFont(new Font("serif",Font.PLAIN,17));
        gender.setBounds(60,230,120,30);
        add(gender);
        R1 = new JRadioButton("Male");
        R1.setFont(new Font("serif",Font.PLAIN,16));
        R1.setBounds(200,230,70,30);
        R1.setBackground(Color.WHITE);
        add(R1);
        R2 = new JRadioButton("Female");
        R2.setFont(new Font("serif",Font.PLAIN,16));
        R2.setBounds(270,230,70,30);
        R2.setBackground(Color.WHITE);
        add(R2);
        
        JLabel job  = new JLabel("Job");
        job.setFont(new Font("serif",Font.PLAIN,17));
        job.setBounds(60,280,120,30);
        add(job);
        String str[] = {"Front Desk Clerk","Porter","House Keeping","Room Service","Waiter/Waitress","Masseur/Masseuse","Accountant","Kitchen Staff","Chef"};
        C1 = new JComboBox(str);
        C1.setBounds(200,280,150,30);
        C1.setBackground(Color.WHITE);
        add(C1);
        
        JLabel sal  = new JLabel("Salary");
        sal.setFont(new Font("serif",Font.PLAIN,17));
        sal.setBounds(60,320,120,30);
        add(sal);
        T3 = new JTextField();
        T3.setBounds(200,320,150,30);
        add(T3);
        
        JLabel ph  = new JLabel("Contact Phone");
        ph.setFont(new Font("serif",Font.PLAIN,17));
        ph.setBounds(60,370,120,30);
        add(ph);
        T4 = new JTextField();
        T4.setBounds(200,370,150,30);
        add(T4);
        
        JLabel em  = new JLabel("Contact E-mail");
        em.setFont(new Font("serif",Font.PLAIN,17));
        em.setBounds(60,420,120,30);
        add(em);
        T5 = new JTextField();
        T5.setBounds(200,420,150,30);
        add(T5);
        
        B1 = new JButton("Submit");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(200,470,150,30);
        B1.addActionListener(this);
        add(B1);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/Hired.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,597,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel L1 = new JLabel(I3);
        L1.setBounds(300,50,650,500);
        add(L1);
        JLabel L2 = new JLabel("Add Employee Info");
        L2.setForeground(Color.RED);
        L2.setBounds(535,5,400,50);
        L2.setFont(new Font("serif",Font.ITALIC,30));
        add(L2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(525,250,900,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e){
        String empno = T6.getText();
        String mgr = CC.getSelectedItem();
        String name = T1.getText();
        String age = T2.getText();
        String sal = T3.getText();
        String ph = T4.getText();
        String em = T5.getText();
        String gender = null;
        String job = (String)C1.getSelectedItem();
        if(R1.isSelected()){
            gender = "Male";
        }else if(R2.isSelected()){
            gender  = "Female";
        }
        conn c  = new conn();
        try{
            String str = "insert into employees values('"+empno+"','"+mgr+"','"+name+"','"+age+"','"+gender+"','"+job+"','"+sal+"','"+ph+"','"+em+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
        }catch (HeadlessException | SQLException ae){
            System.out.println(ae);
        }
    }
    public static void main(String []args){
        new AddEmployee().setVisible(true);
    }
}
