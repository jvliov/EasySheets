package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SettingsController extends LoginController{
	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView homBtn;
	@FXML
	private ImageView calBtn;
	@FXML
	private ImageView shtBtn;
	@FXML
	private ImageView setBtn;
	@FXML
	private Button logoutBtn;
	@FXML
	private Button editBtn;
	@FXML
	private Button doneEditBtn;
	@FXML
	private Label name;
	@FXML
	private Label dob;
	@FXML
	private Label address;
	@FXML
	private Label city;
	@FXML
	private Label phone;
	@FXML
	private Label email;
	@FXML
	private GridPane enterInfo;
	@FXML
	private GridPane template;
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

	public void initialize() throws IOException{
		template.setVisible(true);
		enterInfo.setVisible(false);
    	String userFileName = inputUsername + ".properties";
    	File file = new File(userFileName);
		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(reader);
		reader.close();
		name.setText(properties.getProperty("name"));
		dob.setText(properties.getProperty("dob"));
		address.setText(properties.getProperty("address"));
		city.setText(properties.getProperty("city"));
		phone.setText(properties.getProperty("phone"));
		email.setText(properties.getProperty("email"));
		
		if(login.get("type").equals("e"))
			shtBtn.setVisible(false);

    }
	
    
    public void openManagerPage(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void openHome(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void logout(ActionEvent event) throws IOException {
    	
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    public void editInfo(ActionEvent event) throws IOException
    {
    	editBtn.setVisible(false);
    	doneEditBtn.setVisible(true);
    	template.setVisible(false);
    	enterInfo.setVisible(true);
    	String userFileName = inputUsername + ".properties";
    	File file = new File(userFileName);
		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(reader);
		reader.close();
		nameField.setText(properties.getProperty("name"));
		dobField.setText(properties.getProperty("dob"));
		addressField.setText(properties.getProperty("address"));
		cityField.setText(properties.getProperty("city"));
		phoneField.setText(properties.getProperty("phone"));
		emailField.setText(properties.getProperty("email"));
    }
    
    public void doneEditing(ActionEvent event) throws IOException
    {
    	String userFileName = inputUsername + ".properties";
    	File file = new File(userFileName);
		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(reader);
		reader.close();

		//Puting info to propertiess
		properties.setProperty("name", nameField.getText());
		properties.setProperty("dob", dobField.getText());
		properties.setProperty("address", addressField.getText());
		properties.setProperty("city", cityField.getText());
		properties.setProperty("phone", phoneField.getText());
		properties.setProperty("email", emailField.getText());
		//Storing info to file
		File f = new File(properties.getProperty("username") + ".properties");
		FileWriter writer = new FileWriter(f, false);
		properties.store(writer, null);
		writer.close();
		//Puting info to template
		name.setText(properties.getProperty("name"));
		dob.setText(properties.getProperty("dob"));
		address.setText(properties.getProperty("address"));
		city.setText(properties.getProperty("city"));
		phone.setText(properties.getProperty("phone"));
		email.setText(properties.getProperty("email"));
		editBtn.setVisible(true);
    	doneEditBtn.setVisible(false);
    	template.setVisible(true);
    	enterInfo.setVisible(false);
    	nameField.clear();
    	dobField.clear();
    	addressField.clear();
    	cityField.clear();
    	phoneField.clear();
    	emailField.clear();
    }
}
