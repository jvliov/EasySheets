package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LoginController 
{
	@FXML
	private AnchorPane background;
	@FXML
	private AnchorPane loginBackground;
	@FXML
	private AnchorPane newUserPage;
	@FXML
	private AnchorPane Home;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button submit;
	@FXML
	private Button newUser;
	@FXML
	private TextField user;
	
	
	public static ArrayList<String> usernames = new ArrayList<String>();
	public static ArrayList<String> passwords = new ArrayList<String>();
	
	public void makeNewUser(ActionEvent event)throws IOException
	{
		newUserPage = (AnchorPane)FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        Scene scene = new Scene(newUserPage,1200,720);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Creating a User");
        window.setScene(scene);
        window.show();
	}
	
	public void entering(ActionEvent event)throws IOException
	{
		int usernameIndex = 100;
		int passwordIndex = 100;
		
		//JUST READING IN THE FILE WITH THE USERNAMES AND PASSWORDS TO DATA SYSTEM
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hayde\\eclipse-workspace\\MyTermProject\\src\\application\\Reasources\\UsernamePassword.txt"));
		String line = reader.readLine();
        if(usernames.size() == 0 && passwords.size() == 0) {
            while (line != null) {
                String[] splitString = line.split(", ");
                usernames.add(splitString[0]);
                passwords.add(splitString[1]);
                // read next line
                line = reader.readLine();
            }
        }
        reader.close();
		
		String inputUsername = usernameField.getText();
		String inputPassword = passwordField.getText();
		
		if(!usernames.contains(inputUsername) && !passwords.contains(inputPassword))
		{
			//ALERT SHOWING THE USER USERNAME OR PASSWORD IS INCORRECT
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
			alert.setContentText("ERROR: Wrong username or password");
			alert.showAndWait();
		}
		if(usernames.contains(inputUsername))
		{
			usernameIndex = usernames.indexOf(inputUsername);
		}
		
		
		if(passwords.contains(inputPassword))
		{
			passwordIndex = passwords.indexOf(inputPassword);
		}
		
		//System.out.print(usernameIndex + " " + passwordIndex);
		
		if((usernameIndex == passwordIndex) && usernameIndex != 100 && passwordIndex != 100)
		{	
			usernameField.clear();
			passwordField.clear();
			
			Home = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
	        Scene scene = new Scene(Home,1200,720);
	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setTitle("Home");
	        window.setScene(scene);
	        window.show();
		}
		
		else
		{
			//ALERT SHOWING THE USER USERNAME OR PASSWORD IS INCORRECT
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
			alert.setContentText("ERROR: Wrong username or password");
			alert.showAndWait();
			
			usernameField.clear();
			passwordField.clear();
		}

	}
	
	//THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openHome(ActionEvent event) throws IOException {
    	background = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(background,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
	
	

}
