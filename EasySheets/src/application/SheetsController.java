package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SheetsController {
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
	
	
    //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openCal(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Calendar.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
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
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openProfile(ActionEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Profile.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
}
