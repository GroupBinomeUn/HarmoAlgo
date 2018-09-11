package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.Classes.Global;
import application.Classes.People;
import application.MenuItems.MI_Open;
import application.MenuItems.MI_Save;
import application.Panes.Pane_Add;
import application.Panes.Pane_Delete;
import application.Panes.Pane_Search;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Controller implements Initializable{

    @FXML
    Button btn_addPeople;
    @FXML
    Button btn_deletePeople;

    @FXML
    TextField txt_lastName;
    @FXML
    TextField txt_firstName;
    @FXML
    TextField txt_phone;
    @FXML
    TextField txt_city;
    @FXML
    TextField txt_postalCode;
    
    @FXML
    TextField txt_address;
    @FXML
    TextField txt_searchPeople;
    @FXML
    TextField txt_filterPeoples;
    
    @FXML
    Pane main;
    @FXML
    Pane addPeople;
    @FXML
    Pane deletePeople;
    @FXML
    Pane viewPeoples;
    
    @FXML
    TreeView<String> tr_viewPeoples;
    
    @FXML
    ComboBox<String> combo_deletePeople;
    
    @FXML 
    TableView<People> tb_viewPeoples;
    
    @FXML
    ChoiceBox<String> choiceBox_filterPeoples;
    
    public void limitInputPostalCode(KeyEvent event) {                       
    	 if(txt_postalCode.getText().length()>=5) {
    		 event.consume();
    	 }
	}
    public void onlyNumberPhone(KeyEvent event) {                                        
    	Pane_Add.numberTextField(txt_phone);
    }
    public void onlyNumberPostalCode(KeyEvent event) {                                        
    	Pane_Add.numberTextField(txt_postalCode);
    }  
    
    public void open(ActionEvent event) {
        MI_Open.open();
    }
    
    public void save(ActionEvent event) {
        MI_Save.save();
    }
    
	public void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
 // -------------------------------------------------------------------------------------- //    
    public void main(ActionEvent event) {
    	addPeople.setVisible(false);
        deletePeople.setVisible(false);
        viewPeoples.setVisible(false);
        
        main.setVisible(true);
    }
    public void pane_addPeople(ActionEvent event) {
        main.setVisible(false);
    	deletePeople.setVisible(false);
    	viewPeoples.setVisible(false);
    	
    	Pane_Add.update(tr_viewPeoples);
    	addPeople.setVisible(true);
    }
    public void pane_deletePeople(ActionEvent event) {
    	main.setVisible(false);
    	addPeople.setVisible(false); 
    	viewPeoples.setVisible(false);
        
    	Pane_Delete.update(combo_deletePeople);
        deletePeople.setVisible(true);
    }
    public void pane_viewPeoples(ActionEvent event) {
    	main.setVisible(false);
    	addPeople.setVisible(false); 
    	deletePeople.setVisible(false);
    	
    	choiceBox_filterPeoples.getItems().clear();
    	choiceBox_filterPeoples.getItems().add("Nom");
    	choiceBox_filterPeoples.getItems().add("Prénom");
    	choiceBox_filterPeoples.getItems().add("Téléphone");
    	choiceBox_filterPeoples.getSelectionModel().selectFirst();
        
    	Pane_Search.observableList(Global.peoples, tb_viewPeoples);
    	viewPeoples.setVisible(true);
    }
// -------------------------------------------------------------------------------------- //
    
    private void btn_addPeople(ActionEvent event) {
    	Pane_Add.add(txt_lastName, txt_firstName, txt_phone, txt_city, txt_postalCode, txt_address);
    	Pane_Add.update(tr_viewPeoples);
    }
    
    private void btn_deletePeople(ActionEvent event) {
	    Pane_Delete.delete(combo_deletePeople);  	
    }

    public void searchPeople(KeyEvent event) {
    	Pane_Add.search(txt_searchPeople, tr_viewPeoples);
    }
    
    public void filterPeoples(KeyEvent event) {
    	Pane_Search.search(txt_filterPeoples, choiceBox_filterPeoples, tb_viewPeoples);
    }
    public void typeFilterPeoples(ActionEvent event) {
    	Pane_Search.search(txt_filterPeoples, choiceBox_filterPeoples, tb_viewPeoples);
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        btn_addPeople.setOnAction(this::btn_addPeople);
        btn_deletePeople.setOnAction(this::btn_deletePeople);
    }

}
