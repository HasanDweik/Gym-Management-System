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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddMembershipScreenController implements Initializable{

	@FXML public ComboBox<Member> memberComboBox;
	@FXML public ComboBox<Trainer> trainerComboBox;
	@FXML public ComboBox<Package> packageComboBox;

	@FXML private Label memberErrorLabel;
	@FXML private Label trainerErrorLabel;
	@FXML private Label packageErrorLabel;
	
	
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

		memberErrorLabel.setText("");
		trainerErrorLabel.setText("");
		packageErrorLabel.setText("");
		
		Member member = memberComboBox.getValue();
		Trainer trainer = trainerComboBox.getValue();
		Package package_ = packageComboBox.getValue();

		if(memberComboBox.getValue()==null||trainerComboBox.getValue()==null||packageComboBox.getValue()==null) {
			
			
			
			if(memberComboBox.getValue()==null) {
				memberErrorLabel.setText("Choose a member");
				System.out.println("No chosen member");
			}

			if(trainerComboBox.getValue()==null) {
				trainerErrorLabel.setText("Choose a trainer");
				System.out.println("No chosen trainer");
			}
			
			if(packageComboBox.getValue()==null) {
				packageErrorLabel.setText("Choose a package");
				System.out.println("No chosen package");
			}

		}else {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now(); 
			
			int package_id = package_.getPackage_id();
			int duration = aConnection.get_Package_Duration(package_id);
			
			String valid_from = dtf.format(now);
			String valid_till = dtf.format(now.plusDays(duration));
			
			
			int registration_id = aConnection.get_Registration_Id(member.getMember_id());
			
				
			Membership membership = new Membership(dtf.format(now), registration_id, package_.getPackage_id(), trainer.getTrainer_id(),valid_from,valid_till);

			aConnection.insert_Membership(membership);
			
			//qr code
			
			String key = "Alpha"+aConnection.get_Membership_Id(registration_id);			
			QR_Write_Read qr = new QR_Write_Read();			
			qr.writeQRCode(key);
			
			try {
				JavaMailUtil.sendMail(aConnection.get_mail(registration_id),"QR_Codes\\"+key+".png",valid_from,valid_till);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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


		aConnection.fillComboMember(memberComboBox);
		aConnection.fillComboTrainer(trainerComboBox);
		aConnection.fillComboPackage(packageComboBox);

	}

}
