package fox.bcs345.hwk.purchases.business;
import java.io.PrintStream;
import java.util.Scanner;

import fox.bcs345.hwk.purchases.business.Address;
public class Customer {

	private String First;
	private String Last;
	private Address Address;
	
	//default constructor
	public Customer(){
		
		First = "default first name";
		Last = "default last name";
		Address =  new Address();
	}
	
	//print address
	public void Write(PrintStream ps){
		
		ps.println(First);
		ps.println(Last);
		Address.Write(ps);
	}
	
	public void Read(Scanner s){
		
		First = s.nextLine();
		Last = s.nextLine();
		Address.read(s);
	}
	
	public String getFirst(){
		
		return First;
	}
	public String getLast(){
		
		return Last;
	}
	
	public Address getAddress(){
		
		return Address;
	}
	
	public void setFirst(String newFirst){
		
		First = newFirst;
		
	}
	
	public void setLast(String newLast){
		
		Last = newLast;
	}
	
	public void setAddress(Address newAddress){
		
		Address =  newAddress;
	}
	public String GetJSON(){
		
		String myJSON = String.format(" { \n  \"first\" : \"%s\",\n  \"last\" : \"%s\", \n  \"address\" :\n ",First,Last) + Address.GetJSON();
		
		return myJSON;
		 
	}
	
	@Override
	public String toString(){
		
		String toString = First + "\r\n" + Last + "\r\n" + Address.toString();
		
		return toString;
	}
}// end of Customer class
