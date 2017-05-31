package fox.bcs345.hwk.purchases.business;
import java.awt.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.filechooser.FileFilter;


import javafx.scene.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class PurchasesApplication extends Application {

	PurchaseCollection purchases;
	
	public PurchasesApplication(){
		
		purchases =  new PurchaseCollection();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// sets up window
		primaryStage.setTitle("Purchase Application");
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.show();
		//end of setting up window
		
		// create VBox
			VBox c_Vbox =  new VBox();
			
		// customer tab
		TabPane tabPane = new TabPane();
		
		
		
	
		
		//create tabs
		Tab customer_tab = new Tab();
		customer_tab.setText("Customer");
		
		Tab purchases_tab = new Tab();
		purchases_tab.setText("Purchases");
		
		
		GridPane gp = new GridPane();
		gp.setHgap(30);
		gp.setVgap(10);
		
		MenuBar mb =  new MenuBar();
		Menu fileMenu =  new Menu("File");
		
		//create menu items
		MenuItem save_as = new MenuItem("Save As...");
		MenuItem save_report = new MenuItem("Save Report...");
		MenuItem exit = new MenuItem("Exit");
		MenuItem open =  new MenuItem("Open...");
		
		SeparatorMenuItem s1 =  new SeparatorMenuItem();
		SeparatorMenuItem s2 =  new SeparatorMenuItem();
		//add items to menu
		fileMenu.getItems().addAll(open,s1,save_as,save_report,s2,exit);
		
		mb.getMenus().add(fileMenu);
		c_Vbox.getChildren().add(mb);
		
		//create labels
		Label firstLabel = new Label("First Name");
		Label lastLabel =  new Label ("Last Name");
		Label numberLabel =  new Label("Number");
		Label streetLabel = new Label("Street");
		Label cityLabel = new Label("City");
		Label stateLabel =  new Label("State");
		Label zipLabel = new Label("Zip");
		
		
		//Create text fields & make them non editable
		TextField first_txt = new TextField();
		first_txt.setEditable(false);
		TextField last_txt =  new TextField(); 
		last_txt.setEditable(false);
		TextField number_txt =  new TextField();
		number_txt.setEditable(false);
		TextField street_txt = new TextField();
		street_txt.setEditable(false);
		TextField city_txt = new TextField();
		city_txt.setEditable(false);
		TextField state_txt = new TextField();
		state_txt.setEditable(false);
		TextField zip_txt = new TextField();
		zip_txt.setEditable(false);
		
		//Add all labels
		gp.add(firstLabel,0,0);
		gp.add(first_txt,1,0);
		gp.add(lastLabel,0,1);
		gp.add(last_txt,1,1);
		gp.add(numberLabel,0,2);
		gp.add(number_txt,1,2);
		gp.add(streetLabel, 0, 3);
		gp.add(street_txt, 1, 3);
		gp.add(cityLabel, 0, 4);
		gp.add(city_txt, 1, 4);
		gp.add(stateLabel, 0, 5);
		gp.add(state_txt,1,5);
		gp.add(zipLabel, 0, 6);
		gp.add(zip_txt, 1, 6);
		customer_tab.setClosable(false);
		
		ListView <Purchase> lv = new ListView<>();
		
		
		
		lv.setOrientation(Orientation.VERTICAL);
		
		purchases_tab.setContent(lv);
		customer_tab.setContent(gp);
		
		//adds tab to tabPane
		tabPane.getTabs().addAll(customer_tab,purchases_tab);
		c_Vbox.getChildren().add(tabPane);
		Scene main_scene = new Scene(c_Vbox,500,300);
		
		//set primaryStage scene
		primaryStage.setScene(main_scene);
		
		// handle and create events
		
		//start of open event
		open.setOnAction(new EventHandler<ActionEvent>(){
			
			
			public void handle (ActionEvent t){
				
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open File");
				Path currentRelativePath = Paths.get("");
				//gets path for the file directory
				String absolutePath = currentRelativePath.toAbsolutePath().toString();
				File filedirectory = new File(absolutePath);
				fileChooser.setInitialDirectory(filedirectory);
				File file =fileChooser.showOpenDialog(primaryStage);

				Scanner s;
			
				
				try {
					s = new Scanner(new File(file.getPath()));
					System.out.println(file.getPath());
					purchases.Read(s);
				} catch (FileNotFoundException e) {
					
					System.out.println("File Not Found!");
				}catch(NoSuchElementException nse){
					
					System.out.println("Missing information from file!");
				}catch(NullPointerException npe){
					
					System.out.println("No file selected.");
				}
				
				first_txt.setText(purchases.GetCustomer().getFirst());
				last_txt.setText(purchases.GetCustomer().getLast());
				street_txt.setText(purchases.GetCustomer().getAddress().getStreet());
				city_txt.setText(purchases.GetCustomer().getAddress().getCity());
				state_txt.setText(purchases.GetCustomer().getAddress().getState());
				zip_txt.setText(purchases.GetCustomer().getAddress().getZip());
				number_txt.setText(purchases.GetCustomer().getAddress().getNumber());
				
				lv.getItems().clear();
				ObservableList<Purchase> items = FXCollections.observableArrayList(purchases.getPurchase());
				
				lv.setItems(items);
				
				lv.setOrientation(Orientation.VERTICAL);
				purchases_tab.setContent(lv);
				
			}
			
			}
		);//end of open event.
		
		save_as.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent t){
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save File");
				Path currentRelativePath = Paths.get("");
				String absolutePath = currentRelativePath.toAbsolutePath().toString();
				File filedirectory = new File(absolutePath);
				fileChooser.setInitialDirectory(filedirectory);
				File file =fileChooser.showSaveDialog(primaryStage);
				
				PrintStream ps;
				
				try{
					
					ps = new PrintStream(new File(file.getPath()));
					System.out.println(file.getPath());
					purchases.Write(ps);
				}catch(FileNotFoundException e){
					
					System.out.println("Could not save to file!");
				}catch(NullPointerException npe){
					
					System.out.println("No file selected.");
				}catch(NoSuchElementException nse){
					
					System.out.println("Missing information from file!");
				}
				
				
			}
		}
		);
		
		save_report.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent t){
				
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save Report");
				Path currentRelativePath = Paths.get("");
				String absolutePath = currentRelativePath.toAbsolutePath().toString();
				File filedirectory = new File(absolutePath);
				fileChooser.setInitialDirectory(filedirectory);
				File file =fileChooser.showSaveDialog(primaryStage);
				
				PrintStream ps;
				
				try{
					System.out.println(file.getPath());
					ps = new PrintStream(new File(file.getPath()));
					
					purchases.Report(ps);
				}catch(FileNotFoundException e){
					
					System.out.println("Could not save to file!");
				}catch(NullPointerException npe){
					
					System.out.println("No file selected");
				}catch(NoSuchElementException nse){
					
					System.out.println("Missing information from file!");
				}
				
				
			}
		}
		);
		
		exit.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent t){
			
				primaryStage.close();
				System.exit(0);
				
			}
		}
		);
	}
	
	
}
