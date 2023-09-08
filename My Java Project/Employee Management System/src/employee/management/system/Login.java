package employee.management.system;

 

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

 

public class Login extends JFrame implements ActionListener{
	
	JTextField tusername,tpassword;
	
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 100, 300, 30);
        lblusername.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblusername);

        tusername = new JTextField();
        tusername.setBounds(200, 100, 150, 30);
        add(tusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 150, 100, 30);
        lblpassword.setFont(new Font("serif", Font.PLAIN, 25));
        add(lblpassword);

        tpassword = new JTextField();
        tpassword.setBounds(200, 150, 150, 30);
        add(tpassword);

        JButton login = new JButton("Login");
        login.setBounds(160, 260, 150, 30);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\My Java Project\\Employee Management System\\icons\\second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, -30, 350, 350);
        add(image);

        setSize(700,500);
        setLocation(400,200);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae) {
    	try {
    		String username = tusername.getText();
    		String password = tpassword.getText();
    		
    		Conn c = new Conn();
    		
    		String query = "select * from login where username = '"+username+"' and password ='"+password+"'";
    		
    		
    		ResultSet rs = c.e.executeQuery(query);
    		if(rs.next()) {
    			setVisible(false);
    			new Home();
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Invalid Username or Password");
    			setVisible(false);
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	 
    }

 

    public static void main(String[] args) {
        new Login();

 

    }

 

}