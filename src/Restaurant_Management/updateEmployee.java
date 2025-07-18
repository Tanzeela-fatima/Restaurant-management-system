
package Restaurant_Management;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class updateEmployee  extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JButton bt1,bt2;
Choice ch1;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
Font f,f1;
JPanel p1,p2,p3;

    
updateEmployee(){
super("update Employee");
setLocation(450,10);
setSize(740,700);

f=new Font("Arial",Font.BOLD,25);
f1=new Font("Arial",Font.BOLD,20);

ch1=new Choice();
    try {
      ConnectionClass  obj= new ConnectionClass();
       String q="Select username from employee"; 
       ResultSet rest=obj.stm.executeQuery(q);
       while(rest.next()){
       ch1.add(rest.getString("username"));
       }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    ch1.setFont(f1);
    
    l1=new JLabel("Update Employee");
    l1.setHorizontalAlignment(JLabel.CENTER);
    l1.setFont(f);
    
    l2=new JLabel("Username");
    l3 =new JLabel("Name");
    l4 =new JLabel("Age");
    l5 =new JLabel("Date of birth");
    l6 =new JLabel("Address");
    l7 =new JLabel("Phone");
    l8 =new JLabel("Email");
    l9 =new JLabel("Password");
    l10 =new JLabel("Gender");
    l11 =new JLabel("CNIC");
    
    l1.setFont(f1);
     l2.setFont(f1);
      l3.setFont(f1);
       l4.setFont(f1);
        l5.setFont(f1);
         l6.setFont(f1);
          l7.setFont(f1);
           l8.setFont(f1);
            l9.setFont(f1);
             l10.setFont(f1);
              l11.setFont(f1);
       
    
    tf1 =new JTextField();
    tf2 =new JTextField();
    tf3 =new JTextField(); 
    tf4 =new JTextField();
    tf5 =new JTextField();
    tf6 =new JTextField();
    tf7 =new JTextField();
    tf8 =new JTextField();
    tf9 =new JTextField();
    
    
    tf1.setFont(f1);
    tf2.setFont(f1);
    tf3.setFont(f1);
    tf4.setFont(f1);
    tf5.setFont(f1);
    tf6.setFont(f1);
    tf7.setFont(f1);
    tf8.setFont(f1);
    tf9.setFont(f1);

    
    bt1 =new JButton("Edit Data");
     bt2 =new JButton("Back");
      
    bt1.setBackground(Color.BLACK);
    bt2.setBackground(Color.RED); 
    
    
    bt1.setForeground(Color.WHITE);
    bt2.setForeground(Color.WHITE);

     bt1.addActionListener(this);
      bt2.addActionListener(this);
     
     
     p1=new JPanel();
     p1.setLayout(new GridLayout(1,1,10,10));
     p1.add(l1);
     
     p2=new JPanel();
     p2.setLayout(new GridLayout(11,2,10,10));
     p2.add(l2);
     p2.add(ch1);
     p2.add(l3);
     p2.add(tf1);
         p2.add(l4);
       p2.add(tf2);
         p2.add(l5);
           p2.add(tf3);
       p2.add(l6);
         p2.add(tf4);
           p2.add(l7);
          p2.add(tf5);
            p2.add(l8);
              p2.add(tf6);
                p2.add(l9);
       p2.add(tf7);
         p2.add(l10);
          p2.add(tf8);
          p2.add(l11);
            p2.add(tf9);
              p2.add(bt1);
                p2.add(bt2);
                
                
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Restaurant_Management/icon/index.jpeg"));
    
    Image i1=img.getImage().getScaledInstance(200, 500, Image.SCALE_SMOOTH);
    ImageIcon img1=new ImageIcon(i1); 
    l12=new JLabel(img1);
               p3=new JPanel();
     p3.setLayout(new GridLayout(1,1,10,10));
     p3.add(l12);
     
     setLayout(new BorderLayout(10,10));
add(p1,"North");
add(p2,"Center");
add(p3,"West");

ch1.addMouseListener(new MouseAdapter()
{

@Override
public void mouseClicked(MouseEvent arg0){
    try {
        ConnectionClass obj=new ConnectionClass();
        String username=ch1.getSelectedItem();
        String q="Select * from employee where username='"+username+"' ";
        ResultSet rest1=obj.stm.executeQuery(q);
        while(rest1.next()){
        tf1.setText(rest1.getString("name"));
        tf2.setText(rest1.getString("age"));
        tf3.setText(rest1.getString("dob"));
        tf4.setText(rest1.getString("address"));
        tf5.setText(rest1.getString("phone"));
        tf6.setText(rest1.getString("email"));
        tf7.setText(rest1.getString("password"));
        tf8.setText(rest1.getString("gender"));
        tf9.setText(rest1.getString("cnic"));


        }
    } catch (Exception ex) {
       // ex.setStackTrace();
    }
}
}
);

}
public void actionPerformed(ActionEvent e){
 if(e.getSource()==bt1){
 String username=ch1.getSelectedItem();
 String name=tf1.getText();
 String age=tf2.getText();
  String dob=tf3.getText();
 String address=tf4.getText();
 String phone=tf5.getText();
 String email=tf6.getText();
  String pass=tf7.getText();
 String gender=tf8.getText();
 String cnic=tf9.getText();

     try {
         ConnectionClass obj=new ConnectionClass();
         String q="update employee set name='"+name+"',age='"+age+"',dob='"+dob+"',address='"+address+"',phone='"+phone+"',email='"+email+"',password='"+pass+"',gender='"+gender+"',cnic='"+cnic+"' where username='"+username+"'";         
    obj.stm.executeUpdate(q);
     int result=obj.stm.executeUpdate(q);
     if(result==1){
     JOptionPane.showMessageDialog(null,"Your data is successfullly updated");
     this.setVisible(false);
     }else{
          JOptionPane.showMessageDialog(null,"Please fill all details");

     }
     } catch (Exception ex) {
         ex.printStackTrace();
     }
         
 }
 if(e.getSource()==bt2){
 this.setVisible(false);
 }
    
}
    public static void main(String[] args) {
        new updateEmployee().setVisible(true);
    }
    
}
