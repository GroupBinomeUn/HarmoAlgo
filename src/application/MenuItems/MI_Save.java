package application.MenuItems;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import application.Classes.Global;
import application.Classes.People;
import javafx.stage.FileChooser;

public class MI_Save {
	public static void save() {
		FileChooser save = new FileChooser();
		save.setTitle("Sauvegarde du carnet d'adresses");
		save.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
		save.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
		File saveFile = save.showSaveDialog(null);
		
		if (saveFile != null && Global.peoples.size() > 0) {
			String extension = save.selectedExtensionFilterProperty().get().getExtensions().get(0).substring(1);
			String list = "";
			
			switch(extension) {
				case ".json" :
					list = makeJSON();
					break;
					
				case ".xml" :
					list = makeXML();
					break;
			}
			
			try {
				FileOutputStream prepareFile = new FileOutputStream(saveFile);	
				OutputStreamWriter file = new OutputStreamWriter(prepareFile, "UTF-8");
				file.write(list);
				file.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static String makeJSON() {	
		
		Gson listPeoples = new GsonBuilder().create();
			String list = listPeoples.toJson(Global.peoples);
			return list;
	}
	
	private static String makeXML() {
		String listPeoples = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<peoples>\n";
		
		for(People people: Global.peoples) {
			listPeoples += "  <people>\n    <lastname>" + people.getLastName() + "</lastname>\n    <firstname>" + people.getFirstName() + "</firstname>\n    <phone>" + people.getPhone() + "</phone>\n    <city>" + people.getCity() + "</city>\n    <postalcode>" + people.getPostalCode() + "</postalcode>\n    <address>" + people.getAddress() + "</address>\n  </people>\n";
		}
		listPeoples += "</peoples>";
		return listPeoples;
	}
}
