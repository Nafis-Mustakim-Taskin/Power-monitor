package application;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.*;
public class Main extends Application
{
	double a;
	Stage window;
	String user = "taskin";
	String pw = "2015338012";
	String s="WARNING!!! UNIT 8 & UNIT 9 ARE CONSUMING TOO MUCH POWER ";
	String trans = "trx2015";
	String checkUser,checkPW,checkTrans;
	Button button,button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,closeButton;
	Scene scene1, scene2,scene3,scene4,scene5,scene6,scene7,scene8,sceneA;
	public static void main(String[] args)
	{
		
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		//primaryStage.setTitle("Power Solution");
		Label label1 = new Label ("Welcome to Power Solution!!!");
		label1.setTranslateX(180);
		label1.setTranslateY(120);
		Button button1 = new Button("Get Started");
		button1.setTranslateX(215);
		button1.setTranslateY(120);
		button1.setOnAction(e-> window.setScene(scene2));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1,button1);
		//layout1.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1,540,360);
		
		
         GridPane grid = new GridPane();
        
         
         grid.setVgap(8);
         grid.setHgap(8);
        
         
         Label passLabel = new Label ("User ID");
         GridPane.setConstraints(passLabel, 0, 1);
         passLabel.setTranslateX(170);
 		 passLabel.setTranslateY(120);
         
         TextField passInput = new TextField();
         passInput.setPromptText("User ID");
         GridPane.setConstraints(passInput, 1, 1);
         passInput.setTranslateX(170);
 		 passInput.setTranslateY(120);
         
GridPane grid2 = new GridPane();
        
         
         grid2.setVgap(8);
         grid2.setHgap(8);
         
         
         Label passLabel2 = new Label ("Password");
         GridPane.setConstraints(passLabel2, 0, 2);
         passLabel2.setTranslateX(165);
 		 passLabel2.setTranslateY(130);
         
         TextField passInput2 = new TextField();
         passInput2.setPromptText("Password");
         GridPane.setConstraints(passInput2, 1, 2);
         passInput2.setTranslateX(165);
 		 passInput2.setTranslateY(130);
         
         Button loginButton = new Button("Sign in");
         GridPane.setConstraints(loginButton, 1, 3);
         loginButton.setTranslateX(170);
 		 loginButton.setTranslateY(140);
         grid.getChildren().addAll(passLabel,passLabel2,passInput,passInput2,loginButton);
         
         scene2 = new Scene(grid, 540,360);
         
         
         loginButton.setOnAction(new EventHandler<ActionEvent>()
        		 {
        	 public void handle(ActionEvent event)
        	 {
        		checkUser = passInput.getText().toString();
        		checkPW = passInput2.getText().toString();
        		if(checkUser.equals(user) && checkPW.equals(pw))
        		{
        			window.setScene(scene3);
        			
        		}
        		else
        		{
        			window.setScene(scene7);
        		}
        	 }
        		 });
        
         Button button3 = new Button("Analyze Power Usage");
         button3.setTranslateX(200);
         Button button4 = new Button("Pay Electric Bill");
         button4.setTranslateX(220);
         Button button5 = new Button("Current Status");
         button5.setTranslateX(205);
         Button button8 = new Button("Sign out");
         button8.setTranslateX(235);
         
              
         VBox layout2 = new VBox(20);
         Label hometxt= new Label("  USER PROFILE\n===========================================\n  Name : Nafis Mustakim\n  User ID : 2015338012\n ===========================================");
 		layout2.getChildren().addAll(hometxt,button3,button4,button5,button8);
 		
 		Label labelw = new Label (s);
		labelw.setTranslateX(130);
		labelw.setTranslateY(130);
 		closeButton = new Button("Return to Home Page");
 		closeButton.setTranslateX(215);
		closeButton.setTranslateY(120);
		closeButton.setOnAction(e-> window.setScene(scene3));
		
		VBox layoutw = new VBox(20);
		layoutw.getChildren().addAll(labelw,closeButton);
		//layout1.setAlignment(Pos.CENTER);
		scene8 = new Scene(layoutw,540,360);
 		scene3 = new Scene(layout2,540,320);

 		button3.setOnAction(new EventHandler<ActionEvent>()
		 {
	 public void handle(ActionEvent event)
	 {
		DBConnect db = new DBConnect();
		db.getData();
		a=db.calData();
		if(a>70000)
			{
			System.out.print("You Are Consuming too Much Power");
			window.setScene(scene8);
			}
		
	 }
		 });
 		
 		button4.setOnAction(e-> window.setScene(scene4));
 		button5.setOnAction(new EventHandler<ActionEvent>()
		 {
	 public void handle(ActionEvent event)
	 {
		DBConnect db = new DBConnect();
		db.getStatus();
		
	 }
		 });
 		
 		button8.setOnAction(e-> window.setScene(scene2));
 		
 		
 		GridPane grid1 = new GridPane();
        
        grid1.setVgap(8);
        grid1.setHgap(8);
     
        Label passLabel1 = new Label ("Transectoin ID");
        GridPane.setConstraints(passLabel1, 0, 1);
        passLabel1.setTranslateX(110);
		 passLabel1.setTranslateY(120);
        
        TextField passInput1 = new TextField();
        passInput1.setPromptText("Transection ID");
        GridPane.setConstraints(passInput1, 0, 1);
        passInput1.setTranslateX(200);
		 passInput1.setTranslateY(120);
        
         
        Button button6 = new Button("CONFIRM");
        GridPane.setConstraints(button6, 1, 2);
        button6.setTranslateX(30);
		button6.setTranslateY(130);
        Label transtxt = new Label ("Give your TRANSACTION ID here ");
    	transtxt.setTranslateX(170);
		transtxt.setTranslateY(110);
        grid1.getChildren().addAll(transtxt, passLabel1,passInput1,button6);
        scene4 = new Scene(grid1, 540,320);
        
        //button6.setOnAction(e-> window.setScene(scene5));
        button6.setOnAction(new EventHandler<ActionEvent>()
		 {
	 public void handle(ActionEvent event)
	 {
		checkTrans = passInput1.getText().toString();
		if(checkTrans.equals(trans))
		{
			DBConnect db = new DBConnect();
			db.setStatus();
			window.setScene(scene5);
		}
		else 
		{
			window.setScene(scene6);
		}
	 }
		 });
        
        Label label3 = new Label ("Congrartulations!Your payment is clear.");
        label3.setTranslateX(170);
		label3.setTranslateY(120);
		Button button7 = new Button("Return to home page");
		button7.setTranslateX(205);
		button7.setTranslateY(120);
		button7.setOnAction(e-> window.setScene(scene3));
		
		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(label3,button7);
		scene5 = new Scene(layout3,540,320);
		
		Label label4 = new Label ("Sorry!! Transection ID could not be found");
		label4.setTranslateX(150);
		label4.setTranslateY(120);
		Button button11 = new Button("Try again");
		button11.setTranslateX(215);
		button11.setTranslateY(120);
		Button button9 = new Button("Return to your home page");
		button9.setTranslateX(165);
		button9.setTranslateY(120);
		button11.setOnAction(e-> window.setScene(scene4));
		button9.setOnAction(e-> window.setScene(scene3));
		VBox layout4 = new VBox(20);
		layout4.getChildren().addAll(label4,button11,button9);
		scene6 = new Scene(layout4,540,320);
		
		Label label5 = new Label ("Sorry!! Password Is Incorrect");
		label5.setTranslateX(180);
		label5.setTranslateY(120);
		Button button10 = new Button("Try again");
		button10.setTranslateX(215);
		button10.setTranslateY(120);
		button10.setOnAction(e-> window.setScene(scene2));
		
		VBox layout5 = new VBox(20);
		layout5.getChildren().addAll(label5,button10);
		scene7 = new Scene(layout5,540,320);
		
         window.setScene(scene1);
         window.setTitle("Power Solution");
         window.show();
         
	
	}
}