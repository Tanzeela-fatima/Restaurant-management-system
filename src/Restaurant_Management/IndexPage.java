
package Restaurant_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IndexPage extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
JButton bt1,bt2;
JPanel p1,p2,p3;
Font f,f1;
    IndexPage(){
    super("Index Page");
    setLocation(450,250);
    setSize(500,200);
 
 f=new Font("Arial",Font.BOLD,15);   
 f1=new Font("Arial",Font.BOLD,20); 
    l1 = new JLabel("Restaurant Management");
    l2=new JLabel("Admin Login");
    l3=new JLabel("Employee Login");
    
    l1.setHorizontalAlignment(JLabel.CENTER);
    l1.setFont(f1);
    l2.setFont(f);
    l3.setFont(f);
    
    bt1=new JButton("Login");
    bt2=new JButton("Login");
    bt1.setFont(f);
    bt2.setFont(f);
    bt1.setForeground(Color.WHITE);
    bt1.setBackground(Color.BLACK);
    bt2.setBackground(Color.RED);
    bt2.setForeground(Color.WHITE);
    
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    
    ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Restaurant_Management/icon/index.jpeg"));
    Image img=ic.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
    ImageIcon ic1=new ImageIcon(img);
    l4=new JLabel(ic1);
    
    p1=new JPanel();
    p1.setLayout(new GridLayout(1,1,10,10));
    p1.add(l1);
    
p2=new JPanel();
    p2.setLayout(new GridLayout(1,1,10,10));
    p2.add(l4);
    p3=new JPanel();
    p3.setLayout(new GridLayout(2,2,10,10));
    p3.add(l2);
    p3.add(bt1);
    p3.add(l3);
    p3.add(bt2);
    
    setLayout(new BorderLayout(10,10));
  add(p1,"North");
  add(p2,"West");
  add(p3,"Center");
  
    }
public void actionPerformed(ActionEvent e)
{ 
    if(e.getSource()==bt1){
        this.setVisible (false);
       new AdminSection().setVisible(true);
       
    }
    if(e.getSource()==bt2){
        this.setVisible (false);
       new Login().setVisible(true);
    }
}
        public static void main(String[] args)
{
new IndexPage().setVisible(true);
}
}