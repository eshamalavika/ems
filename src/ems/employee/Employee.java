package ems.employee;
import java.util.*;
import java.io.Serializable;

//Employee POJO class(Entity/ DTO-Data Transactional class)
public class Employee implements Serializable {
	private String name;
	private int employeeId;
	private int mobileNumber;
	private String emailId;
	private int basicPay;
	private	int hra;
	private int pf;
	private int da;
	private	int grossPay;
	private double netPay;
	
//Non Parametric and Parametric Constructors
	public Employee(){
		
	}

	public Employee(int employeeId,String name,int mobileNumber,String emailId, int basicPay, int hra, int da, int pf){
		this.employeeId = employeeId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.basicPay = basicPay;
		this.hra = hra;
		this.da = da;
		this.pf = pf;
	}
		
     //Setter and Getter Methods

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public int getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(int mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public int getBasicPay() {
			return basicPay;
		}

		public void setBasicPay(int basicPay) {
			this.basicPay = basicPay;
		}

		public int getHra() {
			return hra;
		}

		public void setHra(int hra) {
			this.hra = hra;
		}

		public int getPf() {
			return pf;
		}

		public void setPf(int pf) {
			this.pf = pf;
		}

		
		public int getDa() {
			return da;
		}

		public void setDa(int da) {
			this.da = da;
		}

		public int getGrossPay() {
			double allowance = (basicPay * hra/100) + (basicPay * da/100);
			grossPay = (int)(basicPay + allowance); 
			return grossPay;
		}


		public double getNetPay() {
			
			double detection = (basicPay * pf/100) ;
			netPay = getGrossPay() - detection;
			return netPay;
		}

		
}
	