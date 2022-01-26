/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 *
 * @author Asus
 */

public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem() throws InterruptedException{
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/InternationalBG.jpg"));
        JLabel L1 = new JLabel (I1);
        L1.setBounds(0,0,1100,733);
        add(L1);
           
        JLabel L2 = new JLabel("Proiect P3");
        L2.setBounds(100,600,1000,70);
        L2.setForeground(Color.RED);
        L2.setFont(new Font("serif",Font.PLAIN,70));
        L1.add(L2);
           
        JLabel L3 = new JLabel ("Caraiman");
        L3.setForeground(Color.RED);
        L3.setBounds(560,560,1000,50);
        L3.setFont(new Font("serif",Font.PLAIN,50));
        L1.add(L3);
           
        JLabel L4 = new JLabel ("Vlad-Cristian");
        L4.setForeground(Color.RED);
        L4.setBounds(550,630,1000,50);
        L4.setFont(new Font("serif",Font.PLAIN,50));
        L1.add(L4);
           
        JButton B1 = new JButton("ENTER");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(530,430,100,30);
        B1.addActionListener(this);
        L1.add(B1);
           
        setLayout(null);
        setBounds(300,200,1100,733);
        setVisible(true);
        
        while (true){
            L3.setVisible(false);
            Thread.sleep(500);
            L4.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e) {}
            L3.setVisible(true);
            Thread.sleep(500);
            L4.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e) {}
        }   
    } 
    @Override    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new HotelManagementSystem();
    }
}
