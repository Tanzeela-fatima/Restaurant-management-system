
package Restaurant_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class CreateOrder  extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JButton bt1,bt2;
JPanel p1,p2,p3;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
Choice ch1,ch2,ch3;
Font f,f1;
CreateOrder(){
super("Create Order");
setLocation(50,10);
setSize(800,650);

f=new Font("Arial",Font.BOLD,25);
f1=new Font("Arial",Font.BOLD,18);

ch1=new Choice();
try {
      ConnectionClass  obj= new ConnectionClass();
       String q="Select distinct source from item"; 
       ResultSet rest=obj.stm.executeQuery(q);
       while(rest.next()){
       ch1.add(rest.getString("source"));
       }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
ch1.setFont(f1);

l1=new JLabel("Create Order");
l1.setHorizontalAlignment(JLabel.CENTER);
l1.setFont(f);

l2=new JLabel("Order ID");
l3=new JLabel("Item Source"); 
l4=new JLabel("Item Name");
l5=new JLabel("Employee Username");
l6=new JLabel("Employee Name");
l7=new JLabel("One Item Price");
l8=new JLabel("Customer Name");
l9=new JLabel("Customer Phone");
l10=new JLabel("No of item");

l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);
l7.setFont(f1);
l8.setFont(f1);
l9.setFont(f1);
l10.setFont(f1);

tf1=new JTextField();
tf2=new JTextField();
tf3=new JTextField();
tf4=new JTextField();
tf5=new JTextField();
tf6=new JTextField();

tf1.setFont(f1);
tf2.setFont(f1);
tf3.setFont(f1);
tf4.setFont(f1);
tf5.setFont(f1);
tf6.setFont(f1);

tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);

bt1=new JButton("Create Order");
bt2=new JButton("Cancel");

bt1.setForeground(Color.BLACK);
bt2.setForeground(Color.WHITE);

bt1.setBackground(Color.YELLOW);
bt2.setBackground(Color.RED);

ch2=new Choice();
try {
      ConnectionClass  obj= new ConnectionClass();
       String q="Select * from employee"; 
       ResultSet rest=obj.stm.executeQuery(q);
       while(rest.next()){
       ch2.add(rest.getString("username"));
       }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
//ch2.setFont(f1);

ch3=new Choice();

ch1.addMouseListener(new MouseAdapter()
{
@Override
public void mouseClicked(MouseEvent agr0){
ch3.removeAll();
try{
ConnectionClass  obj= new ConnectionClass();
       String source=ch1.getSelectedItem();
       String q="select * from item where source='"+source+"'  ";
       ResultSet rest=obj.stm.executeQuery(q);
       while(rest.next()){
       ch3.add(rest.getString("itemname"));
       }

}catch(Exception ex){
ex.printStackTrace();
}
}
});

ch3.addMouseListener(new MouseAdapter()
{
@Override
public void mouseClicked(MouseEvent agr0){
try{
ConnectionClass  obj= new ConnectionClass();
       String source=ch1.getSelectedItem();
       String item_name=ch3.getSelectedItem();
       String q="select * from item where source='"+source+"' and ItemName='"+item_name+"'  ";
       ResultSet rest=obj.stm.executeQuery(q);
       while(rest.next()){
       tf3.setText(rest.getString("Price"));
       }

}catch(Exception ex){
ex.printStackTrace();
}
}
});

ch2.addMouseListener(new MouseAdapter()
{
@Override
public void mouseClicked(MouseEvent agr0){
try{
ConnectionClass  obj= new ConnectionClass();
       String username=ch2.getSelectedItem();
       String q="select * from employee where Username='"+username+"'   ";
       ResultSet rest=obj.stm.executeQuery(q);
       while(rest.next()){
       tf2.setText(rest.getString("name"));
       }

}catch(Exception ex){
ex.printStackTrace();
}
}
});

Random r=new Random();
tf1.setText(""+Math.abs(r.nextInt()%100000));
tf1.setForeground(Color.RED);

ch2.setFont(f1);
ch3.setFont(f1);

bt1.setFont(f1);
bt2.setFont(f1);

bt1.addActionListener(this);
bt2.addActionListener(this);

p1=new JPanel();
p1.setLayout(new GridLayout(1,1,10,10));
p1.add(l1);

p2=new JPanel();
p2.setLayout(new GridLayout(10,2,10,10));
p2.add(l2);
p2.add(tf1);
p2.add(l3);
p2.add(ch1);
p2.add(l4);
p2.add(ch3);
p2.add(l5);
p2.add(ch2);
p2.add(l6);
p2.add(tf2);
p2.add(l7);
p2.add(tf3);
p2.add(l8);
p2.add(tf4);
p2.add(l9);
p2.add(tf5);
p2.add(l10);
p2.add(tf6);
p2.add(bt1);
p2.add(bt2);

  ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Restaurant_Management/icon/index.jpeg"));
    
    Image i1=img.getImage().getScaledInstance(370, 350, Image.SCALE_SMOOTH);
    ImageIcon img1=new ImageIcon(i1); 
    l11=new JLabel(img1);
               p3=new JPanel();
     p3.setLayout(new GridLayout(1,1,10,10));
     p3.add(l11);
     
     setLayout(new BorderLayout(10,10));
add(p1,"North");
add(p2,"Center");
add(p3,"West");




}
public void actionPerformed(ActionEvent e){
 if(e.getSource()==bt1){
 String order_id=tf1.getText();
 String source =ch1.getSelectedItem();
 String item_name=ch3.getSelectedItem();
 String username=ch2.getSelectedItem();
 String name=tf2.getSelectedText();
 float price=Float.parseFloat(tf3.getText());
 String cname=tf4.getText();
 String phone=tf5.getText();
 float no_item=Float.parseFloat(tf6.getText());
 float total_price=price*no_item;
 if(cname.isEmpty() || phone.isEmpty() ){
  JOptionPane.showMessageDialog(null,"Details should not be empty");     
 }else{
 try{
ConnectionClass  obj= new ConnectionClass();
       String q="insert into OrderItem values('"+order_id+"','"+source+"','"+item_name+"','"+username+"','"+name+"','"+price+"','"+cname+"','"+phone+"','"+no_item+"','"+total_price+"')";
      int aa=obj.stm.executeUpdate(q);
      if(aa==1){
      JOptionPane.showMessageDialog(null,"Data inserted");
      this.setVisible(false);
      }
      else{
         JOptionPane.showMessageDialog(null,"please fill all the details");     
              }
}catch(Exception ex){
ex.printStackTrace();
} 
 }
 }   
if(e.getSource()==bt2){
 this.setVisible(false);
 }       
}
    public static void main(String[] args) {
        new CreateOrder().setVisible(true);
    }
    
}
