package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Register extends HttpServlet
{

	private HttpSession Session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Model m=new Model();
		m.setFirstname(request.getParameter("fname"));
		m.setMiddlename(request.getParameter("mname"));
		m.setLastname(request.getParameter("lname"));
		m.setGender(request.getParameter("gender"));
		String dob=request.getParameter("dob");
		m.setDob(dob);
		String year=dob.substring(0,4);
		m.setYear(year);
		
		String std1=request.getParameter("standard");
		int standard=Integer.parseInt(std1);
		m.setStandard(standard);
		m.setRollno(request.getParameter("roll"));
		m.setAddress(request.getParameter("address"));
		
		try
		{
			boolean value=m.register();
			if(value==true)
			{
				Session=request.getSession(true);
				Session.setAttribute("fname",m.getFirstname());
				Session.setAttribute("mname",m.getMiddlename());
				Session.setAttribute("lname",m.getLastname());
				Session.setAttribute("standard",m.getStandard());
				Session.setAttribute("rollno",m.getRollno());
				Session.setAttribute("year",m.getYear());
				
				
				response.sendRedirect("/VNC/registersuccess.jsp");
			}
			else
			{
				response.sendRedirect("/VNC/error.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}
