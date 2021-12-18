/**
 * Dec 6, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package javafx_students;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainControllerClass {
	
	//MenuItem variables
    @FXML
    private MenuItem menuClose;

    @FXML
    private MenuItem menuStudent;
    
    //initialization method
    @FXML
    private void initialize() {
    	menuClose();
    	menuStudent();
    }
    
    //File->Close closes application
    @FXML
	private void menuClose() {
		menuClose.setOnAction((event) -> {
			if (event.getSource() == menuClose) {
				System.exit(0);
			}
		});
	}
    
    //Edit->Student Data opens the Show Controls Data window
    @FXML
	private void menuStudent() {
    	menuStudent.setOnAction((event) -> {
    		if (event.getSource() == menuStudent) {
    			StudentShuffle newRoot = new StudentShuffle();
    			Stage newStage = new Stage();
				newRoot.start(newStage);
				newRoot.initialRoot2();
			}
    	});
	}

}
