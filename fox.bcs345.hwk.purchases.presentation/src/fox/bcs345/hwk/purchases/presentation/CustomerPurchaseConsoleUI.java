package fox.bcs345.hwk.purchases.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fox.bcs345.hwk.purchases.business.Customer;
import fox.bcs345.hwk.purchases.business.Purchase;
import fox.bcs345.hwk.purchases.business.PurchaseCollection;

public class CustomerPurchaseConsoleUI {

	public void ShowUI(){
		int choice = 0;
		String filename = "";
		Customer c =  new Customer();
		Purchase p =  new Purchase();
		PrintStream ps;
		Scanner file;
		Scanner s = new Scanner(System.in);
		do{
			System.out.print("\n");
			System.out.println("Customer/Purchase UI");
			System.out.println("---------------------");
			System.out.println("1 - Read customer from file");
			System.out.println("2 - Write customer to file");
			System.out.println("3 -  Show customer info on screen");
			System.out.println("4 - Show customer JSON on screen");
			System.out.println("5 - Read purchase from file");
			System.out.println("6 - Write purchase to file");
			System.out.println("7 - Show purchase info on screen");
			System.out.println("8 - Show purchase JSON on screen");
			System.out.println("9 - Exit");
			
			choice = s.nextInt();
			
			switch(choice){
			
			case 1:
				
				System.out.println("Please enter a file name");
				
				try{
				filename = s.next();
			
				file = new Scanner(new File(filename));
				c.Read(file);
				
				}catch(InputMismatchException ime){
					
					System.out.println("WRONG INPUT TYPE!");
				}catch(FileNotFoundException fe){
					
					System.out.println("FILE DOES NOT EXIST!");
					
				}catch(NoSuchElementException nse){
					
					System.out.println("Missing information in file!");
				}
				break;
				
			case 2: 
				System.out.println("Enter in a file to write to");
				filename = s.next();
				try{
				ps =  new PrintStream(filename);
				c.Write(ps);
				ps.close();
				}catch(FileNotFoundException fe){
					
					System.out.println("COULD NOT WRITE TO FILE!");
				}catch(InputMismatchException ime){
					System.out.println("WRONG INPUT TYPE!");
				}
				break;
			case 3:
				System.out.println(c.toString());
			
				break;
			case 4:
				System.out.print(c.GetJSON());
				break;
			case 5:
				System.out.println("Enter in a file name");
				filename = s.next();
				try{
					file =  new Scanner(new File(filename)); 
					p.Read(file);
				}catch(FileNotFoundException fe){
					
					System.out.println("FILE DOES NOT EXIST!");
				}catch(InputMismatchException ime){
					
					System.out.println("WRONG INPUT TYPE!");
				}
				break;
				
			case 6:
				System.out.println("Enter in a file to write to");
				filename = s.next();
				try{
				ps =  new PrintStream(filename);
				p.Write(ps);
				ps.close();
				}catch(FileNotFoundException fe){
					
					System.out.println("COULD NOT WRITE TO FILE!");
				}catch(InputMismatchException ime){
					System.out.println("WRONG INPUT TYPE!");
				}
				break;
			case 7 :
				System.out.println(p.toString());
				break;
			case 8 :
				System.out.println(p.getJSON());
				break;
			case 9 : 
				break;
				
			
				
			default:
				System.out.println("INVALID OPTION!");
			}//end of switch
		}while(choice != 9);//End of do/while
		
		
	}//end of ShowUI
}
