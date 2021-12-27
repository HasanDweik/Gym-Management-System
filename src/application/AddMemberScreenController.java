package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class AddMemberScreenController implements Initializable {

	@FXML private TextField nameTextField;
	@FXML private TextField addressTextField;
	@FXML private TextField genderTextField;
	@FXML private TextField mobileNumTextField;
	@FXML private DatePicker dateOfBirthPicker;
	@FXML private TextField emailTextField;
	@FXML private TextField imageTextField;

	@FXML private Label nameErrorLabel;
	@FXML private Label addressErrorLabel;
	@FXML private Label genderErrorLabel;
	@FXML private Label mobileNumErrorLabel;
	@FXML private Label dateOfBirthErrorLabel;
	@FXML private Label emailErrorLabel;
	
	@FXML AnchorPane anchorPane;
	
	Database_Connection aConnection = new Database_Connection();
	
	File file=null;
	
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

		nameErrorLabel.setText("");
		addressErrorLabel.setText("");
		genderErrorLabel.setText("");
		mobileNumErrorLabel.setText("");
		dateOfBirthErrorLabel.setText("");
		emailErrorLabel.setText("");
		
		String name;
		String address;
		String gender;
		String mobileNum;
		String dateOfBirth;
		String email;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		


		
		if(		nameTextField.getText().isEmpty()||
				addressTextField.getText().isEmpty()||
				genderTextField.getText().isEmpty()||
				mobileNumTextField.getText().isEmpty()||
				dateOfBirthPicker.getValue().toString().isEmpty()||
				emailTextField.getText().isEmpty()			 ) {

			if(nameTextField.getText().isEmpty()) {
				nameErrorLabel.setText("EMPTY CREDENTIAL");
			}

			if(addressTextField.getText().isEmpty()) {
				addressErrorLabel.setText("EMPTY CREDENTIAL");
			}
			
			if(genderTextField.getText().isEmpty()) {
				genderErrorLabel.setText("EMPTY CREDENTIAL");
			}
			
			if(mobileNumTextField.getText().isEmpty()) {
				mobileNumErrorLabel.setText("EMPTY CREDENTIAL");
			}
			
			if(dateOfBirthPicker.getValue()==null) {
				dateOfBirthErrorLabel.setText("EMPTY CREDENTIAL");
			}
			
			if(emailTextField.getText().isEmpty()) {
				emailErrorLabel.setText("EMPTY CREDENTIAL");
			}


			
		}else {
			
			name = nameTextField.getText();
			address = addressTextField.getText();
			gender = genderTextField.getText();
			mobileNum = mobileNumTextField.getText();
			dateOfBirth = dateOfBirthPicker.getValue().format(dtf);
			email = emailTextField.getText();

			FileInputStream fis=null;
			if(file!=null) {
			try {
				fis = new FileInputStream(file);
	
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}
			

			
			
			System.out.println("Adding " + name + " to the system");

			Member member = new Member(name,address,gender,mobileNum,dateOfBirth,email);

			if(file!=null) {
			aConnection.insert_Member(member,fis,(int)file.length());
			}
			else {
			aConnection.insert_Member_No_Img(member);
			}
			
			int member_id = aConnection.get_Member_Id2(member.getMobile_number());
			
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			
			Registration registration = new Registration(dtf2.format(now),member_id);
			
			aConnection.insert_Registration(registration);
			

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
			System.out.println( name + " is added");
		}
	}

	public void handleBrowseButtonAction(ActionEvent event) {
		
		final FileChooser fileChooser = new FileChooser();
		
		fileChooser.getExtensionFilters().addAll(
		new ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"));

		
		Stage stage = (Stage)anchorPane.getScene().getWindow(); 
		
		file= fileChooser.showOpenDialog(stage);
		
		if(file!=null) {
			System.out.println("Path : " +file.getAbsolutePath());
			
			imageTextField.setText(file.getAbsolutePath());
		}
		
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		aConnection.connect();
		
	}

}
