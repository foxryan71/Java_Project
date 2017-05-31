package fox.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.Scanner;

public class Purchase {

	private Product Product;
	private int Quantity;
	
	public Purchase(){
		
		Product = new Product();
		Quantity = 0;
		
	}
	
	public Product getProduct(){
		
		return Product;
	}
	public int getQuanity(){
		
		return Quantity;
	}
	
	public void setQuantity(int newQuantity){
		
		Quantity = newQuantity;
	}
	
	public void setProduct(Product newProduct){
		
		Product = newProduct;
	}
	
	public void Write(PrintStream ps){
		
		ps.println(Quantity);
		Product.Write(ps);
	}
	
	public void Read(Scanner s){
		Quantity = s.nextInt();
		s.nextLine();
		Product.Read(s);
		
		
	}
	public Double getTotalPrice(){
		
		double total = Product.getPrice() * Quantity;
		
		return total;
	}
	
	public String getJSON(){
		
		String myJSON = "{\n \"product\" :\n " + Product.GetJSON() + String.format(" \n	\"quantity\" :  %d \n}", Quantity);
		
		return myJSON;
	}
	
	@Override
	
	public String toString(){
		
		String toString = Integer.toString(Quantity) +", "+ Product.toString(); 
		
		return toString;
	}
}
