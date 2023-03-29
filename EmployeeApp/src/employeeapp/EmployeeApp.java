
package employeeapp;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EmployeeApp {

    static JFrame frame;
    static JTable table;
    static String [][] temp;
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
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(75);
        table.getColumnModel().getColumn(2).setPreferredWidth(75);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(25);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.setRowSelectionAllowed(true); // by default is true
        ListSelectionModel rowSelectionModel = table.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(new MyEventHandler());
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
          
     }
    
    
    static class MyEventHandler implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int[] selectedRow = table.getSelectedRows();
            String id = "",ln = "",fn = "",city = "";
          //  for (int i = 0; i<selectedRow.length; i++){
                id = (String)(table.getValueAt(selectedRow[0], 0));
                ln = (String)(table.getValueAt(selectedRow[0], 1));
                fn = (String)(table.getValueAt(selectedRow[0], 2));
         //       city = (String)(table.getValueAt(selectedRow[i], 5));
          //  }
            StringBuilder sb = new StringBuilder();
            sb.append("Employee Info\n");
            sb.append("=============\n");
            sb.append("Employee ID : "+id + "\n");
            sb.append("Employee Last Name : "+ln + "\n");
            sb.append("Employee First Name : "+fn + "\n");
            sb.append("Employee City : "+city + "\n");
           JOptionPane.showMessageDialog(frame, "ID =  "+sb.toString() , "Record Selected", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }
}
