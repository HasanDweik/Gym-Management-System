package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("The Gladiator");
			
			Image icon = new Image(getClass().getResourceAsStream("/images/logo.png"));
			primaryStage.getIcons().add(icon);		
			
			//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
