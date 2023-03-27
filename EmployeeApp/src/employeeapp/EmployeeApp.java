
package employeeapp;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class EmployeeApp {

    static JFrame frame;
    static JTable table;
    static String [] [] temp;
    static ResultSet rs;
    static ArrayList<Employee> rowData = new ArrayList<Employee>();
     
    
    public static void main(String[] args) {
        // Frame
        frame = new JFrame("EmployeeApp");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 200);
        //LOGIC
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cis144sp",
                    "root",
                    ""
            );
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            Employee employee = new Employee();
            while (rs.next()){
                rowData.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                rs.getString(6),rs.getString(7),rs.getString(8),rs.getDouble(9)));
            }
            
            int counter = rowData.size();
            int r = 0;
            temp = new String [counter] [9];
            
            for (Employee emp : rowData){
                temp [r] [0]  = String.valueOf(emp.getId());
                temp [r] [1]  = emp.getLname();
                temp [r] [2] = emp.getFname();
                temp [r] [3] = emp.getAddress1();
                temp [r] [4] = emp.getAddress2();
                temp [r] [5] = emp.getCity();
                temp [r] [6] = emp.getState();
                temp [r] [7] = emp.getDOB();
                temp [r] [8] = String.valueOf(emp.getSalary());
                r++;
            }
            
            con.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        String [] columnTitle = {"ID", "Last Name", "First Name", "Address 1", "Address 2", "City", "State", "DOB", "Salary"};
        
        table = new JTable(temp, columnTitle);
        frame.add(table);
        frame.setVisible(true);
        
        
       
        
    }
    
}
