package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class UpdateEmployee extends JFrame implements ActionListener{
	 
	JButton add,back;
	JTextField teducation,tfname,tsalary,taddress, tphone, temail, tdesignation, tAadhar;
	JDateChooser dob;
	JLabel labelemId2;
	String dempId;
	
	UpdateEmployee(String dempId){
		this.dempId = dempId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
		heading.setBounds(320, 30, 500, 50);//Used for set dimension
		heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
		add(heading);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);//Used for set dimension
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200, 150, 150, 30);
		add(lblname);
		
		JLabel labelfname = new JLabel("Father's Name");
		labelfname.setBounds(400, 150, 150, 30);//Used for set dimension
		labelfname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelfname);
		
		tfname = new JTextField();
		tfname.setBounds(550, 150, 150, 30);
		add(tfname);
		
		JLabel labeldob = new JLabel("Date of Birth");
		labeldob.setBounds(50, 200, 150, 30);//Used for set dimension
		labeldob.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldob);
		
		JLabel lbldob = new JLabel();
		lbldob.setBounds(200, 200, 150, 30);
		add(lbldob);
		
		JLabel labelsalary = new JLabel("Salary");
		labelsalary.setBounds(400, 200, 150, 30);//Used for set dimension
		labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelsalary);
		
		tsalary = new JTextField();
		tsalary.setBounds(550, 200, 150, 30);
		add(tsalary);
		
		JLabel labelAddress = new JLabel("Address");
		labelAddress.setBounds(50, 250, 150, 30);//Used for set dimension
		labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelAddress);
		
		taddress = new JTextField();
		taddress.setBounds(200, 250, 150, 30);
		add(taddress);
		
		JLabel labelPhone = new JLabel("Phone");
		labelPhone.setBounds(400, 250, 150, 30);//Used for set dimension
		labelPhone.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelPhone);
		
		tphone = new JTextField();
		tphone.setBounds(550, 250, 150, 30);
		add(tphone);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(50, 300, 150, 30);//Used for set dimension
		labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelEmail);
		
		temail = new JTextField();
		temail.setBounds(200, 300, 150, 30);
		add(temail);
		
		JLabel labelqualification = new JLabel("Highest Education");
		labelqualification.setBounds(400, 300, 150, 30);//Used for set dimension
		labelqualification.setFont(new Font("serif", Font.PLAIN, 18));
		add(labelqualification);
		
		
		teducation = new JTextField();
		teducation.setBackground(Color.WHITE);
		teducation.setBounds(550, 300, 150, 30);
		add(teducation);
		
		JLabel labeldesignation = new JLabel("Designation");
		labeldesignation.setBounds(50, 350, 150, 30);//Used for set dimension
		labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldesignation);
		
		tdesignation = new JTextField();
		tdesignation.setBounds(200, 350, 150, 30);
		add(tdesignation);
		
		JLabel labelAadhar = new JLabel("Aadhar Number");
		labelAadhar.setBounds(400, 350, 150, 30);//Used for set dimension
		labelAadhar.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelAadhar);
		
		JLabel lblAadhar = new JLabel();
		lblAadhar.setBounds(550, 350, 150, 30);
		add(lblAadhar);
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50, 400, 150, 30);//Used for set dimension
		labelempId.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelempId);
		
		JLabel lblemId2 = new JLabel();
		lblemId2.setBounds(200, 400, 150, 30);//Used for set dimension
		lblemId2.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblemId2);
		
		try {
			Conn c = new Conn();
			String query = "select * from employee where empId = '"+dempId+"'";
			ResultSet rs = c.e.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				tfname.setText(rs.getString("fname"));
				lbldob.setText(rs.getString("dob"));
				tsalary.setText(rs.getString("salary"));
				taddress.setText(rs.getString("address"));
				tphone.setText(rs.getString("phone"));
				temail.setText(rs.getString("email"));
				teducation.setText(rs.getString("education"));
				tdesignation.setText(rs.getString("designation"));
				lblAadhar.setText(rs.getString("aadhar"));
				lblemId2.setText(rs.getString("empId"));
				
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        add(back);
		
		
		setSize(900, 700);
		setLocation(300,50);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String fname = tfname.getText();
			String salary = tsalary.getText();
			String address = taddress.getText();
			String phone = tphone.getText();
			String email = temail.getText();
			String education = teducation.getText();
			String designation = tdesignation.getText();
			
			try {
				Conn c = new Conn();
				String query = "update employee set fname = '"+fname+"',salary ='"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empId ='"+dempId+"'";
				c.e.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details updated successfully");
				setVisible(false);
				new Home();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Home();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateEmployee("");
	}

}
