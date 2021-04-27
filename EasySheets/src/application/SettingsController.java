package application;

import java.awt.TextField;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SettingsController {
	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView homBtn;
	@FXML
	private ImageView calBtn;
	@FXML
	private ImageView shtBtn;
	@FXML
	private Button proBtn;
	@FXML
	private ImageView setBtn;
	@FXML
	private Button logoutBtn;
	@FXML
	private GridPane template;
	@FXML
	private GridPane enterInfo;
	@FXML 
	private Button edit;
	@FXML
	private Button done;
	@FXML
	private TextField nameField;
	@FXML 
	private TextField DoBField;
	@FXML
	private TextField addField;
	@FXML
	private TextField locField;
	@FXML
	private TextField phoneField;
	@FXML 
	private TextField EField;
	
	
		HashMap<String, String> info = new HashMap<String, String>();

		public void initialize()
		{
			enterInfo.setVisible(false);
		}
	
        public void openCal(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Calendar.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
    	Node popupContent = datePickerSkin.getPopupContent();
    	pane.getChildren().add(popupContent);
    	window.setScene(scene);
    	window.show();
    }
    
      public void openSheets(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Sheets.fxml"));
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
    
      public void openProfile(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Profile.fxml"));
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
    	
    	template.setVisible(false);
    	enterInfo.setVisible(true);

    }
    
    public void doneInfo(ActionEvent event) throws IOException
    {
    	String inputName = nameField.getText();
    	String inputDob = DoBField.getText();
    	String inputAdd = addField.getText();
    	String inputloc = locField.getText();
    	String inputPhone = phoneField.getText();
    	String inputEmail = EField.getText();
    	
    	info.put("name", inputName);
    	info.put("date of birth", inputDob);
    	info.put("address", inputAdd);
    	info.put("city, state", inputloc);
    	info.put("phone", inputPhone);
    	info.put("Email", inputEmail);
    	
    }
}
