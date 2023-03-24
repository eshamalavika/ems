package ems.util;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;
public class FileHandler{

	private static String dataFile;

	static{
		dataFile = "Employees.data";
	}

	public static void setDataFileName(String file){
		dataFile = file;
	}


	public static Hashtable readData(){

		 FileInputStream inputFIS = null;
		 ObjectInputStream outputOIS = null;

		 Hashtable htEmployees = null;
		 try {
		 	 inputFIS = new FileInputStream(dataFile);
			 outputOIS = new ObjectInputStream(inputFIS);

			 htEmployees = (Hashtable) outputOIS.readObject();
			 inputFIS.close();
			 outputOIS.close();

			}
			catch(Exception e) {
				System.out.println("Error : FileHandler.java-readData() : " + e.getMessage());
			}

		 return htEmployees;
	}
	public static boolean writeData(Hashtable htEmployees){

		FileOutputStream outputFOS = null;
		ObjectOutputStream outputOOS = null;
		boolean result = false;

		try{
			outputFOS = new FileOutputStream(dataFile);
			outputOOS = new ObjectOutputStream(outputFOS);
			outputOOS.writeObject(htEmployees);
			
			outputFOS.close();
			outputOOS.close();
			result = true;
		}
		catch(Exception e) {
			
			System.out.println("Error : FileHandler.java-writeData(Hashtable) : " + e.getMessage());
		}

		return result;
	}
}
