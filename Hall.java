package communicare;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*; 

class Rate{
       String area;
       int price;
       Rate(String a,int b){
           area=a;
           price=b;
       }
       String getName(){
           return area;
       }
       int getRate(){
           return price;
       }
}
  class Hall {
    Hall(ImageIcon image,String c){ 
        String Movie;
        String a=c;
        JFrame hf= new JFrame();  
        JLabel l1=new JLabel();
        l1 = new JLabel("Select your Seat and Timing");
        l1.setForeground(Color.black);
        l1.setBounds(140,0,500,30);
        l1.setFont(new Font("Courier New", Font.BOLD, 20));
        hf.add(l1);
        JLabel imagelabel1 = new JLabel(image);
        imagelabel1.setBounds(200,100,150,179);  
        hf.add(imagelabel1);
         hf.setSize(600,800);  
        hf.setLayout(null);  
        hf.setTitle("Seat and Time Selection");
        hf.setVisible(true);  
        JButton back=new JButton("Back");  
        back.setBounds(10,10,80,30); 
        hf.add(back);
        JLabel name=new JLabel();
        name = new JLabel("Welcome to "+a);
        name.setForeground(Color.black);
        name.setBounds(160,50,300,30);
        name.setFont(new Font("Courier New", Font.BOLD, 20));
        hf.add(name);
        JLabel about=new JLabel();
        if("Denzong".equals(a)){ 
        about = new JLabel("<html>Name: Golmaal Again<br>Release Date: 20th Oct 2017<br>Actor:Ajay Devgan,ParineetiChopra,etc.<br>Ratings: 5.5/10<br>Runtime: 03:00<html>");
        Movie="Golmaal Again";
        }
        else{
          about = new JLabel("<html>Name: Secret Superstar<br>Release Date: 19th Oct 2017<br>Actor:Aamir khan, Zaira Wasim,etc.<br>Ratings: 8.5/10<br>Runtime: 02:35<html>");   
          Movie="Secret Superstar";
        }
        about.setForeground(Color.black);
        about.setBounds(160,250,300,200);
        about.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        hf.add(about); 
        back.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                hf.dispose();
                MovieSelection movieSelection = new MovieSelection();
            }
        });
        ArrayList<Rate> amt=new ArrayList<Rate>();
        amt.add(new Rate("Platinium-> Rs 300/-",300));
        amt.add(new Rate("Diamond-> Rs 250/-",250));
        amt.add(new Rate("Gold-> Rs 200/-",200));
        amt.add(new Rate("Silver-> Rs 150/-",150));
        JLabel ch=new JLabel("Seat Options and Show Timings:");
        ch.setBounds(150,420,400,30);
        ch.setFont(new Font("Times New Roman", Font.BOLD, 18));
        hf.add(ch);
        JRadioButton seat[]=new JRadioButton [4];
        ButtonGroup bg=new ButtonGroup();    
        for(int i=0,j=0;i<=3;i++,j+=30){
            seat[i]= new JRadioButton(amt.get(i).getName());     
            seat[i].setBounds(10,(460+j),230,30);
            seat[i].setFont(new Font("Courier New", Font.BOLD, 15));
            bg.add(seat[i]);
            hf.add(seat[i]);
        } 
        JRadioButton no[]=new JRadioButton [10];
        ButtonGroup bgno=new ButtonGroup();    
        for(int i=1,j=0;i<=5;i++,j+=30){
            no[i]= new JRadioButton(i+"Seat(s)");     
            no[i].setBounds(240,(460+j),100,30);
            no[i].setFont(new Font("Courier New", Font.BOLD, 15));
            bgno.add(no[i]);
            hf.add(no[i]);
         }
        JRadioButton ti[]=new JRadioButton [10];
        ButtonGroup bgti=new ButtonGroup(); 
        ti[0]= new JRadioButton("11:00 AM"); 
        ti[1]= new JRadioButton("02:15 PM");
        ti[2]= new JRadioButton("05:30 PM");
        for(int i=0,j=0;i<=2;i++,j+=30){   
            ti[i].setBounds(410,(460+j),100,30);
            ti[i].setFont(new Font("Courier New", Font.BOLD, 15));
            bgti.add(ti[i]);
            hf.add(ti[i]);
        }
        JButton b=new JButton("Proceed");    
        b.setBounds(240,650,100,30);    
        hf.add(b);    
        b.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                String SEAT=" ",TIME=" ";
                int RATE=0;
                int No_Of_seats=0;
                if(seat[0].isSelected()){    
                     SEAT="Platinium";
                     RATE=300;
                }
                if(seat[1].isSelected()){    
                     SEAT="Diamond";
                     RATE=250;
                }
                if(seat[2].isSelected()){    
                     SEAT="Gold";
                     RATE=200;
                }
                if(seat[3].isSelected()){    
                     SEAT="Silver";
                     RATE=150;
                }
                if(no[1].isSelected()) No_Of_seats=1;
                if(no[2].isSelected()) No_Of_seats=2;
                if(no[3].isSelected()) No_Of_seats=3;
                if(no[4].isSelected()) No_Of_seats=4;
                if(no[5].isSelected()) No_Of_seats=5;
                
                if(ti[0].isSelected()) TIME="11:00 AM";
                if(ti[1].isSelected()) TIME="02:15 PM";
                if(ti[2].isSelected()) TIME="05:30 PM";
                hf.dispose();
                Info info = new Info(a,Movie,SEAT,TIME,RATE,No_Of_seats);
            }
            
        });    
    }
}
    
