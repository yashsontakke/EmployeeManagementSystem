import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername ;
    JTextField tfpassword ;
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,300,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150,70,300,30);
        add(tfpassword);

        JButton Login = new JButton("Login ");
        Login.setBounds(150,120,100,25);
        Login.setBackground(Color.BLACK);
        Login.setOpaque(true);
        Login.setBorderPainted(false);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        //        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee.jpeg"));
//        Image i2 = i1.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(475,20,275,183);
        add(image);


        setSize(800,300);
        setLocation(200,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            Conn c = new Conn();
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
                System.out.println("user login successful");
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password ");
            }
        }catch(Exception error){
           error.printStackTrace();
        }
    }
}
