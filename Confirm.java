package communicare;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import javax.swing.*;

interface Compute{
    int amount(int a,int b);
}

class Confirm implements Compute{
    String SEAT_CATEGORY,HALL,MOVIE;
    String TIME;
    int RATE;
    int numberOfSeats;
    String NAME;
    String PhoneNumber;
    String Email;
    int TOTAL;
    int c=0;
    Confirm(String a,String b,String seatName,String time,int Rate,int NoOfSeats,String nm,String ph,String id){
        HALL=a;
        MOVIE=b;
        SEAT_CATEGORY=seatName;
        TIME=time;
        RATE=Rate;
        numberOfSeats=NoOfSeats;
        TOTAL=amount(RATE,NoOfSeats);
        NAME=nm;
        PhoneNumber=ph;
        Email=id;
        this.Display();
    }
    
    @Override
    public int amount(int a,int b){
        return(a*b);
    }
    void Display(){
        JFrame cf= new JFrame();
        JLabel head=new JLabel();
        head = new JLabel("Are the following details Correct?");
        head.setForeground(Color.black);
        head.setBounds(100,30,800,30);
        head.setFont(new Font("Courier New", Font.BOLD, 20));
        cf.add(head);
        JLabel con=new JLabel();
        con = new JLabel("<html> >Name:"+NAME+"<br> >Phone Number:"+PhoneNumber+"<br> >Email ID:"+Email+
                "<br> >Theather:"+HALL+"<br> >Movie:"+MOVIE+"<br> >Seat Category:"+SEAT_CATEGORY+
                "<br> >Number of Seats:"+numberOfSeats+"<br> >Rate:Rs"+RATE+"<br> >Time:"+TIME+
                "<br> >Total:Rs"+TOTAL+"</html>");
        con.setForeground(Color.black);
        con.setBounds(0,100,700,300);
        con.setFont(new Font("Courier New", Font.BOLD, 20));
        cf.add(con);
        JButton no=new JButton("No,Book Again");  
        no.setBounds(50,400,200,40); 
        cf.add(no);
        no.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                cf.dispose();
                MovieSelection movieSelection = new MovieSelection();
            }
        });
        JButton yes=new JButton("Proceed to Checkout");  
        yes.setBounds(300,400,200,40); 
        cf.add(yes);
        yes.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                cf.dispose();
                Payment payment = new Payment(TOTAL,PhoneNumber);
            }
        });
        cf.getContentPane().setBackground(new Color(211,61,73)); 
        cf.setSize(600,800);  
        cf.setLayout(null);  
        cf.setVisible(true);  
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/communicare/invoice.txt",true));
            out.newLine();
            out.write("Name:"+NAME);
            out.newLine();
            out.write("Phone Number:"+PhoneNumber);
            out.newLine();
            out.write("Email ID:"+Email);
            out.newLine();
            out.write("Theather:"+HALL);
            out.newLine();
            out.write("Movie:"+MOVIE);
            out.newLine();
            out.write("Seat Category:"+SEAT_CATEGORY);
            out.newLine();
            out.write("Number of Seats:"+numberOfSeats);
            out.newLine();
            out.write("Rate:Rs"+RATE);
            out.newLine();
            out.write("Time:"+TIME);
            out.newLine();
            out.write("Total:Rs"+TOTAL);
            out.newLine();
            out.close();
        }
      catch (IOException e){
        System.out.println("Exception ");
      }  
    }
}
