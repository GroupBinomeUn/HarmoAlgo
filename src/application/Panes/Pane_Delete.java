package application.Panes;

import application.Classes.Global;
import application.Classes.People;
import javafx.scene.control.ComboBox;

public class Pane_Delete {
	public static void update(ComboBox<String> combo_delete) {
		combo_delete.getItems().clear();
		combo_delete.getItems().add("Sélectionnez une personne");
	
		for( People people : Global.peoples ) {
			combo_delete.getItems().add(Integer.toString(people.getId()) + " - " + people.getLastName() + " " + people.getFirstName());
		}
	
		combo_delete.getSelectionModel().selectFirst();
	}
	 
	public static void delete(ComboBox<String> combo_delete) {
		String idPeople = combo_delete.getValue();
		if (idPeople.contains(" - ")) {
			idPeople = idPeople.substring(0, idPeople.indexOf(" - "));
	    	People onePeople = new People();
	    	onePeople.deletePeople(idPeople);
	    	
	    	update(combo_delete);
		}
		
	}
}
