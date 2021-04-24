package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
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
        window.setTitle("New User");
        window.setScene(scene);
        window.show();
	}
	
	public void entering(ActionEvent event)throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hayde\\eclipse-workspace\\MyTermProject\\src\\application\\Reasources\\UsernamePassword.txt"));
		String line = reader.readLine();
		if(usernames.size() == 0 && passwords.size() == 0)
		{
			while(line != null)
			{
				String[] split = line.split(", ");
				usernames.add(split[0]);
				passwords.add(split[1]);
			}
		}
		
		usernameField.clear();
		passwordField.clear();
		
	}
	
	

}
