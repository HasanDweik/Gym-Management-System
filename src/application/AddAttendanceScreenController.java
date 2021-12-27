package application;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ResourceBundle;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.stage.Stage;



public class AddAttendanceScreenController implements Initializable{
	


	@FXML private ComboBox<Member> membershipComboBox;
	
	@FXML private Label memberErrorLabel;
	
	Database_Connection aConnection = new Database_Connection();
	
	@FXML private Button webcamPanel;

	
	public void goBack(ActionEvent event){

		try {
			Parent mainParent = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene mainScene = new Scene(mainParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(mainScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addButtonPushed(ActionEvent event){

		memberErrorLabel.setText("");
		
		
		Member member = membershipComboBox.getValue();
		
		if(membershipComboBox.getValue()==null) {
			
			
			memberErrorLabel.setText("Select a member");
			
			
			
		}else {
		
			
			int registration_id = aConnection.get_Registration_Id(member.getMember_id());
			int membership_id = aConnection.get_Membership_Id(registration_id);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now(); 
			String attendance_date=dtf.format(now);
			
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
			LocalDateTime now2 = LocalDateTime.now(); 
			String in_time = dtf2.format(now2);
			
			Attendance attendance = new Attendance(attendance_date, in_time, membership_id);
			
			aConnection.insert_Attendance(attendance);
			
			try {

				Parent mainParent = FXMLLoader.load(getClass().getResource("Sample.fxml"));
				Scene mainScene = new Scene(mainParent);

				//This line gets the Stage information
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

				window.setScene(mainScene);
				window.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		aConnection.connect();
		
		aConnection.fillComboMembership(membershipComboBox);
		
	}
	


}
