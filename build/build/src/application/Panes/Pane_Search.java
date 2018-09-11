package application.Panes;

import java.util.ArrayList;

import application.Global;
import application.Classes.People;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Pane_Search {
	static public void search(TextField filter, ChoiceBox filterType, TableView<People> tb_viewPeoples) {
		String type = (String) filterType.getValue();
		
		String tempSearch = filter.getText();
    	int tempLenght = tempSearch.length();
    	
    	ArrayList<People>FilteredPeoples = new ArrayList<People>();
    	
    	if(tempLenght >= 1) {
			switch(type) {
				case  "Nom" :
					String lastName = "";
					
					for( People people : Global.peoples ) {
						lastName = people.getLastName();
						
						if(tempLenght <= lastName.length()) {
							lastName = lastName.substring(0,tempLenght).toLowerCase();
							
							if ((tempSearch.toLowerCase().equals(lastName))) {
				        		FilteredPeoples.add(people);
				        	}
			        	}
					}
					break;
					
				case "Prénom" :
					String firstName = "";
					
					for( People people : Global.peoples ) {
						firstName = people.getFirstName();
						
						if(tempLenght <= firstName.length()) {
							firstName = firstName.substring(0,tempLenght).toLowerCase();
							
							if ((tempSearch.toLowerCase().equals(firstName))) {
				        		FilteredPeoples.add(people);
				        	}
			        	}	
					}
					break;
					
				case "Téléphone" :
					String phone = "";
					
					for( People people : Global.peoples ) {
						phone = people.getPhone();
						
						if(tempLenght <= phone.length()) {
							phone = phone.substring(0,tempLenght);
							
							if ((tempSearch.equals(phone))) {
								FilteredPeoples.add(people);
							}
			        	}		        	
					}
					break;
					
				default :
					FilteredPeoples = Global.peoples;
					break;
			}
    	}
    	else {
    		FilteredPeoples = Global.peoples;
    	}
		observableList(FilteredPeoples, tb_viewPeoples);
	}
	
	static public void observableList(ArrayList<People> peoples, TableView<People> tb_viewPeoples) {
		ObservableList<People> listPeoples = FXCollections.observableArrayList(peoples);
		updateTable(listPeoples, tb_viewPeoples);
	}
	
	static public void updateTable(ObservableList<People> peoples, TableView<People> tb_viewPeoples) {

    	tb_viewPeoples.getColumns().clear();
    	tb_viewPeoples.getItems().clear();
    	tb_viewPeoples.setEditable(true);
    	
    	ObservableList<People> listPeoples = peoples;

    	TableColumn<People, String> lastName = new TableColumn<People, String>("Nom");
        TableColumn<People, String> firstName = new TableColumn<People, String>("Prénom");
        TableColumn<People, String> phone = new TableColumn<People, String>("Téléphone");
        TableColumn<People, String> city = new TableColumn<People, String>("Ville");
        TableColumn<People, String> postalCode = new TableColumn<People, String>("Code Postal");
        TableColumn<People, String> address = new TableColumn<People, String>("Adresse");

    	lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    	lastName.setCellFactory(TextFieldTableCell.<People> forTableColumn());
    	
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstName.setCellFactory(TextFieldTableCell.<People> forTableColumn());
        
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phone.setCellFactory(TextFieldTableCell.<People> forTableColumn());
        
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        city.setCellFactory(TextFieldTableCell.<People> forTableColumn());
        
        postalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        postalCode.setCellFactory(TextFieldTableCell.<People> forTableColumn());
        
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        address.setCellFactory(TextFieldTableCell.<People> forTableColumn());

        lastName.setMinWidth(80);
        firstName.setMinWidth(80);
        phone.setMinWidth(80);
        city.setMinWidth(100);
        postalCode.setMinWidth(40);
        address.setMinWidth(140);

        tb_viewPeoples.setItems(listPeoples);
        tb_viewPeoples.getColumns().addAll(lastName, firstName, phone, city, postalCode, address);
        
// ------------------------------------------------------------------------------ //
        lastName.setOnEditCommit((CellEditEvent<People, String> event) -> {
            TablePosition<People, String> pos = event.getTablePosition();
 
            String newLastName = event.getNewValue();
 
            int row = pos.getRow();
            People onePeople = event.getTableView().getItems().get(row);
 
            onePeople.setLastName(newLastName);
        });
        
        firstName.setOnEditCommit((CellEditEvent<People, String> event) -> {
            TablePosition<People, String> pos = event.getTablePosition();
 
            String newFirstName = event.getNewValue();
 
            int row = pos.getRow();
            People onePeople = event.getTableView().getItems().get(row);
 
            onePeople.setFirstName(newFirstName);
        });
        
        phone.setOnEditCommit((CellEditEvent<People, String> event) -> {
            TablePosition<People, String> pos = event.getTablePosition();
 
            String newPhone = event.getNewValue();
 
            int row = pos.getRow();
            People onePeople = event.getTableView().getItems().get(row);
 
            onePeople.setPhone(newPhone);
        });
        
        city.setOnEditCommit((CellEditEvent<People, String> event) -> {
            TablePosition<People, String> pos = event.getTablePosition();
 
            String newCity = event.getNewValue();
 
            int row = pos.getRow();
            People onePeople = event.getTableView().getItems().get(row);
 
            onePeople.setCity(newCity);
        });
        
        postalCode.setOnEditCommit((CellEditEvent<People, String> event) -> {
            TablePosition<People, String> pos = event.getTablePosition();
 
            String newPostalCode = event.getNewValue();
 
            int row = pos.getRow();
            People onePeople = event.getTableView().getItems().get(row);
 
            onePeople.setPostalCode(newPostalCode);
        });
        
        address.setOnEditCommit((CellEditEvent<People, String> event) -> {
            TablePosition<People, String> pos = event.getTablePosition();
 
            String newAddress = event.getNewValue();
 
            int row = pos.getRow();
            People onePeople = event.getTableView().getItems().get(row);
 
            onePeople.setAddress(newAddress);
        });
// ------------------------------------------------------------------------------ //            
	}
}
