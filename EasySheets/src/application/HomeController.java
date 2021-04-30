package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController extends LoginController{
	
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
	private Label welcomeLbl;
	@FXML
	private Label dayLbl;
	@FXML
	private Label sundayWork;
	@FXML
	private Label mondayWork;
	@FXML
	private Label tuesdayWork;
	@FXML
	private Label wednesdayWork;
	@FXML
	private Label thursdayWork;
	@FXML
	private Label fridayWork;
	@FXML
	private Label saturdayWork;
	
    public void initialize() throws IOException{
    	String userFileName = inputUsername + ".properties";
    	File file = new File(userFileName);
		FileInputStream reader = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(reader);
		reader.close();
		for(String key: properties.stringPropertyNames()) {
			login.put(key, properties.get(key).toString());
		}
		String name = properties.getProperty("name");
		int i = name.indexOf(' ');
		String firstName = name;
		if(i != -1)
			firstName = name.substring(0, i);
		welcomeLbl.setText("Welcome, " + firstName + ".");
		
	    mondayWork.setText(properties.getProperty("monday"));
	    tuesdayWork.setText(properties.getProperty("tuesday"));
	    wednesdayWork.setText(properties.getProperty("wednesday"));
	    thursdayWork.setText(properties.getProperty("thursday"));
	    fridayWork.setText(properties.getProperty("friday"));
	    saturdayWork.setText(properties.getProperty("saturday"));
	    sundayWork.setText(properties.getProperty("sunday"));
	    
	    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 
		//get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		dayLbl.setText(dateFormat.format(cal.getTime()));
		
		if(login.get("type").equals("e"))
			shtBtn.setVisible(false);

    }
	
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openManagerPage(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));
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
    
	
}
