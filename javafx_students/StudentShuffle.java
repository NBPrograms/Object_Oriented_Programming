/**
 * Dec 4, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package javafx_students;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StudentShuffle extends Application {
	
	//Variables
	private BorderPane rootLayout;
	private AnchorPane displayControlsData;
	private Stage primaryStage;
	
	//Start method
	@Override
	public void start(Stage primaryStage) {
		//Making the Stage
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Store, Retrieve, and Update Student Data");
		initialRoot();
	}

	private void initialRoot() {
		//Loading the BorderPane fxml file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(StudentShuffle.class.getResource("MainLandingPage.fxml"));
		
		try {
			rootLayout = (BorderPane)loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Setting the scene
		Scene first_Scene = new Scene(rootLayout);
		primaryStage.setScene(first_Scene);
		primaryStage.show();
	}
	
	public void initialRoot2() {
		//Loading the AnchorPanePane fxml file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(StudentShuffle.class.getResource("ShowControlsData.fxml"));
		
		try {
			displayControlsData = (AnchorPane)loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Setting the scene
		Scene second_Scene = new Scene(displayControlsData);
		primaryStage.setScene(second_Scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
