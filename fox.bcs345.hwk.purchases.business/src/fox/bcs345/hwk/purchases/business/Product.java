package fox.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;

public class Product {

	private String description;
	private double price;
	
	
	public Product(){
		
		description = "default description";
		price = 0.0;
	}
	
	public String getDesc(){
		
		return description;
		
	}
	public void setDesc(String newDesc){
		
		description = newDesc;
		
	}
	public double getPrice(){
		
		return price;
		
	}
	
	public void setPrice(double newPrice){
		
		price  = newPrice;
	}
	
	public void Read(Scanner s){
		
		description = s.nextLine();
		price = s.nextDouble();
		s.nextLine();
		
		
	}
	
	public void Write(PrintStream ps){
		
		ps.println(description);
		ps.println(price);
		
	}
	
	public String GetJSON(){
		
		String myJSON = String.format("{ \t\"description\" : \" %s\",\n \t\"price\" : %.2f\n }",description,price);
		
		return myJSON;		
	
	}
	
	public String toString(){
		
	String myString = description+","+" "+"$"+price+"\n";	
	
	return myString;
	}
	
	
}
