package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.net.URL;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.YearMonth;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import javafx.geometry.Pos;
//import java.util.ResourceBundle;
//import com.sun.javafx.scene.control.skin.DatePickerSkin;
//import com.sun.prism.paint.Color;
//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.scene.control.DatePicker;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import java.time.YearMonth;
//import javafx.scene.text.Font;

public class CalendarController{
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
	private ToggleButton homeTog;
	@FXML
	private Label time;
//	@FXML	Pane calendarPane;
//	@FXML
//	public Label clickedDate;
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
	@FXML
	private Label sundayAmount;
	@FXML
	private Label mondayAmount;
	@FXML
	private Label tuesdayAmount;
	@FXML
	private Label wednesdayAmount;
	@FXML
	private Label thursdayAmount;
	@FXML
	private Label fridayAmount;
	@FXML
	private Label saturdayAmount;
	@FXML
	private Button hella;

	
//	  private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(35);
//	    private VBox view;
//	    private Text calendarTitle;
//	    private YearMonth currentYearMonth;
	//HashMap<String, String> info = new HashMap<String,String>();
	
	
	public void initialize()
	{
//	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	 
//	    //get current date time with Calendar()
//	    Calendar cal = Calendar.getInstance();
//	    time.setText(dateFormat.format(cal.getTime()));
		
//	    Controller controller = loader.getController();
//	    calendarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
	}
	
	public void schedule() throws IOException
	{
		String userFileName = "C:\\Users\\hayde\\eclipse-workspace\\MyTermProject\\src\\sch123.properties";
        File file = new File(userFileName);
        FileInputStream reader = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(reader);
        reader.close();
        
        String working = properties.getProperty("monday");
        mondayWork.setText(working);
        mondayWork.setAlignment(Pos.CENTER);
        
	}
	
	
	
//	public void FullCalendarView(YearMonth yearMonth) {
//		currentYearMonth = yearMonth;
//		GridPane calendar = new GridPane();
//        calendar.setMinSize(1200, 720);
//        calendar.setGridLinesVisible(true);
//        // Create rows and columns with anchor panes for the calendar
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 7; j++) {
//                AnchorPaneNode ap = new AnchorPaneNode();
//                ap.setMinSize(800,400);
//                calendar.add(ap,j,i);
//                allCalendarDays.add(ap);
//            }
//        }
//        // Days of the week labels
//        Text[] dayNames = new Text[]{ new Text("Sunday"), new Text("Monday"), new Text("Tuesday"),
//                                        new Text("Wednesday"), new Text("Thursday"), new Text("Friday"),
//                                        new Text("Saturday") };
//        
//        GridPane dayLabels = new GridPane();
//        
//        dayLabels.setMinWidth(1200);
//        Integer col = 0;
//
//        for (Text txt : dayNames) {
//            AnchorPane ap = new AnchorPane();
//            ap.setPrefSize(200, 10);
//            AnchorPane.setBottomAnchor(txt, 5.0);
//            ap.getChildren().add(txt);
//            dayLabels.add(ap, col++, 0);
//        }
//        // Create calendarTitle and buttons to change current month
//        calendarTitle = new Text();
//        Button previousMonth = new Button("<<");
//        previousMonth.setOnAction(e -> previousMonth());
//        Button nextMonth = new Button(">>");
//        nextMonth.setOnAction(e -> nextMonth());
//        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
//        titleBar.setAlignment(Pos.BASELINE_CENTER);
//        // Populate calendar with the appropriate day numbers
//        populateCalendar(yearMonth);
//        // Create the calendar view
//        view = new VBox(titleBar, dayLabels, calendar);
//    }
//	
//	public void populateCalendar(YearMonth yearMonth) 
//	{
//        // Get the date we want to start with on the calendar
//        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
//        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
//        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
//            calendarDate = calendarDate.minusDays(1);
//        }
//        // Populate the calendar with day numbers
//        for (AnchorPaneNode ap : allCalendarDays) 
//        {
//            if (ap.getChildren().size() != 0) 
//            {
//                ap.getChildren().remove(0);
//            }
//            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
//            ap.setDate(calendarDate);
//            AnchorPane.setTopAnchor(txt, 5.0);
//            AnchorPane.setLeftAnchor(txt, 5.0);
//            ap.getChildren().add(txt);
//            calendarDate = calendarDate.plusDays(1);
//        }
//        // Change the title of the calendar
//        calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
//    }
//	
//	private void previousMonth() 
//	{
//        currentYearMonth = currentYearMonth.minusMonths(1);
//        populateCalendar(currentYearMonth);
//    }
//
//
//    private void nextMonth() 
//    {
//        currentYearMonth = currentYearMonth.plusMonths(1);
//        populateCalendar(currentYearMonth);
//    }
//
//    public VBox getView() 
//    {
//        return view;
//    }
//
//    public ArrayList<AnchorPaneNode> getAllCalendarDays() 
//    {
//        return allCalendarDays;
//    }
//
//    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays) 
//    {
//        this.allCalendarDays = allCalendarDays;
//    }
    
	
    //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openHome(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(pane,1200,720);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
  //THIS IS CALLED WHEN THE USER CLICKS NEED IN THE MAIN PAGE
    public void openSheets(MouseEvent event) throws IOException {
    	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("Sheets.fxml"));
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
