/**
 * Dec 4, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package javafx_students;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentControllerClass {
	
	//TextField and Button variables
    @FXML
    private TextField txtID;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtZip;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtState;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnLast;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnFirst;

    @FXML
    private Button btnUpdate;
    
    //Extra variables used throughout the program
    @FXML
    //Change file path as necessary
    private final String FILE = "C:\\Users\\tjboe\\eclipse-workspace\\BoesFinal\\StudentData.dat";
    
    @FXML
    private Scanner studreader, studScan;
    
    @FXML
    private String student, recordNum;
    
    //initialization method
    @FXML
    private void initial() {
    	btnAdd();
    	btnFirst();
    	btnNext();
    	btnPrevious();
    	btnLast();
    	btnUpdate();
    }
    
    //btnAdd adds data to file
    @FXML
	private void btnAdd() {
		btnAdd.setOnAction((event)->{
			//Variables
			int record = 1;
			boolean can_write = true;
			
			//Scans the file for records
			try {
				studreader = new Scanner(new File(FILE));
		
				while (studreader.hasNext()) {
					student = studreader.nextLine();
					
					studScan = new Scanner(student);
					studScan.useDelimiter(",");
					studScan.next();
					
					//Set can_write to false if TextFields are empty and an Id matches one in the StudentData.dat file 
					if (txtID.getText().equals(studScan.next().trim()) 
							|| txtID.getText().isEmpty()
							|| txtFirstName.getText().isEmpty()
							|| txtLastName.getText().isEmpty()
							|| txtStreet.getText().isEmpty()
							|| txtCity.getText().isEmpty()
							|| txtState.getText().isEmpty()
							|| txtZip.getText().isEmpty()) 
						can_write = false;
				
					record++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
			//Use BufferWriter to write fixed-length strings to file (only if can_write is true)
			if (can_write) {
				try(BufferedWriter studWriter = new BufferedWriter(new FileWriter("StudentData.dat", true))) {
					studWriter.write(String.format("%1d", record) + ","
							+ String.format("%10s", txtID.getText()) + "," 
							+ String.format("%10s", txtFirstName.getText()) + ","
							+ String.format("%50s", txtLastName.getText()) + "," 
							+ String.format("%50s", txtStreet.getText()) + "," 
							+ String.format("%20s",txtCity.getText()) + ","
							+ String.format("%2s",txtState.getText()) + "," 
							+ String.format("%9s",txtZip.getText()) + "\n");
					
					//Clears the TextFields after adding
					txtID.clear();
					txtFirstName.clear();
					txtLastName.clear();
					txtStreet.clear();
					txtCity.clear();
					txtState.clear();
					txtZip.clear();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    //btnFirst locates and displays the first record
    @FXML
	private void btnFirst() {
    	btnFirst.setOnAction((event)->{
    		//Scans the file for records
			try {
				studreader = new Scanner(new File(FILE));
				
				while (studreader.hasNext()) {
					student = studreader.nextLine();
					
					studScan = new Scanner(student);
					studScan.useDelimiter(",");
					
					//Finds first record and displays it in the textFields
					if (studScan.next().equals("1")) {
						txtID.setText(studScan.next().trim());
						txtFirstName.setText(studScan.next().trim());
						txtLastName.setText(studScan.next().trim());
						txtStreet.setText(studScan.next().trim());
						txtCity.setText(studScan.next().trim());
						txtState.setText(studScan.next().trim());
						txtZip.setText(studScan.next().trim());
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	});
	}
    
    //btnNext locates and displays the next record
    @FXML
	private void btnNext() {
    	btnNext.setOnAction((event)->{
    		//Local Variables
			int record;
			boolean isRecord = false;
			
			//Locate next record
			try {
				studreader = new Scanner(new File(FILE));
				
				while (studreader.hasNext()) {
					student = studreader.nextLine();
					
					studScan = new Scanner(student);
					studScan.useDelimiter(",");
					recordNum = studScan.next();
					
					//Checks for ID number
					if (txtID.getText().equals(studScan.next().trim())) {
						record = Integer.parseInt(recordNum) + 1;
						
						//Set next record
						try {
							studreader = new Scanner(new File(FILE));
							
							while (studreader.hasNext()) {
								student = studreader.nextLine();
								
								studScan = new Scanner(student);
								studScan.useDelimiter(",");
								
								//Finds next record and displays it in the textFields
								if (Integer.toString(record).equals(studScan.next())) {
									txtID.setText(studScan.next().trim());
									txtFirstName.setText(studScan.next().trim());
									txtLastName.setText(studScan.next().trim());
									txtStreet.setText(studScan.next().trim());
									txtCity.setText(studScan.next().trim());
									txtState.setText(studScan.next().trim());
									txtZip.setText(studScan.next().trim());
									
									isRecord = true;
								}
								
								//Clears the TextFields when last record is on the screen
								if (!studreader.hasNext() && !isRecord) {
									txtID.clear();
									txtFirstName.clear();
									txtLastName.clear();
									txtStreet.clear();
									txtCity.clear();
									txtState.clear();
									txtZip.clear();
								}
							}
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	});
	}
    
    //btnPrevious locates and displays the previous record
    @FXML
	private void btnPrevious() {
    	btnPrevious.setOnAction((event)->{
	    	//Local Variables
			int record;
			
			//Locate next record
			try {
				studreader = new Scanner(new File(FILE));
				
				while (studreader.hasNext()) {
					student = studreader.nextLine();
					
					studScan = new Scanner(student);
					studScan.useDelimiter(",");
					recordNum = studScan.next();
					
					//Checks for ID number
					if (txtID.getText().equals(studScan.next().trim())) {
						record = Integer.parseInt(recordNum) - 1;
						
						//Set next record
						try {
							studreader = new Scanner(new File(FILE));
							
							while (studreader.hasNext()) {
								student = studreader.nextLine();
								
								studScan = new Scanner(student);
								studScan.useDelimiter(",");
								
								//Finds next record and displays it in the textFields
								if (Integer.toString(record).equals(studScan.next())) {
									txtID.setText(studScan.next().trim());
									txtFirstName.setText(studScan.next().trim());
									txtLastName.setText(studScan.next().trim());
									txtStreet.setText(studScan.next().trim());
									txtCity.setText(studScan.next().trim());
									txtState.setText(studScan.next().trim());
									txtZip.setText(studScan.next().trim());
								}
								
								//Clears the TextFields when first record is on the screen
								if (!studreader.hasNext() && record == 0) {
									txtID.clear();
									txtFirstName.clear();
									txtLastName.clear();
									txtStreet.clear();
									txtCity.clear();
									txtState.clear();
									txtZip.clear();
								}
							}
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	});
	}
    
    //btnLast locates and displays the last record 
    @FXML
	private void btnLast() {
    	btnLast.setOnAction((event)->{
    		//Scans the file for records
			try {
				studreader = new Scanner(new File(FILE));
				
				while (studreader.hasNext()) {
					student = studreader.nextLine();
					
					studScan = new Scanner(student);
					studScan.useDelimiter(",");
					studScan.next();
					
					//Finds last record and displays it in the textFields
					if (!studreader.hasNext()) {
						txtID.setText(studScan.next().trim());
						txtFirstName.setText(studScan.next().trim());
						txtLastName.setText(studScan.next().trim());
						txtStreet.setText(studScan.next().trim());
						txtCity.setText(studScan.next().trim());
						txtState.setText(studScan.next().trim());
						txtZip.setText(studScan.next().trim());
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	});
		
	}
    
    //btnUpdate updates the file
    @FXML
	private void btnUpdate() {
    	btnUpdate.setOnAction((event)->{
    		//Local Variables
			String recordNum; 
			int record = 1;
			
			//Locates updated record
			try {
				studreader = new Scanner(new File(FILE));
				
				while (studreader.hasNext()) {
					student = studreader.nextLine();
					
					studScan = new Scanner(student);
					studScan.useDelimiter(",");
					recordNum = studScan.next();
					
					//Checks ID and if textFields are full
					if (txtID.getText().equals(studScan.next().trim())
							&& !txtID.getText().isEmpty()
							&& !txtFirstName.getText().isEmpty()
							&& !txtLastName.getText().isEmpty()
							&& !txtStreet.getText().isEmpty()
							&& !txtCity.getText().isEmpty()
							&& !txtState.getText().isEmpty()
							&& !txtZip.getText().isEmpty()) {
						
						//Updates the file
						try {
							studreader = new Scanner(new File(FILE));
							
							while (studreader.hasNext()) {
								student = studreader.nextLine();
								
								studScan = new Scanner(student);
								studScan.useDelimiter(",");
								
								//Use BufferWriter to write fixed-length strings to file (rewrites whole file)
								if (recordNum.equals(studScan.next())){
									if (recordNum.equals("1")) {
										try(BufferedWriter studWriter = new BufferedWriter(new FileWriter("StudentData.dat", false))) {
											studWriter.write(String.format("%1d", record) + ","
													+ String.format("%10s", txtID.getText()) + "," 
													+ String.format("%10s", txtFirstName.getText()) + ","
													+ String.format("%50s", txtLastName.getText()) + "," 
													+ String.format("%50s", txtStreet.getText()) + "," 
													+ String.format("%20s",txtCity.getText()) + ","
													+ String.format("%2s",txtState.getText()) + "," 
													+ String.format("%9s",txtZip.getText()) + "\n");
											
											record++;
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
									else {
										try(BufferedWriter studWriter = new BufferedWriter(new FileWriter("StudentData.dat", true))) {
											studWriter.write(String.format("%1d", record) + ","
													+ String.format("%10s", txtID.getText()) + "," 
													+ String.format("%10s", txtFirstName.getText()) + ","
													+ String.format("%50s", txtLastName.getText()) + "," 
													+ String.format("%50s", txtStreet.getText()) + "," 
													+ String.format("%20s",txtCity.getText()) + ","
													+ String.format("%2s",txtState.getText()) + "," 
													+ String.format("%9s",txtZip.getText()) + "\n");
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}
								else if (record == 1) {
									try(BufferedWriter studWriter = new BufferedWriter(new FileWriter("StudentData.dat", false))) {
										studWriter.write(student + "\n");
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								else {
									try(BufferedWriter studWriter = new BufferedWriter(new FileWriter("StudentData.dat", true))) {
										studWriter.write(student + "\n");
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								
								record++;
							}
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						
						//Clears the TextFields after updating
						txtID.clear();
						txtFirstName.clear();
						txtLastName.clear();
						txtStreet.clear();
						txtCity.clear();
						txtState.clear();
						txtZip.clear();
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	});
    }
}