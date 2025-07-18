
package Restaurant_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
public class Add_Item  extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton bt1,bt2;
Choice ch1,ch2;
JTextField tf1,tf2,tf3,tf4;
JPanel p1,p2,p3;
Font f,f1;

Add_Item(){
super("Add Food Item");
setLocation(50,10);
setSize(800,400);
setResizable(false);

f=new Font("Arial",Font.BOLD,25);
f1=new Font("Arial",Font.BOLD,17);

l1=new JLabel("Add More Item");
l1.setHorizontalAlignment(JLabel.CENTER);
l1.setForeground(Color.BLACK);
l1.setFont(f);

l2=new JLabel("Item ID");
l3=new JLabel("Item Source");
l4=new JLabel("Item Name");
l5=new JLabel("Item Username");
l6=new JLabel("Employee Name");
l7=new JLabel("Price");

l1.setFont(f1);
l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);
l7.setFont(f1);

 tf1=new JTextField();
 tf2=new JTextField();
 tf3=new JTextField();
 tf4=new JTextField();

tf1.setFont(f1);
tf2.setFont(f1);
tf3.setFont(f1);
tf4.setFont(f1);

Random r=new Random();
tf1.setText(""+Math.abs(r.nextInt()%100000));
tf1.setForeground(Color.RED);
tf1.setEditable(false);
tf3.setEditable(false);

ch1=new Choice();
ch1.add("Drink");
ch1.add("Dessert");
ch1.add("food");


ch2=new Choice();
try{
ConnectionClass obj=new ConnectionClass();
String q="Select username from employee" ;
ResultSet rest=obj.stm.executeQuery(q);
while(rest.next()){
ch2.add(rest.getString("username"));
}
}
catch(Exception ex){
ex.printStackTrace();
}
ch1.setFont(f1);
ch2.setFont(f1);

bt1=new JButton("Add Item");
bt2=new JButton("Cancel");

bt1.setFont(f1);
bt2.setFont(f1); 

bt1.setForeground(Color.BLACK);
bt2.setForeground(Color.WHITE);

bt1.setBackground(Color.YELLOW);
bt2.setBackground(Color.RED);

bt1.addActionListener(this);
bt2.addActionListener(this);

   ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Restaurant_Management/icon/addItem.jpeg"));
    Image img=ic.getImage().getScaledInstance(350, 320, Image.SCALE_SMOOTH);
    ImageIcon ic1=new ImageIcon(img);
    l8=new JLabel(ic1);

p1=new JPanel(); 
p1.setLayout(new GridLayout(1,1,10,10));
p1.add(l1);

p2=new JPanel(); 
p2.setLayout(new GridLayout(7,2,10,10));
p2.add(l2);
p2.add(tf1);
p2.add(l3);
p2.add(ch1);
p2.add(l4);
p2.add(tf2);
p2.add(l5);
p2.add(ch2);
p2.add(l6);
p2.add(tf3);
p2.add(l7);
p2.add(tf4);
p2.add(bt1);
p2.add(bt2);

p3=new JPanel(); 
p3.setLayout(new GridLayout(1,1,10,10));
p3.add(l8);

setLayout(new BorderLayout(10,10));
add(p1,"North");
add(p3,"West");
add(p2,"Center");

ch2.addMouseListener(new MouseAdapter(){
      
    @Override
        public void mouseClicked(MouseEvent agr0){
        try{
        ConnectionClass obj=new ConnectionClass();
        String username=ch2.getSelectedItem();
        String q="Select * from employee where username='"+username+"' ";
        ResultSet rest=obj.stm.executeQuery(q);
        if(rest.next()){
        tf3.setText(rest.getString("name"));
        }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
        }
});
}
public void actionPerformed(ActionEvent e){
    String item_id=tf1.getText();
    String source=ch1.getSelectedItem();
    String item_name=tf2.getText();
    String username=ch2.getSelectedItem();
    String name=tf3.getText();
    String price=tf4.getText();
    
    if(e.getSource()==bt1){
     try{
        ConnectionClass obj=new ConnectionClass();
        
        String q="insert into item values('"+item_id+"','"+source+"','"+item_name+"','"+username+"','"+name+"','"+price+"')";
        int result=obj.stm.executeUpdate(q);
       
        if(result==1){
        JOptionPane.showMessageDialog(null,"item details successfully inserted");
        this.setVisible(false);
        }
        else{
        JOptionPane.showMessageDialog(null,"Please fill the details carefully");
        }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
    }
    if(e.getSource()==bt2){
    this.setVisible(false);
    }
    
}
    public static void main(String[] args) {
        new Add_Item().setVisible(true);
    }
    
}
