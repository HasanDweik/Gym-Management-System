package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPackageScreenController implements Initializable{

	@FXML private TextField nameTextField;
	@FXML private TextField descriptionTextField;
	@FXML private TextField feeTextField;
	@FXML private TextField durationTextField;
	
	@FXML private Label nameErrorLabel;
	@FXML private Label feeErrorLabel;
	@FXML private Label durationErrorLabel;
	
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
		feeErrorLabel.setText("");
		durationErrorLabel.setText("");
		
		String name;
		String description;
		String fee;
		String duration;

		name = nameTextField.getText();
		description = descriptionTextField.getText();
		fee = feeTextField.getText();
		duration = durationTextField.getText();



		if(	nameTextField.getText().isEmpty()||feeTextField.getText().isEmpty()	||durationTextField.getText().isEmpty() ) {

			if(nameTextField.getText().isEmpty()) {
				nameErrorLabel.setText("EMPTY CREDENTIAL");
			}

			if(feeTextField.getText().isEmpty()) {
				feeErrorLabel.setText("EMPTY CREDENTIAL");
			}
			
			if(durationTextField.getText().isEmpty()) {
				durationErrorLabel.setText("EMPTY CREDENTIAL");
			}
		
		}else {
	
			System.out.println("Adding " + name + " to the system");

			Package package_ = new Package(name,description,Double.valueOf(fee),Integer.valueOf(duration));

			aConnection.insert_Package(package_);

			
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
		aConnection.connect();
	}
	

}
