package application;


import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class LoginScreenController implements Initializable {

	@FXML private TextField usernameTextField;
	@FXML private PasswordField passwordTextField;
	@FXML private Label errorLoginLabel;
	public String loginName;
	@FXML private ImageView imageView;

	public void changeScreenButtonPushed(ActionEvent event) throws NoSuchAlgorithmException {
		
		Database_Connection aConnection = new Database_Connection();
		String name="";
		
		String username=usernameTextField.getText();
		String password=passwordTextField.getText();
		
		String hashed="";
		

		hashed=Hash.hash_password(password);

		name = aConnection.check_User(username,hashed);
		
		if(name=="") {
			
			System.out.println("Login not successfull");
			errorLoginLabel.setText("Wrong username or password");
			
		}else {
			System.out.println("Logged in as " + name);
			loginName = name;
			
		try {
			Parent loginParent = FXMLLoader.load(getClass().getResource("Sample.fxml"));
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
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Database_Connection aConnection = new Database_Connection();
		System.out.println("Connecting to Gym_Management_System_db");
		aConnection.connect();
		System.out.println("Connected to Gym_Management_System_db");

		
		
		
	}
	
	
}
