
package employeeapp;


public class Employee {
    
    protected int id;
    protected String lname;
    protected String fname;
    protected String address1;
    protected String address2;
    protected String city;
    protected String state;
    protected String DOB;
    protected double salary;

    public Employee() {}

    public Employee(String lname, String fname, String address1, String address2,
            String city, String state, String DOB, double salary) {
        super();
        this.lname = lname;
        this.fname = fname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;        
        this.DOB = DOB;
        this.salary = salary;
    }
    
    public Employee(int id, String lname, String fname, String address1, String address2,
            String city, String state, String DOB, double salary) {
        super();
        this.id = id;
        this.lname = lname;
        this.fname = fname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;        
        this.DOB = DOB;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLname() {
        return lname;
    }    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
   public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
   public String getDOB() {
        return DOB;
    }
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lname=" + lname + ", fname=" + fname 
                + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city 
                + ", state=" + state + ", DOB=" + DOB + ", salary=" + salary + '}';
    }
    
    


}
