package communicare;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class movie{
  abstract void select_cinemahall();
  String hall1="Vajra Hall";
  String hall2="Denzong Hall";
}

class MovieSelection extends movie{
    MovieSelection(){
        this.select_cinemahall();
    }
    @Override
    public void select_cinemahall(){
     JFrame mf= new JFrame();  
     JLabel l1=new JLabel();
     l1 = new JLabel("Please Choose the Movie");
     l1.setForeground(Color.black);
     l1.setBounds(110,0,500,30);
     l1.setFont(new Font("Courier New", Font.BOLD, 25));
     mf.add(l1);
     ImageIcon image1 = new ImageIcon("src/communicare/vajra.jpg");
     JLabel imagelabel1 = new JLabel(image1);
     imagelabel1.setBounds(70,100,150,179);  
     mf.add(imagelabel1);
     ImageIcon image2 = new ImageIcon("src/communicare/denzong.jpg");
     JLabel imagelabel2 = new JLabel(image2);
     imagelabel2.setBounds(300,100,150,179);  
     mf.add(imagelabel2);
     mf.setSize(600,800);  
     mf.setLayout(null);  
     mf.setVisible(true);  
     JButton v=new JButton(hall1);  
     v.setBounds(85,300,120,30); 
     mf.add(v);
     JButton d=new JButton(hall2);  
     d.setBounds(315,300,120,30); 
     mf.add(d);   
     mf.setTitle("Communicare Hall Selection Page");   
        v.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.dispose();
                Hall hall = new Hall(image1,hall1);
            }
        });
        d.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.dispose();
                Hall hall = new Hall(image2,hall2);
            }
        });   
         mf.getContentPane().setBackground(new Color(211,61,73));    
 }  
    public static void main(String[] args) {
        MovieSelection movieSelection = new MovieSelection();
	}
}

