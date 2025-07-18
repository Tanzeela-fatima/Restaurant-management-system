
package Restaurant_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Add_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    JPasswordField pf1;
    JButton bt1,bt2;
    JFrame frame;
    Font f,f1;
    
    Add_Employee(){
    frame=new JFrame("Add Employee Details");
    frame.setBackground(Color.WHITE);
    frame.setLayout(null);
    
    l1=new JLabel();
    l1.setBounds(0,0,900,600);
     ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Restaurant_Management/icon/addemployee.jpeg"));
    
    Image i1=img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
    ImageIcon img1=new ImageIcon(i1);
    l1.setIcon(img1);
    
    f=new Font("Arial",Font.BOLD,30);
    f1=new Font("Arial",Font.BOLD,20);
    
    l2=new JLabel("New Employee Details");
    l2.setBounds(280,30,500,50);
    l2.setFont(f);
    l2.setBackground(Color.BLACK);
    l1.add(l2);
    frame.add(l1);
    
    l3=new JLabel("Username");
    l3.setBounds(50,150,150,30);
    l3.setFont(f1);
    l3.setBackground(Color.BLACK);
    l1.add(l3);
    
    tf1=new JTextField();
    tf1.setBounds(200,150,150,30);
    l1.add(tf1);
    
    l4=new JLabel("Name");
    l4.setBounds(450,150,250,30);
    l4.setFont(f1);
    l4.setBackground(Color.BLACK);
    l1.add(l4);
    
    tf2=new JTextField();
    tf2.setBounds(600,150,150,30);
    l1.add(tf2);
    
    l5=new JLabel("Age");
    l5.setBounds(50,200,150,30);
    l5.setFont(f1);
    l5.setBackground(Color.BLACK);
    l1.add(l5);
    
    tf3=new JTextField();
    tf3.setBounds(200,200,150,30);
    l1.add(tf3);
    
    l6=new JLabel("Address");
    l6.setBounds(50,250,150,30);
    l6.setFont(f1);
    l6.setBackground(Color.BLACK);
    l1.add(l6);
    
    tf4=new JTextField();
    tf4.setBounds(200,250,150,30);
    l1.add(tf4);
    
    l7=new JLabel("Email ID");
    l7.setBounds(50,300,150,30);
    l7.setFont(f1);
    l7.setBackground(Color.BLACK);
    l1.add(l7);
    
    tf5=new JTextField();
    tf5.setBounds(200,300,150,30);
    l1.add(tf5);
    
    l8=new JLabel("Gender");
    l8.setBounds(50,350,150,30);
    l8.setFont(f1);
    l8.setBackground(Color.BLACK);
    l1.add(l8);
    
    tf8=new JTextField();
    tf8.setBounds(200,350,150,30);
    l1.add(tf8);
    
    l6=new JLabel("DOB");
    l6.setBounds(450,200,250,30);
    l6.setFont(f1);
    l6.setBackground(Color.BLACK);
    l1.add(l6);
    
    tf6=new JTextField();
    tf6.setBounds(600,200,150,30);
    l1.add(tf6);
    
     l9=new JLabel("Phone");
    l9.setBounds(450,250,250,30);
    l9.setFont(f1);
    l9.setBackground(Color.BLACK);
    l1.add(l9);
    
    tf7=new JTextField();
    tf7.setBounds(600,250,150,30);
    l1.add(tf7);
    
    l10=new JLabel("Password");
    l10.setBounds(450,300,250,30);
    l10.setFont(f1);
    l10.setBackground(Color.BLACK);
    l1.add(l10);
    
    pf1=new JPasswordField();
    pf1.setBounds(600,300,150,30);
    l1.add(pf1);
    
    l11=new JLabel("CNIC");
    l11.setBounds(450,350,250,30);
    l11.setFont(f1);
    l11.setBackground(Color.BLACK);
    l1.add(l11);
    
    tf9=new JTextField();
    tf9.setBounds(600,350,150,30);
    l1.add(tf9);
    
    bt1=new JButton("Submit");
    bt1.setBackground(Color.BLACK);
    bt1.setForeground(Color.WHITE);
    bt1.setBounds(250,450,150,40);
    l1.add(bt1);
    
    bt2=new JButton("Cancel");
    bt2.setBackground(Color.RED);
    bt2.setForeground(Color.WHITE);
    bt2.setBounds(450,450,150,40);
    l1.add(bt2);
   
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    
    frame.setVisible(true);
    frame.setSize(900,600);
    frame.setLocation(300,100);
    frame.setResizable(false);
    }
    public void actionPerformed(ActionEvent e){
    String username=tf1.getText();
    String name=tf2.getText();
    String age=tf3.getText();
    String add=tf4.getText();
    String email=tf5.getText();
    String dob=tf6.getText();
    String gender=tf8.getText();
    String phone=tf7.getText();
    String pass=pf1.getText();
    String cnic=tf9.getText();
    
    if(e.getSource()==bt1){
    try{
    ConnectionClass obj=new ConnectionClass();
    String q="insert into employee values('"+username+"','"+name+"','"+age+"','"+dob+"','"+add+"','"+phone+"','"+email+"','"+pass+"','"+gender+"','"+cnic+"')";
    obj.stm.executeUpdate(q);
    JOptionPane.showMessageDialog(null,"Your details are successfully inserted");
    frame.setVisible(false);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
    }    
if(e.getSource()==bt2){
 frame.setVisible(false);
}
    
    }
    
    public static void main(String[] args) {
        new Add_Employee();
    }
 
}
