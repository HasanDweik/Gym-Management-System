package application;


import java.io.IOException;


import com.github.sarxos.webcam.util.Initializable;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageController implements Initializable{

	private ImageView imageView;
	
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
	public void checkButtonIsClicked(ActionEvent event) {
		
			
		int membership_id = LastAccessed.getMembership_id();

		int registration_id = aConnection.get_Registration_Id2(membership_id);

		int member_id = aConnection.get_Member_Id(registration_id);

		Image image = aConnection.get_image(member_id);

		imageView.setImage(image);


	}

	
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		aConnection.connect();

		
	}

	@Override
	public void teardown() {
		// TODO Auto-generated method stub
		
	}

	
	
}
