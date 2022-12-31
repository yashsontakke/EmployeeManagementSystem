import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c ;
    Statement s ;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeeManagementSystem","root" , "MyNewPass");
            System.out.println(c);
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
