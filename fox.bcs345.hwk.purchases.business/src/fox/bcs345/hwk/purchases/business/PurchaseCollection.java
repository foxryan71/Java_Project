package fox.bcs345.hwk.purchases.business;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class PurchaseCollection{
	private int amt = 0;
	private Customer customer;
	private Purchase purchase[] = new Purchase[amt];
	public PurchaseCollection(){
		
		customer =  new Customer();
		
		for(int i = 0; i <purchase.length;++i){
			
			purchase[i] =  new Purchase();
		}
	}//end of default constructor
	
	public void SetCustomer(Customer c){
		
		customer = c;
	}
	
	public Customer GetCustomer(){
		
		return customer;
	}
	
	//finds the max purchase
	public Purchase GetMaxPurchase(){
		
		Purchase max =  purchase[1];
		for(int i =0;i<purchase.length;++i){
			
			if(purchase[i].getTotalPrice() >= max.getTotalPrice()){
				
				max = purchase[i];
			}
			
			
		}//end of for loop
		
		return max;
	}
	public Purchase[] getPurchase(){
		
		return purchase;
	}
	
	
	public Purchase GetByIndex(int index){
		
		return purchase[index]; 
	
	}//end of GetByIndex
	
	public void Report(PrintStream ps){
		
		ps.println("Purchase Report");
		ps.println("----------------");
		ps.printf(customer.toString());
		
		ps.printf("%-30s %25s %25s %25s","Description","Price","Quantity","Cost");
		ps.println();
		
		ps.printf("%-30s %25s %25s %25s","----------------","----------------","----------------","----------------");
		ps.println();
		
		double total = 0;
		int total_quantity =0;
		for (int i=0; i<purchase.length;++i){
			ps.printf("%-30s %25.2f %25d %25.2f ",purchase[i].getProduct().getDesc(),purchase[i].getProduct().getPrice(),purchase[i].getQuanity(),purchase[i].getTotalPrice());
			ps.println();
			total += purchase[i].getTotalPrice();
			total_quantity += purchase[i].getQuanity(); 
			
		}
		ps.printf("%-30s %51s %25s","----------------","----------------","----------------","----------------\n");
		ps.println();
		ps.printf("%-30s %51d %25.2f", "Total",total_quantity,total);
		ps.println();
	}//end of Report
	
	public void Write(PrintStream ps){
		
		customer.Write(ps);
		
		for(Purchase thispurchase : purchase )
		{
			
			thispurchase.Write(ps);
			
		}//end of foreach loop
	}//end of Write
	
	public void Read(Scanner s){
		
		amt = s.nextInt();
		s.nextLine();
		purchase = new Purchase[amt];
		for(int i = 0; i < amt;++i){
			
			this.purchase[i] =  new Purchase();
		}
		//System.out.print(purchase.length);
		customer.Read(s);
		
		for(Purchase thispurchase : purchase )
		{
			
			thispurchase.Read(s);
			
		}//end of foreach loop
	
	}
	
	public String GetJSON(){
			String purchaseJSON ="";
			for(int i =0; i<purchase.length;++i)
			{
				
				
				purchaseJSON += purchase[i].getJSON() + ",\n";
				
				if(i == amt){
					purchaseJSON += purchase[i].getJSON()+"\n";
					
					
				}
			}
		
			String myJSON ="{\n"  +" \"customer\" :\n" + customer.GetJSON() + "\n},\n " +"\"purchases\" :\n[\n " + purchaseJSON +"]\n }";
			
			return myJSON;
		
	}
	
	@Override
	public String toString(){

	
		
		String purchase_toString = "";
		for(Purchase thispurchase : purchase)
		{
			purchase_toString += thispurchase.toString();
		}
		
		String toString = customer.toString() + purchase_toString;
		
		return toString;
	}
	
	//gets the amount of purchases in file 
	public int getAmount(){
		
		return amt;
	}
	
	

}

