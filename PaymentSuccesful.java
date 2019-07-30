package communicare;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import javax.swing.*;

class PaymentSuccessful{
    PaymentSuccessful(){
        JFrame pf= new JFrame();
        JLabel t=new JLabel();
        t= new JLabel("<html>Your Payment is succesful,Ticket details have <br> &nbsp been sent to your email and mobile number</html>");
        t.setForeground(Color.black);
        t.setBounds(80,300,600,100);
        t.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pf.add(t);
        ImageIcon image1 = new ImageIcon("src/communicare/succ.png");
        JLabel imagelabel1 = new JLabel(image1);
        imagelabel1.setBounds(130,100,300,200);  
        pf.add(imagelabel1);
        pf.setSize(600,800);  
        pf.setLayout(null);  
        pf.setVisible(true);
        pf.getContentPane().setBackground(new Color(211,61,73)); 
        try{
        BufferedWriter out = new BufferedWriter(new FileWriter("src/communicare/invoice.txt",true));
        out.newLine();
        out.write("BOOKING REFERENCE NUMBER: CCMBPO1Tx4T7");
        out.newLine();
        out.close();
        }
       catch (IOException e){
             System.out.println("Exception ");
        }
    }
}
