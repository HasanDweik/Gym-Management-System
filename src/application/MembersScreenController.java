package application;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MembersScreenController implements Initializable{

	Database_Connection aConnection = new Database_Connection();
	
	@FXML private TableView<Member>tableView;
	
	@FXML private TableColumn<Member,Integer>idColumn;
	@FXML private TableColumn<Member,String>nameColumn;
	@FXML private TableColumn<Member,String>addressColumn;
	@FXML private TableColumn<Member,String>genderColumn;
	@FXML private TableColumn<Member,String>mobileColumn;
	@FXML private TableColumn<Member,String>dateColumn;
	@FXML private TableColumn<Member,String>emailColumn;
	
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
	
	
	ObservableList<Member> oblst = FXCollections.observableArrayList();	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		aConnection.connect();
		
		aConnection.fillTable(oblst);
		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("member_id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("full_name"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address")); 
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
		mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile_number"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		tableView.setItems(oblst);
	}

}
