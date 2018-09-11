package application.MenuItems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import application.Classes.Global;
import application.Classes.People;
import javafx.stage.FileChooser;

public class MI_Open {
	public static void open() {
		FileChooser open = new FileChooser();
		open.setTitle("Importation d'un carnet d'adresses");
		open.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
		open.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
		File openFile = open.showOpenDialog(null);
		
		if (openFile != null && Global.peoples.size() > 0) {
			String extension = open.selectedExtensionFilterProperty().get().getExtensions().get(0).substring(1);
			
			switch(extension) {
				case ".json" :
					readJSON(openFile);
					break;
					
				case ".xml" :
					break;
			}
		}
	}
	
	private static void readJSON(File file) {
        JsonParser parser = new JsonParser();
        
		JsonArray listPeoples =  new JsonArray();
		try {
			listPeoples = (JsonArray) parser.parse(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		} 
		catch (UnsupportedEncodingException e) {e.printStackTrace();}catch (JsonIOException e) {e.printStackTrace();}catch (JsonSyntaxException e) {e.printStackTrace();}catch (FileNotFoundException e) {e.printStackTrace();}

		  for (Object people : listPeoples)
		  {
		    JsonObject person = (JsonObject) people;

		    String lastName = person.get("lastName").toString().substring(1, person.get("lastName").toString().length()-1);
		    String firstName = person.get("firstName").toString().substring(1, person.get("firstName").toString().length()-1);
		    String phone = person.get("phone").toString().substring(1, person.get("phone").toString().length()-1);
		    String city = person.get("city").toString().substring(1, person.get("city").toString().length()-1);
		    String postalCode = person.get("postalCode").toString().substring(1, person.get("postalCode").toString().length()-1);
		    String address = person.get("address").toString().substring(1, person.get("address").toString().length()-1);
		    
		    People newPeople = new People(0,lastName, firstName, phone, city, postalCode, address);
		    newPeople.addPeople();
		  }
	}
}
