/**
 * Nov 30, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package realtor_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RealtorMain extends Application {
	//Stage and Anchorpane initializations
	private Stage primaryStage;
	private AnchorPane root;

	//Start method
	@Override
	public void start(Stage primaryStage) {
		//Making the Stage
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Realtor Editor Application Controls");
		initalizeRoot();
	}

	private void initalizeRoot() {
		//Loading the fxml file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(RealtorMain.class.getResource("RealtorScenebuilder.fxml"));
		
		try {
			root = (AnchorPane)loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Setting the scene
		Scene scene01 = new Scene(root);
		primaryStage.setScene(scene01);
		primaryStage.show();		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
