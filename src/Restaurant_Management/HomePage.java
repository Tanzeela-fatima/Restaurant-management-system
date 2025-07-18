
package Restaurant_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class HomePage  extends JFrame implements ActionListener{
JLabel l1;
Font f,f1;


HomePage(){
super("Restaurant Management Homepage for employee");
setLocation(0,0);
setSize(1280,780);

f=new Font("Arial",Font.BOLD,20);
f1=new Font("Arial",Font.BOLD,25);

ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Restaurant_Management/icon/home.jpeg"));  
    Image i1=img.getImage().getScaledInstance(1280, 780, Image.SCALE_SMOOTH);
    ImageIcon img1=new ImageIcon(i1);
    l1=new JLabel(img1);

    JMenuBar m1=new JMenuBar();
    
    JMenu menu1=new JMenu("Menu Item");
    JMenu menu2=new JMenu("Manage Order");
    JMenu menu3=new JMenu("About");

    menu1.setFont(f1);
    menu2.setFont(f1);
    menu3.setFont(f1);

    
    JMenuItem mt1=new JMenuItem("Add Item");
    JMenuItem mt2=new JMenuItem("Delete Item");
    JMenuItem mt3=new JMenuItem("Create Order");
    JMenuItem mt4=new JMenuItem("About");
    JMenuItem mt5=new JMenuItem("Exit");

    mt1.setFont(f);
    mt2.setFont(f);
    mt3.setFont(f);
    mt4.setFont(f);
    mt5.setFont(f);
   
    menu1.add(mt1);
    menu1.add(mt2);
    menu2.add(mt3);
    menu3.add(mt4);
    menu3.add(mt5);
    
    m1.add(menu1);
    m1.add(menu2);
    m1.add(menu3);

    m1.setBackground(Color.BLACK);
    
    menu1.setForeground(Color.WHITE);
    menu2.setForeground(Color.WHITE);
    menu3.setForeground(Color.WHITE);
// changing of color is remaining
    mt1.setForeground(Color.YELLOW);
    mt1.setBackground(Color.BLACK);
    
   mt1.addActionListener(this); 
   mt2.addActionListener(this); 
   mt3.addActionListener(this);
   mt4.addActionListener(this);
   mt5.addActionListener(this); 

setJMenuBar(m1);
add(l1);
}
public void actionPerformed(ActionEvent e){
    String cmnd=e.getActionCommand();
    if(cmnd.equals("Add Item")){
    new Add_Item().setVisible(true);
    }
   if(cmnd.equals("Delete Item")){
    new Delete_Item().setVisible(true);
    } 
   if(cmnd.equals("Create Order")){
    new CreateOrder().setVisible(true);
    } 
   if(cmnd.equals("About")){
    // Create a JDialog for the About information.
            JDialog aboutDialog = new JDialog(this, "About Us", true); // 'this' makes it modal.
            aboutDialog.setSize(400, 200); // Set the size of the dialog.
            aboutDialog.setLocationRelativeTo(this); // Center relative to the main frame.

            // Create a JLabel for the text.
            JLabel aboutLabel = new JLabel("<html><center>Restaurant Management System<br><br>Developed by [Tanzeela-Eesha-Eman]<br></center></html>", SwingConstants.CENTER);
            aboutLabel.setFont(f);

            // Add the label to the dialog's content pane.
            aboutDialog.getContentPane().add(aboutLabel);

            // Make the dialog visible.
            aboutDialog.setVisible(true);
    } 
  if(cmnd.equals("Exit")){
    System.exit(0);
    }
}
    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
    
}
