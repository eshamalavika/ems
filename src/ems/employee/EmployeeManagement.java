package ems.employee;

import ems.util.Helper;


public class EmployeeManagement {
	
	
	public static Employee getEmployee(){
		String name;
		 int employeeId;
		 int mobileNumber;
		 String emailId;
		 int basicPay;
		 int hra;
		 int pf;
		 int da;
		 Employee employeeObj = null ;
		
		try {
				
				System.out.println("Enter the Emp id : ");
				employeeId = Helper.getI();
				System.out.println("Enter the Name : ");
				name = Helper.getS();
				System.out.println("Enter the email : ");
				emailId = Helper.getS();
				System.out.println("Enter the mobileNumber : ");
				mobileNumber = Helper.getI();
				System.out.println("Enter the Basic Pay : ");
				basicPay = Helper.getI();
				System.out.println("Enter the HRA : ");
				hra = Helper.getI();
				System.out.println("Enter the DA : ");
				da = Helper.getI();
				System.out.println("Enter the PF : ");
				pf = Helper.getI();
				
				employeeObj = new Employee( employeeId, name, mobileNumber,  emailId, basicPay, hra, da, pf);
				
        }catch(Exception e)
		
        {
        	System.out.println("Error : EmployeeManagement.java-getNewEmployee() : "+e.getMessage());
        }
		
        return employeeObj;
	}
	public static String getEmployeeDetails(Employee employeeObj)
	{
		String details = "";
		try {
				details += "Employee ID : " +  employeeObj.getEmployeeId() + "\n";
				details += "Employee Name : " +  employeeObj.getName() + "\n";
				details += "Mobile Number : " +  employeeObj.getMobileNumber()+ "\n";
				details += "Email ID : " +  employeeObj.getEmailId() + "\n";
				details += "Basic Pay : " +  employeeObj.getBasicPay() + "\n";
				details += "HRA : " +  employeeObj.getHra() + "\n";
				details += "DA : " +  employeeObj.getDa() + "\n";
				details += "PF : " +  employeeObj.getPf() + "\n";
				details += "Gross Pay : " +  employeeObj.getGrossPay() + "\n";
				details += "Net Pay : " +  employeeObj.getNetPay() + "\n";
				
		}catch(Exception e)
		
		 {
        	System.out.println("Error : EmployeeManagement.java-getEmployeeDetails(Employee) : "+e.getMessage());
        }
		
		return details;
	}
		
	
}