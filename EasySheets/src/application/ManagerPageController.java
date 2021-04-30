package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.EasySheetsModel;

public class ManagerPageController extends LoginController{
	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView homBtn;
	@FXML
	private ImageView shtBtn;
	@FXML
	private ImageView setBtn;
	@FXML
	private Button addNewUser;
	@FXML
	private Button doneAdding;
	@FXML
	private GridPane newUserGrid;
	@FXML
	private TextField nameField;
	@FXML
	private TextField dobField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField wageField;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwdField;
	@FXML
	private TextField empTypeField;
	@FXML
	private TextField mondayField;
	@FXML
	private TextField tuesdayField;
	@FXML
	private TextField wednesdayField;
	@FXML
	private TextField thursdayField;
	@FXML
	private TextField fridayField;
	@FXML
	private TextField saturdayField;
	@FXML
	private TextField sundayField;
	@FXML
	private GridPane datesGrid;
	@FXML
	private HBox selectBox;
	@FXML
	private TextField employee;
	@FXML
	private Button doneSchedule;
	@FXML
	private Button selectUsername;
	@FXML
	private Button cancelAddBtn;
	@FXML
	private Label addSchedLabel;
	
	HashMap<String, String> user = new HashMap<String, String>();
	HashMap<String, String> login = new HashMap<String, String>();
	
	public void initialize() throws IOException{
		String userFileName = inputUsername + ".properties";
		Properties properties = EasySheetsModel.getProperties(userFileName);
		
		if(properties.contains("m"))
			addNewUser.setVisible(true);
		
		if(properties.get("type").equals("e"))
			shtBtn.setVisible(false);

	}
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openHome(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openSettings(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Settings.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void openAddNew(ActionEvent event) {
    	
    	addSchedLabel.setText("Add New Employee");
    	selectBox.setVisible(false);
    	newUserGrid.setVisible(true);
    	doneAdding.setVisible(true);
    	addNewUser.setVisible(false);
    	cancelAddBtn.setVisible(true);
    	
    }
    
    public void cancelAdd(ActionEvent event) {
    	
    	nameField.clear();
    	dobField.clear();
    	addressField.clear();
    	cityField.clear();
    	phoneField.clear();
    	emailField.clear();
    	wageField.clear();
    	usernameField.clear();
    	passwdField.clear();
    	addSchedLabel.setText("Set Schedules");
    	selectBox.setVisible(true);
    	datesGrid.setVisible(false);
    	addNewUser.setVisible(true);
    	doneSchedule.setVisible(false);
    	newUserGrid.setVisible(false);
    	doneAdding.setVisible(false);
    	cancelAddBtn.setVisible(false);
    	
    }
    
    public void makeSchedules(ActionEvent event) throws IOException {
    	
    	selectBox.setVisible(true);
    	datesGrid.setVisible(true);
    	addNewUser.setVisible(false);
    	doneSchedule.setVisible(true);
		
    }
    
    public void selectUser(ActionEvent event) throws IOException{
    	
		Properties usersProperties = EasySheetsModel.getProperties("login.properties");
		//Checking if user exists
		if(usersProperties.containsKey(employee.getText()))
		{
			selectBox.setVisible(true);
	    	datesGrid.setVisible(true);
	    	addNewUser.setVisible(false);
	    	doneSchedule.setVisible(true);
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
    
    public void doneSchedules() throws IOException{
    	
		
		//Checking if user exists
		String filename = employee.getText() + ".properties";
    	Properties userProp = EasySheetsModel.getProperties(filename);
    	
    	if(mondayField.getText() == null)
    		userProp.setProperty("monday", "Off");
    	else
    		userProp.setProperty("monday", mondayField.getText());
    	if(tuesdayField.getText() == null)
    		userProp.setProperty("tuesday", "Off");
    	else
    		userProp.setProperty("tuesday", tuesdayField.getText());
    	if(wednesdayField.getText() == null)
    		userProp.setProperty("wednesday", "Off");
    	else
    		userProp.setProperty("wednesday", wednesdayField.getText());
    	if(thursdayField.getText() == null)
    		userProp.setProperty("thursday", "Off");
    	else
    		userProp.setProperty("thursday", thursdayField.getText());
   		if(fridayField.getText() == null)
   			userProp.setProperty("friday", "Off");
   		else
   			userProp.setProperty("friday", fridayField.getText());
   		if(saturdayField.getText() == null)
    		userProp.setProperty("saturday", "Off");
    	else
   			userProp.setProperty("saturday", saturdayField.getText());
   		if(sundayField.getText() == null)
    		userProp.setProperty("sunday", "Off");
    	else
   			userProp.setProperty("sunday", sundayField.getText());
    	//Storing into file
    	File f = new File(userProp.getProperty("username") + ".properties");
    	FileWriter writer = new FileWriter(f, false);
    	userProp.store(writer, null);
    	writer.close();
    	mondayField.clear();
    	tuesdayField.clear();
    	wednesdayField.clear();
    	thursdayField.clear();
    	fridayField.clear();
    	saturdayField.clear();
    	sundayField.clear();
    	selectBox.setVisible(true);
       	datesGrid.setVisible(false);
       	addNewUser.setVisible(true);
       	doneSchedule.setVisible(false);
        	
       	//ALERT SHOWING THE schedule was changed
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("SCHEDULE SET");
		alert.setContentText("The schedule for " + userProp.getProperty("username") + " has been set.");
		alert.showAndWait();
    }
    
    public void addUser(ActionEvent event) throws IOException {
    	//reading all textfields
    	String name = nameField.getText();
    	String dob = dobField.getText();
    	String address = addressField.getText();
    	String city = cityField.getText();
    	String phone = phoneField.getText();
    	String email = emailField.getText();
    	String wage = wageField.getText();
    	String username = usernameField.getText();
    	String password = passwdField.getText();
    	String type = empTypeField.getText();
    	if((name.equals("") || dob.equals("") || address.equals(""))|| city.equals("") || phone.equals("") || email.equals("") || wage.equals("") || username.equals("") || password.equals("") || type.equals("")) {
    		//ALERT SHOWING THE USER USERNAME IS INCORRECT
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("ERROR: Please use all of the fields.");
			alert.showAndWait();
    	}
    	else {
	    	String filename = username + ".properties";
	    	
	    	//Adding username and password to login file
	    	Properties loginProp = new Properties();
	    	FileOutputStream logwriter = new FileOutputStream("login.properties", true);
	    	loginProp.put(username, password);
	    	loginProp.store(logwriter, null);
	    	
	    	//Creating and adding things to user property file
	    	File userFile = new File(filename);
	    	FileOutputStream writer = new FileOutputStream(userFile, true);
	    	Properties properties = new Properties();
	    	user.put("name", name);
	    	user.put("dob", dob);
	    	user.put("address", address);
	    	user.put("city", city);
	    	user.put("phone", phone);
	    	user.put("email", email);
	    	user.put("wage", wage);
	    	user.put("username", username);
	    	user.put("password", password);
	    	user.put("type", type);
	    	user.put("monday", "Off");
	    	user.put("tuesday", "Off");
	    	user.put("wednesday", "Off");
	    	user.put("thursday", "Off");
	    	user.put("friday", "Off");
	    	user.put("saturday", "Off");
	    	user.put("sunday", "Off");
	    	properties.putAll(user);
	    	properties.store(writer, null);
	    	nameField.clear();
	    	dobField.clear();
	    	addressField.clear();
	    	cityField.clear();
	    	phoneField.clear();
	    	emailField.clear();
	    	wageField.clear();
	    	usernameField.clear();
	    	passwdField.clear();
	    	addSchedLabel.setText("Set Schedules");
	    	selectBox.setVisible(true);
	    	datesGrid.setVisible(false);
	    	addNewUser.setVisible(true);
	    	doneSchedule.setVisible(false);
	    	newUserGrid.setVisible(false);
	    	doneAdding.setVisible(false);
    	}
    	
    }
}
