package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
	
	Random ran = new Random();
	int min = 100000; 
    int max = 999999;
	int number = ran.nextInt(max - min + 1) + min;
	JButton add,back;
	JTextField tname,tfname,tsalary,taddress, tphone, temail, tdesignation, tAadhar;
	JDateChooser dob;
	JComboBox tqualification;
	JLabel labelemId2;
	AddEmployee(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
		heading.setBounds(320, 30, 500, 50);//Used for set dimension
		heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
		add(heading);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);//Used for set dimension
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		tname = new JTextField();
		tname.setBounds(200, 150, 150, 30);
		add(tname);
		
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
		
		dob = new JDateChooser();
		dob.setBounds(200, 200, 150, 30);
		add(dob);
		
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
		
		String [] courses = {"BTECH","BCA","BSC","BCom.","BA","BBA","MTECH","MCA","MSC","MCom","MA","MBA","PHD"};
		tqualification = new JComboBox(courses);
		tqualification.setBackground(Color.WHITE);
		tqualification.setBounds(550, 300, 150, 30);
		add(tqualification);
		
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
		
		tAadhar = new JTextField();
		tAadhar.setBounds(550, 350, 150, 30);
		add(tAadhar);
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50, 400, 150, 30);//Used for set dimension
		labelempId.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelempId);
		
		labelemId2 = new JLabel(""+ number);
		labelemId2.setBounds(200, 400, 150, 30);//Used for set dimension
		labelemId2.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelemId2);
		
		add = new JButton("Add Details");
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
	    if (ae.getSource() == add) {
	        String name = tname.getText();
	        String fname = tfname.getText();
	        String dob1 = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
	        String salary = tsalary.getText();
	        String address = taddress.getText();
	        String phone = tphone.getText();
	        String email = temail.getText();
	        String education = (String) tqualification.getSelectedItem();
	        String designation = tdesignation.getText();
	        String aadhar = tAadhar.getText();
	        String empId = labelemId2.getText();

	        // Validate phone number
	        if (!isValidPhoneNumber(phone)) {
	            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter a 10-digit phone number.");
	            return;
	        }
	        if (!isValidAadharNumber(aadhar)) {
	            JOptionPane.showMessageDialog(null, "Invalid Aadhar number. Please enter a 12-digit Aadhar number.");
	            return;
	        }
	        try {
	            Conn c = new Conn();
	            String query = "insert into employee values('" + name + "','" + fname + "','" + dob1 + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empId + "')";
	            c.e.executeUpdate(query);
	            JOptionPane.showMessageDialog(null, "Details added successfully");
	            setVisible(false);
	            new Home();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else {
	        setVisible(false);
	        new Home();
	    }
	}
	private boolean isValidPhoneNumber(String phone) {
	    return phone.matches("\\d{10}");
	}
	private boolean isValidAadharNumber(String aadhar) {
	    return aadhar.matches("\\d{12}");
	}

	public static void main(String[] args) {
		new AddEmployee();
	}

}

