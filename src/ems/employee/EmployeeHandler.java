package ems.employee;
import ems.util.FileHandler;
import java.util.Hashtable;
import java.io.Serializable;

public class EmployeeHandler implements Serializable {

	private static Hashtable<Integer, Employee> employees;

	static {
		
		employees = FileHandler.readData();
		if(employees == null) {
			employees = new Hashtable<Integer, Employee>();
		}
	}

	// function to add an Employee object into the Hashtable

	public static boolean addEmployee(Employee employeeObj) {
		boolean result = false;
		try {

			employees.put(employeeObj.getEmployeeId(), employeeObj);
			FileHandler.writeData(employees);
			result = true;

		} catch (Exception e) {

			System.out.println("Error : EmployeeHandler.java-addEmployee(Employee) : " + e.getMessage());
		}
		return result;
	}

	// function to delete an Employee object from the Hashtable

	public static String deleteEmployee(int employeeId) {

		String result = "There is no such employee with this Id";
		try {
			if (isExist(employeeId)) {
				employees.remove(employeeId);
				FileHandler.writeData(employees);
				result = "Employee details deleted successfully ";
			}

		} catch (Exception e) {
			result = "Please try again later";
			System.out.println("Error : EmployeeHandler.java-deleteEmployee(int) : " + e.getMessage());
		}
		return result;
	}

	// function to delete an Employee object from the Hashtable

	public static boolean updateEmployee(Employee employeeObj) {

		boolean result = false;
		try {

			employees.remove(employeeObj.getEmployeeId());
			employees.put(employeeObj.getEmployeeId(), employeeObj);
			FileHandler.writeData(employees);
			result = true;

		} catch (Exception e) {

			System.out.println("Error : EmployeeHandler.java-updateEmployee(Employee) : " + e.getMessage());
		}
		return result;
	}

	// function to get an Employee object from the Hashtable

	public static Employee getEmployee(int employeeId) {

		Employee employeeObj = null;
		try {
			if (employees.containsKey(employeeId)) {
				employeeObj = employees.get(employeeId);

			}

		} catch (Exception e) {

			System.out.println("Error : EmployeeHandler.java-getEmployee(int) : " + e.getMessage());
		}
		return employeeObj;
	}

	public static Hashtable<Integer, Employee> getEmployees() {
		try {
			return employees;
		} catch (Exception e) {

			System.out.println("Error : EmployeeHandler.java-getEmployees() : " + e.getMessage());
			return null;
		}
	}

	public static boolean isExist(int employeeId) {
		// return false;

		if (employees.containsKey(employeeId)) {
			return true;
		} else {
			return false;
		}
	}

}
