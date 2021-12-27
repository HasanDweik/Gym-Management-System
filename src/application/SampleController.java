package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleController implements Initializable{

	public void signOutScreenButtonPushed(ActionEvent event){

		try {
			Parent loginParent = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
			Scene loginScene = new Scene(loginParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(loginScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMemberButtonPushed(ActionEvent event){

		try {
			Parent addMemberParent = FXMLLoader.load(getClass().getResource("AddMemberScreen.fxml"));
			Scene addMemberScene = new Scene(addMemberParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(addMemberScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTrainerButtonPushed(ActionEvent event){

		try {
			Parent addTrainerParent = FXMLLoader.load(getClass().getResource("AddTrainerScreen.fxml"));
			Scene addTrainerScene = new Scene(addTrainerParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(addTrainerScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addPackageButtonPushed(ActionEvent event){

		try {
			Parent addPackageParent = FXMLLoader.load(getClass().getResource("AddPackageScreen.fxml"));
			Scene addPackageScene = new Scene(addPackageParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(addPackageScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMembershipButtonPushed(ActionEvent event){

		try {
			Parent addMembershipParent = FXMLLoader.load(getClass().getResource("AddMembershipScreen.fxml"));
			Scene addMembershipScene = new Scene(addMembershipParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(addMembershipScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAttendanceButtonPushed(ActionEvent event){

		try {
			Parent addAttendanceParent = FXMLLoader.load(getClass().getResource("AddAttendanceScreen.fxml"));
			Scene addAttendanceScene = new Scene(addAttendanceParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(addAttendanceScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attendanceQRButton(ActionEvent event){


	}
	
	public void membersButtonPushed(ActionEvent event){

		try {
			Parent membersParent = FXMLLoader.load(getClass().getResource("membersScreen.fxml"));
			Scene membersScene = new Scene(membersParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(membersScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attendanceQRButtonPushed(ActionEvent event) {
		
		try {
			Parent imageParent = FXMLLoader.load(getClass().getResource("ClientImage.fxml"));
			Scene imageScene = new Scene(imageParent);

			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

			window.setScene(imageScene);
			window.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new ReadQR();
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
