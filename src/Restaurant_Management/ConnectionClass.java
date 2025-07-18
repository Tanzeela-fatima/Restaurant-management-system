
package Restaurant_Management;

import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
   
    ConnectionClass(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rms ","root","2612007");
         stm=con.createStatement();
            System.out.println("db is connected");
        }
        catch(Exception ex){
            System.out.println(ex);
        } 
    }
    public static void main(String[] args) {
        ConnectionClass c=new ConnectionClass();
    }
}
