package application;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.*;

class DBConnect
{
	private Connection con;
	private Statement st;
	private ResultSet rs; 
	public DBConnect(){
		try{
 
			Class.forName("com.mysql.jdbc.Driver"); //include the jar file at the libraries
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ePay","root","");
			st = con.createStatement();
			
			System.out.println("Analysis Report:");
		}
 
		catch(Exception e) {
			System.out.println("Error : "+e);
		}
	}
 
	public void getData(){
		try{
			String query = "select * from pusage" + " order by PowerUsage desc ";
			rs = st.executeQuery(query);
			//System.out.println("Records /////");
 
			while(rs.next()){
				int Unit = rs.getInt("Unit");
				double PowerUsage = rs.getDouble("PowerUsage");
				
				System.out.print("Unit: " + Unit);
				System.out.print("   PowerUsage:"+ PowerUsage);
				System.out.println("   Unit Bill:"+ PowerUsage*3 + " BDT");
				
			}
 
		}
		catch(Exception ex){
			System.out.println("Error at statement : "+ex);
		}
	}
	public double calData(){
		try{
			String query = "select sum(PowerUsage) from pusage";
			rs = st.executeQuery(query);
			//System.out.println("Records /////");
 
			while(rs.next()){
			
				double total = rs.getDouble(1);
				total= total*3;
				System.out.println("  Current Bill :"+ total+" BDT");
				return total;
			}
 
		}
		catch(Exception ex){
			System.out.println("Error at statement : "+ex);
		}
		return 0;
	}

	public void getStatus(){
		try{
			String query = "select * from status";
			rs = st.executeQuery(query);
			//System.out.println("Records /////");
 
			while(rs.next()){
				String month = rs.getString("Month");
				int bill = rs.getInt("billstatus");
				System.out.print("Unit: " + month);
				if (bill == 1)
				System.out.println("   Bill paid  ");
				else
					System.out.println("   Bill NOT paid  ");
				
			}
 
		}
		catch(Exception ex){
			System.out.println("Error at statement : "+ex);
		}
	}
	public void setStatus(){
		try{
			String query = "UPDATE status set billstatus='1' WHERE Month = 'July'";
			st.executeUpdate(query);
	       
		}
		catch(Exception ex){
			System.out.println("Error at statement : "+ex);
		}
	}
	
	}
