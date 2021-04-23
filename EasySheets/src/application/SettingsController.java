package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SettingsController {
	@FXML
	private AnchorPane pane;
	@FXML
	private Button homBtn;
	@FXML
	private Button calBtn;
	@FXML
	private Button shtBtn;
	@FXML
	private Button proBtn;
	@FXML
	private Button setBtn;
	
	
    //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openCal(ActionEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Calendar.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openSheets(ActionEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Sheets.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openHome(ActionEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openProfile(ActionEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Profile.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
}
