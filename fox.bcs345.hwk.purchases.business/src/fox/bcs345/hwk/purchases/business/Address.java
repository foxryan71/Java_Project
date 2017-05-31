package fox.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;

public class Address {

	
	
	private String number;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address(){
		
		number = "default number";
		street = "default street";
		city = "default city";
		state = "default state";
		zip = "default zip";
	}
	
	public Address(String newNumber, String newStreet, String newCity, String newState, String newZip){
		
		number = newNumber;
		street = newStreet;
		city = newCity;
		state = newState;
		zip = newZip;
		
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String newNumber){
		
		number = newNumber;
	}
	
	public String getStreet(){
		
		return street;
	}
	public void setStreet(String newStreet){
		
		street = newStreet;
	}
	
	public String getCity(){
		
		
		return city;
	}
	
	public void setCity(String newCity){
		
		city = newCity;
	}
	
	public String getState(){
		
		return state;
	}
	
	public void setState(String newState){
		
		state =  newState;
	}
	
	public String getZip(){
		
		return zip;
		
	}
	
	public void setZip(String newZip){
		
		zip = newZip;
	}
	
	public void Write(PrintStream ps){
		
		ps.println(number);
		ps.println(street);
		ps.println(city);
		ps.println(state);
		ps.println(zip);
	}
	
	public void read(Scanner s){
		
		number = s.nextLine();
		street = s.nextLine();
		city = s.nextLine();
		state = s.nextLine();
		zip = s.nextLine();
		
	}
	
	
	public String GetJSON(){
		
		
	 String myJSON = String.format("{ \n  \"number\" : \"%s\",\n  \"street\" : \"%s\",\n  \"city\" : \"%s\",\n  \"state\" : \"%s\",\n  \"zip\" : \"%s\"\n }", number,street,city,state,zip);
	
		return myJSON;
	}
	
	@Override
	
	public String toString(){
		
	String myString = number+" "+street+"\r\n"+city+","+" "+state+","+" "+zip+"\r\n \r\n";
	
	return myString;
	}
	
	
	
}
