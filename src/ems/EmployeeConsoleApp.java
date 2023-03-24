package ems;

import ems.util.Helper;
import ems.employee.EmployeeHandler;
import ems.employee.EmployeeManagement;
import ems.employee.Employee;

import java.util.Enumeration;
import java.util.Hashtable;

public class EmployeeConsoleApp {

	public static void main(String[] args) {

		Employee employeeObj = null;
		int option;
		boolean result;
		String output;
		int id;

		do {

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~ Employee mangement System ~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" 1. Create  Employee   ");
			System.out.println(" 2. Display Employee  ");
			System.out.println(" 3. Update  Employee  ");
			System.out.println(" 4. Delete Employee  ");
			System.out.println(" 5. View all Employees  ");
			System.out.println(" 6. Exit ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" Enter the option (1-6) ");
			option = Helper.getI();

			switch (option) {
			case 1:

				System.out.println("Enter the new Employee details");
				employeeObj = EmployeeManagement.getEmployee();
				result = EmployeeHandler.addEmployee(employeeObj);
				if (result) {
					System.out.println("Employee Details added successfully ");
				} else {
					System.out.println("Please try again later ");
				}
				break;

			case 2:

				System.out.println("Enter the Employee Id to be Displayed : ");
				id = Helper.getI();
				employeeObj = EmployeeHandler.getEmployee(id);
				if (employeeObj != null) {
					System.out.println(EmployeeManagement.getEmployeeDetails(employeeObj));
				} else {
					System.out.println("There is no such employee with this Id ");
				}
				break;

			case 3:
				System.out.println("Enter the Id of Employee to be updated");

				id = Helper.getI();

				if (EmployeeHandler.isExist(id)) {

					employeeObj = EmployeeManagement.getEmployee();
					result = EmployeeHandler.updateEmployee(employeeObj);
					if (result) {
						System.out.println("Student details updated successfully");
					} else {
						System.out.println("Please try again later ");
					}

				} else {

					System.out.println("There is no student with this Register Number");

				}

				break;

			case 4:
				System.out.println("Enter the Employee Id to be Deleted : ");
				id = Helper.getI();
				output = EmployeeHandler.deleteEmployee(id);
				System.out.println(output);

				break;
			case 5:

				Hashtable<Integer, Employee> employees = null;

				try {
					employees = EmployeeHandler.getEmployees();
					if (employees != null) {
						Enumeration<Integer> enumeration = employees.keys();
						while (enumeration.hasMoreElements()) {
							id = enumeration.nextElement();
							employeeObj = employees.get(id);
							System.out.println(EmployeeManagement.getEmployeeDetails(employeeObj));
							System.out.println("--------------------------------------------");
						}

					} else {
						System.out.println("There is no data");
					}

				} catch (Exception e) {

				}

				break;

			case 6:
				System.out.println("Good Bye");
				System.exit(0);
				break;

			}

		} while (option != 6);
	}
}
