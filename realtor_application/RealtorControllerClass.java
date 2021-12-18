/**
 * Nov 30, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package realtor_application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RealtorControllerClass implements Initializable {
	
	//TextField, TextArea, DatePicker, Button, ComboBox, and MenuItem variables
    @FXML
    private TextField txtPropertyCode;

    @FXML
    private TextField txtBathrooms;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPath;

    @FXML
    private TextField txtStories;

    @FXML
    private TextField txtBedrooms;

    @FXML
    private TextField txtYearBuilt;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtCity;

    @FXML
    private ComboBox<String> cboStatus;

    @FXML
    private ComboBox<String> cboStyle;

    @FXML
    private ComboBox<String> cboPropertyType;

    @FXML
    private Button btnButtonOk;

    @FXML
    private Button btnCancel;

    @FXML
    private DatePicker dtDateListed;

    @FXML
    private ComboBox<String> cboState;

    @FXML
    private MenuItem menuClose;
    
    @FXML
    private MenuItem menuDelete;

    @FXML
    private TextField txtCondition;

    @FXML
    private TextField txtMarketValue;
    
    @FXML
    private TextArea txtDescription;
    
    //Observable lists for combo boxes
    @FXML
    private ObservableList<String> cboStatList = FXCollections.observableArrayList("Newly Constructed", "Previously Owned");
    
    @FXML
    private ObservableList<String> cboTypeList = FXCollections.observableArrayList("Condo", "Town Home", "Single Family");
    
    @FXML
    private ObservableList<String> cboStyleList = FXCollections.observableArrayList("Victorian", "Cookie Cutter", "Farmhouse");
    
    @FXML
    private ObservableList<String> cboStateList = FXCollections.observableArrayList("IL", "MN", "OK", "WI", "TN", "WY");

    //initialization Method
    @FXML
    private void initial() {
    	menuDelete();
    	menuClose();
    	btnCancel();
    	btnButtonOk();
    }
    
    //Second initialization method to populate combo boxes
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	cboStatus.setItems(cboStatList);
		cboPropertyType.setItems(cboTypeList);
		cboStyle.setItems(cboStyleList);
		cboState.setItems(cboStateList);
	}
    
    //Edit->Delete clears values
    @FXML
	private void menuDelete() {
		menuDelete.setOnAction((event) ->{
			if (event.getSource() == menuDelete) {
				dtDateListed.setValue(null);
				cboStatus.setValue(null);
				cboPropertyType.setValue(null);
				cboStyle.setValue(null);
				cboState.setValue(null);
				txtPropertyCode.clear();
				txtYearBuilt.clear();
				txtAddress.clear();
				txtCity.clear();
				txtLocation.clear();
				txtCondition.clear();
				txtStories.clear();
				txtBedrooms.clear(); 
				txtBathrooms.clear(); 
				txtMarketValue.clear();
				txtDescription.clear();
			}
		});
	}
	
	//File->Close closes application
	@FXML
	private void menuClose() {
		menuClose.setOnAction((event) ->{
			if (event.getSource() == menuClose) {
				System.exit(0);
			}
		});
	}
	
	//btnCancel Clears Values
	@FXML
	private void btnCancel() {
		btnCancel.setOnAction((event) -> {
			if (event.getSource() == btnCancel) {
				dtDateListed.setValue(null);
				cboStatus.setValue(null);
				cboPropertyType.setValue(null);
				cboStyle.setValue(null);
				cboState.setValue(null);
				txtPropertyCode.clear();
				txtYearBuilt.clear();
				txtAddress.clear();
				txtCity.clear();
				txtLocation.clear();
				txtCondition.clear();
				txtStories.clear();
				txtBedrooms.clear(); 
				txtBathrooms.clear(); 
				txtMarketValue.clear();
				txtDescription.clear();
			}
		});
	}

	//BtnOK displays data in description TextArea and writes to BoesData.txt
    @FXML
	private void btnButtonOk() {
		btnButtonOk.setOnAction((event) -> {
			//Only displays if txtDescription is empty
			if (txtDescription.getText().isEmpty()) {
				if (!txtPropertyCode.getText().isEmpty()) {
					txtDescription.setText("\nProperty Code: " + txtPropertyCode.getText());
				}
				if (cboStatus.getValue() != null) {
					txtDescription.setText(txtDescription.getText() + "\nStatus: " + cboStatus.getValue());
				}
				if (dtDateListed.getValue() != null) {
					txtDescription.setText(txtDescription.getText() + "\nDate Listed: " + dtDateListed.getValue());
				}
				if (!txtYearBuilt.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nYear Built: " + txtYearBuilt.getText());
				}
				if (cboPropertyType.getValue() != null) {
					txtDescription.setText(txtDescription.getText() + "\nProperty Type: " + cboPropertyType.getValue());
				}
				if (cboStyle.getValue() != null) {
					txtDescription.setText(txtDescription.getText() + "\nStyle: " + cboStyle.getValue());
				}
				if (!txtAddress.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nAddress: " + txtAddress.getText());
				}
				if (!txtCity.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nCity: " + txtCity.getText());
				}
				if (!txtLocation.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nLocation: " + txtLocation.getText());
				}
				if (cboState.getValue() != null) {
					txtDescription.setText(txtDescription.getText() + "\nState: " + cboState.getValue());
				}
				if (!txtCondition.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nCondition: " + txtCondition.getText());
				}
				if (!txtStories.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nStories: " + txtStories.getText());
				}
				if (!txtBedrooms.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nBedrooms: " + txtBedrooms.getText());
				}
				if (!txtBathrooms.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nBathrooms: " + txtBathrooms.getText());
				}
				if (!txtMarketValue.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nMarket Value: " + txtMarketValue.getText());
				}
				if (!txtPath.getText().isEmpty()) {
					txtDescription.setText(txtDescription.getText() + "\nPicture Path: " + txtPath.getText());
				}
			}
			
			//Use BufferWriter to write to file
			try(BufferedWriter realWriter = new BufferedWriter(new FileWriter("RealtorData.txt", true))) {
				//Only writes if description has values
				if (!txtDescription.getText().isEmpty()) {
					realWriter.write("\n============New Realtor Data===========");
					realWriter.write(txtDescription.getText());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		});
	}
}
