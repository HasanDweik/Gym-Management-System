package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class AddTrainerScreenController implements Initializable {

	@FXML private TextField nameTextField;
	@FXML private TextField addressTextField;
	@FXML private TextField genderTextField;
	@FXML private TextField mobileNumTextField;
	@FXML private DatePicker dateOfBirthPicker;
	@FXML private TextField emailTextField;
	@FXML private DatePicker joiningDatePicker;
	@FXML private TextField descriptionTextField;

	@FXML private Label nameErrorLabel;
	@FXML private Label addressErrorLabel;
	@FXML private Label genderErrorLabel;
	@FXML private Label mobileNumErrorLabel;
	@FXML private Label dateOfBirthErrorLabel;
	@FXML private Label emailErrorLabel;
	
	Database_Connection aConnection = new Database_Connection();
	
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
		String joiningDate="";
		String description="";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		

		
		if(		nameTextField.getText().isEmpty()||
				addressTextField.getText().isEmpty()||
				genderTextField.getText().isEmpty()||
				mobileNumTextField.getText().isEmpty()||
				dateOfBirthPicker.getValue()==null||
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


			
		}else{
			
			name = nameTextField.getText();
			address = addressTextField.getText();
			gender = genderTextField.getText();
			mobileNum = mobileNumTextField.getText();
			dateOfBirth = dateOfBirthPicker.getValue().format(dtf);
			email = emailTextField.getText();
			if(joiningDatePicker.getValue()!=null) {
			joiningDate = joiningDatePicker.getValue().format(dtf);
			}
			if(!descriptionTextField.getText().isEmpty()) {
			description = descriptionTextField.getText();
			}

			
			
			System.out.println("Adding " + name + " to the system");

			Trainer trainer = new Trainer(name,address,gender,mobileNum,dateOfBirth,email,joiningDate,description);

			aConnection.insert_Trainer(trainer);

			
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		
		
	}

}
