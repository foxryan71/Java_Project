package fox.bcs345.hwk.purchases.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fox.bcs345.hwk.purchases.business.Purchase;
import fox.bcs345.hwk.purchases.business.PurchaseCollection;

public class PurchaseCollectionConsoleUI {

	
	public void ShowUI(){
		PurchaseCollection pc =  new PurchaseCollection();
		PrintStream ps;
		Scanner file;
		String filename;
		Scanner s = new Scanner(System.in);
		int index =0;
		Purchase p = new Purchase();
		
		int choice =0;
		do{
			System.out.println("PurchaseCollection UI");
			System.out.println("---------------------");
			System.out.println("1 - Read PurchaseCollection from file");
			System.out.println("2 - Write PurchaseCollection to file");
			System.out.println("3 - Show Purchase by index");
			System.out.println("4 - Show maximum purchase");
			System.out.println("5 - Show PersonCollection as JSON string on screen");
			System.out.println("6 - Show PersonCollection report on screen");
			System.out.println("7 - Show PurchaseCollection toString on screen");
			System.out.println("8 - Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Please enter a file name");
					
					try{
					filename = s.next();
				
					file = new Scanner(new File(filename));
					pc.Read(file);
					
					}catch(InputMismatchException ime){
						
						System.out.println("WRONG INPUT TYPE!");
					}catch(FileNotFoundException fe){
						
						System.out.println("FILE DOES NOT EXIST!");
						
					}catch(NoSuchElementException nse){
					
						
						
						System.out.printf("Missing information from file! Was suppose to be "+ pc.getAmount() + "\n");
						
					}
					
					
					break;
					
				case 2:
					System.out.println("Enter in a file to write to");
					filename = s.next();
					try{
					ps =  new PrintStream(filename);
					pc.Write(ps);
					ps.close();
					}catch(FileNotFoundException fe){
						
						System.out.println("COULD NOT WRITE TO FILE!");
					}catch(InputMismatchException ime){
						System.out.println("WRONG INPUT TYPE!");
					}
					break;
				case 3:
					
					System.out.println("Please enter in an index.");
					try{
					index = s.nextInt();
					 System.out.println(pc.GetByIndex(index));
					}catch(ArrayIndexOutOfBoundsException ex){
						
						System.out.println("INDEX OUT OF BOUNDS");
					}
					break;
					
				case 4:
					
					System.out.println(pc.GetMaxPurchase());
					 break;
				case 5:
					System.out.println(pc.GetJSON());
					break;
				case 6:	
					ps =  new PrintStream(System.out);
					pc.Report(ps);
					
					break;
				case 7:
					System.out.println(pc.toString());
					break;
				case 8:
					break;
				default:
					System.out.println("INVALID OPTION!");
					break;
				case 9:
					System.out.println("Please enter a file name");
					
					try{
					filename = s.next();
				
					file = new Scanner(new File(filename));
					p.Read(file);
					
					}catch(InputMismatchException ime){
						
						System.out.println("WRONG INPUT TYPE!");
					}catch(FileNotFoundException fe){
						
						System.out.println("FILE DOES NOT EXIST!");
						
					}
					break;
			}//end of switch
			
			
		}while(choice !=8);
	}
}
