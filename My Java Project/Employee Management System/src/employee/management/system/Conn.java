package employee.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;



public class Conn {
	Connection c;
	Statement e ;
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Suman@123");
			e = c.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
