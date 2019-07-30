package communicare;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class otp{
    otp(String s){
        JFrame of= new JFrame();
        JLabel t=new JLabel();
        t= new JLabel("<html>One Time Password has been sent<br>to your mobile number "+s.charAt(0)+s.charAt(1)+" * * * "+s.charAt(5)+s.charAt(6)+" * "+s.charAt(8)+s.charAt(9)+"</html>");
        t.setForeground(Color.black);
        t.setBounds(10,30,600,50);
        t.setFont(new Font("Times New Roman", Font.BOLD, 20));
        of.add(t);
        JLabel pass=new JLabel();
        pass=new JLabel("Enter the OTP:");
        pass.setForeground(Color.black);
        pass.setBounds(10,200,200,30);
        pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
        of.add(pass);
        JPasswordField passf=new JPasswordField();
        passf.setBounds(150,200,200,30);
        passf.setFont(new Font("Times New Roman", Font.BOLD, 20));
        of.add(passf);
        JButton a=new JButton("Make Payment");  
        a.setBounds(230,300,150,40); 
        of.add(a);
        a.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                of.dispose();
                PaymentSuccessful paymentSuccessful = new PaymentSuccessful();
            }
        });
        of.setSize(600,800);  
        of.setLayout(null);  
        of.setVisible(true);
        of.getContentPane().setBackground(new Color(211,61,73));  
    }
}
