package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.EasySheetsModel;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class LoginController 
{
	@FXML
	private AnchorPane background;
	@FXML
	private AnchorPane loginBackground;
	@FXML
	private AnchorPane newUserPage;
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
	
	public static String inputUsername;
	
	static HashMap<String, String> login = new HashMap<String, String>();
	
	public void initialize() throws IOException{
    	
		usernameField.setStyle("-fx-text-inner-color: black");
		passwordField.setStyle("-fx-text-inner-color: black");
		Properties properties = EasySheetsModel.getProperties("login.properties");
		for(String key: properties.stringPropertyNames()) {
			login.put(key, properties.get(key).toString());
		}
		
	}
	
	public void makeNewUser(ActionEvent event)throws IOException
	{
		newUserPage = (AnchorPane)FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        Scene scene = new Scene(newUserPage,1200,720);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("New User");
        window.setScene(scene);
        window.show();
	}
	
    public void openHome(ActionEvent event) throws IOException {
    	background = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(background,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void entering(ActionEvent event)throws IOException
	{	
		inputUsername = usernameField.getText();
		String inputPassword = passwordField.getText();
		
		if(login.containsKey(inputUsername))
		{
			if(login.containsValue(inputPassword))
			{
				background = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
		    	Scene scene = new Scene(background,1200,720);
		    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		    	window.setScene(scene);
		    	window.show();
		    	usernameField.clear();
				passwordField.clear();
			}
			else {
				//ALERT SHOWING THE USER PASSWORD IS INCORRECT
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setContentText("ERROR: Password is incorrect.");
				alert.showAndWait();
			}
		}
		else
		{
			//ALERT SHOWING THE USER USERNAME IS INCORRECT
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("ERROR: Username does not exist.");
			alert.showAndWait();
		}	
		

	}
	
	

}
