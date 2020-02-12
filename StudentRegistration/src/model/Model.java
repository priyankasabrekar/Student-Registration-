package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	String firstname;
	String middlename;
	String lastname;
	String gender;
	String dob;
	int standard;
	String rollno;
	String address;
	String year;

	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String user = "system";
	String pwd = "system";

	String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?)";
	private Connection con;
	private PreparedStatement pstmt;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Model() 
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection(url, user, pwd);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public boolean register() throws Exception
	{
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, firstname);
		pstmt.setString(2, middlename);
		pstmt.setString(3, lastname);
		pstmt.setString(4, gender);
		pstmt.setInt(5, standard);
		pstmt.setString(6, rollno);
		pstmt.setString(7, address);
		pstmt.setString(8, dob);

		int row = pstmt.executeUpdate();
		if (row == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
