package communicare;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 

class NameException extends Exception{
@Override
public String toString(){
    return "The entered name is not valid";
}
}

class EmailException extends Exception{
@Override
public String toString(){
    return "The entered Email Id is not valid";
}
}

public class Info{  
    String SEAT_CATEGORY,HALL,MOVIE;
    String TIME;
    int RATE;
    int numberOfSeats;
    int flag=0;
    Info(String x, String y,String seatName,String time,int Rate,int NoOfSeats){  
        SEAT_CATEGORY=seatName;
        TIME=time;
        RATE=Rate;
        numberOfSeats=NoOfSeats;
        HALL=x;
        MOVIE=y;
        JFrame f= new JFrame();   
        JLabel l1=new JLabel();
        l1 = new JLabel("Please Enter Your Details");
        l1.setForeground(Color.black);
        l1.setBounds(120,0,500,30);
        l1.setFont(new Font("Courier New", Font.BOLD, 20));
        f.add(l1);
        JLabel name=new JLabel();
        name = new JLabel("Name:");
        name.setForeground(Color.black);
        name.setBounds(10,100,500,30);
        name.setFont(new Font("Courier New", Font.BOLD, 20));
        f.add(name);
        JTextField namef=new JTextField();
        namef.setBounds(180,100,300,30);  
        f.add(namef); 
        JLabel phone=new JLabel();
        phone = new JLabel("Phone Number:");
        phone.setForeground(Color.black);
        phone.setBounds(10,150,500,30);
        phone.setFont(new Font("Courier New", Font.BOLD, 20));
        f.add(phone);
        JTextField phonef=new JTextField();
        phonef.setBounds(180,150,300,30);  
        f.add(phonef);
        JLabel email=new JLabel();
        email = new JLabel("Email Address:");
        email.setForeground(Color.black);
        email.setBounds(10,200,500,30);
        email.setFont(new Font("Courier New", Font.BOLD, 20));
        f.add(email);
        JTextField emailf=new JTextField();
        emailf.setBounds(180,200,300,30);  
        f.add(emailf);
        f.setSize(600,800);  
        f.setLayout(null);  
        f.setVisible(true);  
        f.setTitle("Personal Information");
        JButton b=new JButton("Submit Details");  
        b.setBounds(200,400,150,30); 
        JButton back=new JButton("Back");  
        back.setBounds(10,10,80,30); 
        f.getContentPane().setBackground(new Color(211,61,73)); 
        f.add(back);
        back.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
             new MovieSelection();
            }
        });
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = namef.getText();
                String mobe = phonef.getText();
                String id= emailf.getText();
                flag=0;
                int l=Name.length();
                int l2=id.length();
                int l3=mobe.length();
       try{
            for(int w=0;w<l;w++){
                char ch=Name.charAt(w);
                if(ch>=65&&ch<=90||ch>=97&&ch<=122||ch==32){  
                 }
                else{
                    throw new NameException();
                }
            }
       }
       catch(NameException ex){
            flag=1;
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex, "Error!!", JOptionPane.WARNING_MESSAGE);
          }
       try{
          long a=Long.parseLong(mobe);
        }
       catch(NumberFormatException ex){
           flag=1;
           System.out.println(ex);
           JOptionPane.showMessageDialog(null,"The Mobile Number entered is not valid", "Error!!", JOptionPane.WARNING_MESSAGE);
       }  
        try{
            for(int w=0;w<l2;w++){
                char ch=id.charAt(w);
                if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||(ch==46)||(ch==64)||(ch>=48&&ch<=57)||ch==95){  
            }
                else{
               throw new EmailException();
            }
         }
       }
       catch(EmailException ex){
            flag=1;
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex, "Error!!", JOptionPane.WARNING_MESSAGE);
      }
      if(flag==0){
         f.dispose();
         Confirm confirm = new Confirm(HALL,MOVIE,SEAT_CATEGORY,TIME,RATE,numberOfSeats,Name,mobe,id);
         }
      }
    });
    f.add(b);
  }
}  