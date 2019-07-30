package communicare;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class Payment {
    String ph;
   
Payment(int Total,String no){
        ph=no;
        JFrame pf= new JFrame();
        JLabel l=new JLabel();
        l= new JLabel("Select your Payment Mode to Pay Rs "+Total);
        l.setForeground(Color.black);
        l.setBounds(100,30,800,30);
        l.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pf.add(l);
        ImageIcon image1 = new ImageIcon("src/communicare/AXIN.png");
        JLabel imagelabel1 = new JLabel(image1);
        ImageIcon image2 = new ImageIcon("src/communicare/SBIN.png");
        JLabel imagelabel2 = new JLabel(image2);
        ImageIcon image3 = new ImageIcon("src/communicare/HDFN.png");
        JLabel imagelabel3 = new JLabel(image3);
        ImageIcon image4 = new ImageIcon("src/communicare/Paytm.png");
        JLabel imagelabel4 = new JLabel(image4);
        ImageIcon image5 = new ImageIcon("src/communicare/OXIW.png");
        JLabel imagelabel5 = new JLabel(image5);
        ImageIcon image6 = new ImageIcon("src/communicare/MBKW.png");
        JLabel imagelabel6 = new JLabel(image6);
        imagelabel1.setBounds(80,150,120,30); 
        imagelabel2.setBounds(230,150,120,30); 
        imagelabel3.setBounds(380,150,120,30); 
        imagelabel4.setBounds(80,400,120,30); 
        imagelabel5.setBounds(230,400,120,30); 
        imagelabel6.setBounds(380,400,120,30); 
        pf.add(imagelabel1);
        pf.add(imagelabel2);
        pf.add(imagelabel3);
        pf.add(imagelabel4);
        pf.add(imagelabel5);
        pf.add(imagelabel6);
        JButton a=new JButton("Debit/Credit Card or NetBanking");  
        pf.getContentPane().setBackground(new Color(211,61,73)); 
        a.setBounds(160,250,250,40); 
        pf.add(a);
        JButton b=new JButton("Wallets");  
        b.setBounds(230,500,100,40); 
        pf.add(b);
        a.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                pf.dispose();
                otp ot = new otp(ph);
            }
        });
        b.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                pf.dispose();
                otp ot = new otp(ph);
            }
        });
        pf.setSize(600,800);  
        pf.setLayout(null);  
        pf.setVisible(true);  
    }
}
