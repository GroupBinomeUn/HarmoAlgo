package application.Panes;

import application.Classes.Global;
import application.Classes.People;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Pane_Add {
	public static void numberTextField(TextField text) {
        try {
            int i = Integer.parseInt(text.getText());
        } catch (NumberFormatException nfe) {
        	text.setText("");
        }
	}
	
	public static void search(TextField searchPeople, TreeView<String> tr_viewPeoples) {
    	String name = "";
    	String nameInversed = "";
    	String tempSearch = searchPeople.getText().toLowerCase();
    	int tempLenght = tempSearch.length();
    	
    	//Delete peoples in TreeView
    	tr_viewPeoples.setRoot(null);
    	tr_viewPeoples.setShowRoot(false);
    	
// -------------------------------------------------------------------------------------- //
        //Add peoples in TreeView
        TreeItem<String> root = new TreeItem<>("Carnet d'adresses");
        root.setExpanded(true);
        
        for( People people : Global.peoples ) {
        	name = people.getLastName() + " " + people.getFirstName();
        	nameInversed = people.getFirstName() + " " + people.getLastName();
        	
        	if(tempLenght <= name.length() && tempLenght <= nameInversed.length()) {
        		name = name.substring(0,tempLenght).toLowerCase();
        		nameInversed = nameInversed.substring(0,tempLenght).toLowerCase();
        	}
        	
        	if ((tempSearch.equals(name)) || (tempSearch.equals(nameInversed))) {
        		TreeItem<String> rootItem = new TreeItem<>(people.getLastName() + " " + people.getFirstName());
		        rootItem.setExpanded(false);
		        if(people.getPhone() != "" && people.getPhone().length() > 1) {
		        	TreeItem<String> phone = new TreeItem<>("Téléphone : " + people.getPhone() + ".");
		        	rootItem.getChildren().add(phone);
		        }
		        if(people.getCity() != "" && people.getCity().length() > 1) {
		        	TreeItem<String> city = new TreeItem<>("Ville : " + people.getCity() + ".");
		        	rootItem.getChildren().add(city);
		        }
		        
		        root.getChildren().add(rootItem);
        	}
        }
        
        tr_viewPeoples.setRoot(root);
        tr_viewPeoples.setShowRoot(true);
// -------------------------------------------------------------------------------------- //
    }
    
    public static void update(TreeView<String> tr_viewPeoples) {
	    TreeItem<String> root = new TreeItem<>("Carnet d'adresses");
	    root.setExpanded(true);
	    
	    for( People people : Global.peoples ) {
	        TreeItem<String> rootItem = new TreeItem<>(people.getLastName() + " " + people.getFirstName());
	        rootItem.setExpanded(false);
	        
	        if(people.getPhone() != "" && people.getPhone().length() > 1) {
	        	TreeItem<String> phone = new TreeItem<>("Téléphone : " + people.getPhone() + ".");
	        	rootItem.getChildren().add(phone);
	        }
	        if(people.getCity() != "" && people.getCity().length() > 1) {
	        	TreeItem<String> city = new TreeItem<>("Ville : " + people.getCity() + ".");
	        	rootItem.getChildren().add(city);
	        }
	        
	        root.getChildren().add(rootItem);
	    }
	    
	    tr_viewPeoples.setRoot(root);
    }
    
    public static void add(TextField lastName, TextField firstName, TextField phone, TextField city, TextField postalCode, TextField address) {
    	String tempLastName = lastName.getText();
		String tempFirstName = firstName.getText();
		String tempPhone = phone.getText();
		String tempCity = city.getText();
		String tempPostalCode = postalCode.getText();
		String tempAddress = address.getText();
		
		if(tempLastName != "" && tempLastName.length() > 1 && tempFirstName != "" && tempFirstName.length() >1) {
			People onePeople = new People(0, tempLastName, tempFirstName, tempPhone, tempCity, tempPostalCode, tempAddress);
			onePeople.addPeople();
			
			lastName.clear();
			firstName.clear();
			phone.clear();
			city.clear();
			postalCode.clear();
			address.clear();
		}
		
		
		
    }
}
