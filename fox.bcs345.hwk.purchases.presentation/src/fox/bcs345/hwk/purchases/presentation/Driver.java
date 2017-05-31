package fox.bcs345.hwk.purchases.presentation;
import fox.bcs345.hwk.purchases.business.Product;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import fox.bcs345.hwk.purchases.business.*;
public class Driver{
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		/*
		Scanner cin = new Scanner(System.in);
		// file reading
		
		
	
		Scanner FileScanner1 = new Scanner(new File("addressFile"));
	
		
		Scanner FileScanner2 =  new Scanner(new File("productFile"));
	
		PrintStream ps1 = new PrintStream("outfile.txt");
		
		PrintStream ps2 =  new PrintStream("outfile2.txt");
		
		Scanner FileScanner3 =  new Scanner(new File("outfile.txt"));
		
		
		String thisNumber="40";
		String thisStreet = "Winnecomac Circle";
		String thisCity = "Kings Park";
		String thisState = "NY";
		String thisZip = "11754";
		
		String thisDesc = "iPhone7";
		double thisPrice = 199.99;
		
		//creating instances of address and product
		Address add = new Address();
		Product pro =  new Product();

		add.setNumber("40");
		add.setStreet("Winnecomac Circle");
		add.setCity("Kings Park");
		add.setState("NY");
		add.setZip("11754");
		pro.setDesc("iPhone7");
		pro.setPrice(199.99);
		
		
		testClass test = new testClass();
		
		System.out.println(test.checkNumber(thisNumber, add.getNumber()));
		System.out.println(test.checkStreet(thisStreet, add.getStreet()));
		System.out.println(test.checkCity(thisCity, add.getCity()));
		System.out.println(test.checkState(thisState, add.getState()));
		System.out.println(test.checkZip(thisZip, add.getZip()));
		System.out.println(test.checkDesc(thisDesc, pro.getDesc()));
		System.out.println(test.checkPrice(thisPrice, pro.getPrice()));
		
		add.read(FileScanner1);
		add.Write(ps1);
		pro.Read(FileScanner2);
		pro.Write(ps1);
		
		add.read(FileScanner3);
		add.Write(ps2);
		pro.Read(FileScanner3);
		pro.Write(ps2);
		
		Customer customer =  new Customer();
		
		System.out.println(customer.getAddress());
		
		Purchase purchase =  new Purchase();
		
		System.out.println(purchase.toString());
	*/
		
		
		int choice =0;
		Scanner s = new Scanner(System.in);
		CustomerPurchaseConsoleUI cpc =  new CustomerPurchaseConsoleUI();
		PurchaseCollectionConsoleUI pcc =  new PurchaseCollectionConsoleUI();
		
		do{
			
			System.out.println("1 - CustomerPurchaseConsoleUI");
			System.out.println("2 - PurchaseCollectionConsoleUI");
			System.out.println("3 - PurchasesGraphicalUI");
			System.out.println("4 - Exit");
			choice = s.nextInt();
			
			switch(choice){
			
				case 1:
					cpc.ShowUI();
					break;
				case 2:
					pcc.ShowUI();
					break;
				case 3:
					Application.launch(PurchasesApplication.class,args);
					break;
				case 4:
					break;
				default :
					System.out.println("INVALID OPTION!");
					break;
			}
			
		}while(choice != 4);

		
		
	}



}
