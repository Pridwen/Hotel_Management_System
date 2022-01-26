/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hotel.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

/**
 *
 * @author Asus
 */

public class DashBoard extends JFrame implements ActionListener{
    JMenuBar MB;
    JMenu M1,M2;
    JMenuItem I1,I2,I3;
    DashBoard(){
        
        MB = new JMenuBar();
        MB.setBounds(0,0,1920,30);
        add(MB);
        
        M1 = new JMenu("Hotel Management");
        M1.setForeground(Color.RED);
        MB.add(M1);
        I1 = new JMenuItem("Go to Reception");
        I1.addActionListener(this);
        M1.add(I1);
        
        M2 = new JMenu("Admin");
        M2.setForeground(Color.RED);
        MB.add(M2);
        I2 = new JMenuItem("Add Employee");
        I2.addActionListener(this);
        M2.add(I2);
        I3 = new JMenuItem("Add Room");
        I3.addActionListener(this);
        M2.add(I3);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Imagini/DashBoardWelcome.jpg"));
        Image I2 = I1.getImage().getScaledInstance(1500,1080,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel L1 = new JLabel(I3);
        L1.setBounds(0,0,1950,1010);
        add(L1);
        
        JLabel L2 = new JLabel("AWARD WINNING 4-STAR HOTEL");
        L2.setBounds(710,50,1000,50);
        L2.setForeground(Color.YELLOW);
        L2.setFont(new Font("serif", Font.PLAIN,35));
        L1.add(L2);
        
        JLabel L3 = new JLabel("WITH A LUXURY SPA ");
        L3.setBounds(800,90,600,50);
        L3.setForeground(Color.BLUE);
        L3.setFont(new Font("serif", Font.PLAIN,35));
        L1.add(L3);
        
        JLabel L4 = new JLabel("IN ROMANIA");
        L4.setBounds(870,130,800,60);
        L4.setForeground(Color.ORANGE);
        L4.setFont(new Font("serif", Font.PLAIN,35));
        L1.add(L4);
        
        setLayout(null);
        setBounds(0,0,1950,1020);
        setVisible(true);
    }
    @Override  
    public void actionPerformed(java.awt.event.ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Go to Reception":
                new Reception().setVisible(true);
                break;
            case "Add Employee":
                new AddEmployee().setVisible(true);
                break;
            case "Add Room":
                new AddRoom().setVisible(true);
                break;
            default:
                break;
        }
    }
    public static void main(String[] args){
        new DashBoard().setVisible(true);
    }
}
