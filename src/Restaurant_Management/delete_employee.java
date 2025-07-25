
package Restaurant_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class delete_employee extends JFrame implements ActionListener {
    JTable t;
    JButton bt1;
    JTextField tf1;
    JPanel p1,p2,p3;
    JLabel l1,l2;
    Font f,f1;
    String x[]= {"Employee Username","Name","Email","Age","DOB","Gender"};
    String y[][]= new String [20][6];
    int i=0,j=0;
    
    delete_employee() {
         super("All Employee Records");
         setSize(1480,400);
         setLocation(0,10);
         
         f=new Font("MS UI Gothic",Font.BOLD,17);
         
         try{
             ConnectionClass obj = new ConnectionClass();
            String q = "Select * from employee"; 
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]= rest.getString("username");
                y[i][j++]= rest.getString("name");
                y[i][j++]= rest.getString("email");
                y[i][j++]= rest.getString("age");
                y[i][j++]= rest.getString("dob");
                y[i][j++]= rest.getString("gender");
                i++;
                j=0;
            }
            t=new JTable(y,x);
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
         t.setBackground(Color.BLACK);
         t.setForeground(Color.WHITE);
         t.setFont(f);
         
         JScrollPane js=new JScrollPane(t);
         
         f1=new Font("Lucida Fax",Font.BOLD,25);
         
         l1=new JLabel("Delete Any Employee");
         l1.setHorizontalAlignment(JLabel.CENTER);
         l1.setFont(f1);
         l1.setForeground(Color.YELLOW);
         
         l2=new JLabel("Employee Username");
         l2.setFont(f1);
         l2.setForeground(Color.GRAY);
         
         tf1=new JTextField();
         bt1=new JButton("Delete Employee");
         bt1.setBackground(Color.BLACK);
         bt1.setForeground(Color.RED);
         
         bt1.setFont(f);
         tf1.setFont(f);
         bt1.addActionListener(this);
         
         p1=new JPanel();
         p1.setLayout(new GridLayout(1,1,10,10));
         p1.add(l1);
         
         p2=new JPanel();
         p2.setLayout(new GridLayout(1,3,10,10));
         p2.add(l2);
         p2.add(tf1);
         p2.add(bt1);
         
         p3=new JPanel();
         p3.setLayout(new GridLayout(2,1,10,10));
         p3.add(p1);
         p3.add(p2);
         
         p1.setBackground(Color.BLACK);
         p2.setBackground(Color.BLACK);
         p3.setBackground(Color.BLACK);
         
         add(p3,"South");
         add(js);
         
    }
    public void actionPerformed(ActionEvent arg){
        if(arg.getSource()==bt1)
        {
            String e_username=tf1.getText();
            if(e_username.isEmpty()){
             JOptionPane.showMessageDialog(null, "Employee username should not be empty.");   
            }
            else{
             
            try
            {
               ConnectionClass obj = new ConnectionClass();
            String q = "delete from employee where username='"+e_username+"'";
            int res=obj.stm.executeUpdate(q);
            if(res ==1)
            {
                JOptionPane.showMessageDialog(null, "Your data is successfully deleted.");
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Your data could not be deleted.");
                this.setVisible(false);
                this.setVisible(true);

            }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
}
            }
        }
    }
     
        public static void main(String[] args) {
         new delete_employee().setVisible(true);
     }
}



